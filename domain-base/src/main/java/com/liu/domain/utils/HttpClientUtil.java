package com.liu.domain.utils;

import com.liu.domain.config.ClientServiceUnavailableRetryStrategy;
import com.liu.domain.exception.CallRemoteAPIException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author ZYW
 */
@Component
public class HttpClientUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    private static CloseableHttpClient httpClient;

    private static ClientServiceUnavailableRetryStrategy retryStrategy;

    @Autowired
    public void setHttpClient(CloseableHttpClient httpClient){
        HttpClientUtil.httpClient = httpClient;
    }

    @Autowired
    public void setRetryStrategy(ClientServiceUnavailableRetryStrategy retryStrategy){
        HttpClientUtil.retryStrategy = retryStrategy;
    }

    private static RequestConfig requestConfig;

    @Autowired
    public void setRequestConfig(RequestConfig requestConfig){
        HttpClientUtil.requestConfig = requestConfig;
    }

    /**
     * 只处理http返回值为utf8文本类型的调用
     * @param builder
     * @return
     * @throws CallRemoteAPIException
     */
    public static String sendHttpGetCall(URIBuilder builder) {
        try {
            URI uri = builder.build();
            HttpGet httpget = new HttpGet(uri);

            return requestRemote(httpget);
        } catch (Exception e) {
            //e.printStackTrace();
            String message = StringUtils.isBlank(e.getMessage()) ? e.getCause().getMessage() : e.getMessage();
            LOGGER.error("processHttpCall failed:{}, {} ", builder, message);
            throw new CallRemoteAPIException(message,e);
        }
    }

    /**
     * 处理http Post请求
     * @param url post url
     * @param nvps post参数
     * @return
     */
    public static String sendHttpPostCall(String url, List<NameValuePair> nvps ) {
        try {
            //1.使用URIBuilder方式
            /*builder = new URIBuilder( url );
            for(NameValuePair param : nvps ){
                builder.setParameter( param.getName(), param.getValue() );
            }

            HttpPost httpPost = new HttpPost(builder.build());*/
            //2.使用设置Entity方式
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));

            return requestRemote(httpPost);
        } catch (Exception e) {
            String message = StringUtils.isBlank(e.getMessage()) ? e.getCause().getMessage() : e.getMessage();
            LOGGER.error("processHttpCall failed:{}, {} ", url, message);
            throw new CallRemoteAPIException(message,e);
        }
    }

    /**
     * 处理http Post请求
     * @param url post url
     * @param body post参数
     * @return
     */
    public static String sendHttpPostBody(String url, String body ) {
        try {
            StringEntity entity = new StringEntity(body);

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            return requestRemote(httpPost);
        } catch (Exception e) {
            String message = StringUtils.isBlank(e.getMessage()) ? e.getCause().getMessage() : e.getMessage();
            LOGGER.error("processHttpCall failed:{}, {} ", url, message);
            throw new CallRemoteAPIException(message,e);
        }
    }

    private static String requestRemote(HttpRequestBase httpMethod) throws IOException {
        CloseableHttpResponse response = null;

        try {
            httpMethod.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpMethod);

            StatusLine responseCode = response.getStatusLine();
            // 判断返回状态是否为200
            if (responseCode.getStatusCode() != HttpStatus.SC_OK) {
                LOGGER.error("processHttpCall failed: uri:{}, responseCode is, {} ", httpMethod.getURI(), responseCode.getStatusCode());
                throw new CallRemoteAPIException("responseCode:" + responseCode);
            }
            // 获取服务端返回的数据,并返回
            String result = retryStrategy.getResult();

            if(StringUtils.isBlank(result)) {
                result = StringUtils.trim(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }

            if(StringUtils.isBlank(result)){
                LOGGER.error("processHttpCall: no response, {} ", httpMethod.getURI());
                return "";
            }

            return result;
        } catch (IOException | ParseException e) {
            //e.printStackTrace();
            String message = e.getMessage() == null ? e.getCause().getMessage() : e.getMessage();
            LOGGER.error("error message:{} ", message);
            throw new CallRemoteAPIException(message);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    public static void uploadFile(String filePath,String url) throws Exception{
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000000).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));
        File file = new File(filePath);
        multipartEntityBuilder.addBinaryBody("file",file);
        multipartEntityBuilder.addTextBody("fileUpload", "fileUpload");
        HttpEntity httpEntity = multipartEntityBuilder.build();
        httpPost.setEntity(httpEntity);
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        //HttpEntity responseEntity = httpResponse.getEntity();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if(statusCode == 200){
            LOGGER.info("上传成功！");
        }
        httpClient.close();
        if(httpResponse != null){
            httpResponse.close();
        }

    }
}
