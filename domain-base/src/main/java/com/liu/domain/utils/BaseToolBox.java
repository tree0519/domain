package com.liu.domain.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ZYW
 * @date 2018/5/28
 */
public class BaseToolBox {
    private static final String GET_OPENID_URL = "https://api.weixin.qq.com/sns/jscode2session?grant_type=authorization_code";
    public static Map<String,String> getOpenId(String jsCode,String appId,String secret) {
        try {
            URIBuilder builder = new URIBuilder(GET_OPENID_URL);
            builder.addParameter("js_code",jsCode);
            builder.addParameter("appid",appId);
            builder.addParameter("secret",secret);
            String result = HttpClientUtil.sendHttpGetCall(builder);
            JSONObject jsonObject = JSON.parseObject(result);
            if(jsonObject.containsKey("openid")){
                return ImmutableMap.of("openid",jsonObject.getString("openid")
                        ,"session_key",jsonObject.getString("session_key")
                        ,"errmsg","");
            }else{
                return ImmutableMap.of("openid",""
                        ,"session_key",""
                        ,"errmsg",jsonObject.getString("errmsg"));
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 活得客户端IP
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    public static void main(String[] args) throws IOException {
        /*final String sql = "INSERT INTO etc_open_tollgate(`rec_id`,`name`,`is_weight`,`is_new`,`one`,`two`,`three`,`four`,`five`,`birthday`,`fl`,`lc`,`status`,`ins_time`,`chg_time`)";
        ObjectMapper om = new ObjectMapper();
        Map map = om.readValue(new File("E:\\无感支付\\ETC\\开放式收费站数据.json"), Map.class);
        ArrayList toll = (ArrayList)map.get("toll");
        for(Object obj : toll) {
            LinkedHashMap lhm = (LinkedHashMap)obj;
            String values = "values(";
            values += IdWorker.getIdStr() + ",";
            values += "'" + lhm.get("name") + "',";
            values += lhm.get("is_weight") + ",";
            values += lhm.get("is_new") + ",";
            values += lhm.get("one") + ",";
            values += lhm.get("two") + ",";
            values += lhm.get("three") + ",";
            values += lhm.get("four") + ",";
            values += lhm.get("five") + ",";
            values += "'" + lhm.get("birthday") + "',";
            values += lhm.get("fl") + ",";
            values += lhm.get("lc") + ",";
            values += "1,";
            values += "NOW(),";
            values += "NOW());";
            System.out.println(sql + " " + values);
        }*/

        /*final String sql = "INSERT INTO etc_close_tollgate(`rec_id`,`name`,`area`,`status`,`ins_time`,`chg_time`)";
        ObjectMapper om = new ObjectMapper();
        Map map = om.readValue(new File("E:\\无感支付\\ETC\\1.json"), Map.class);
        ArrayList toll = (ArrayList)map.get("result");
        for(Object obj : toll) {
            LinkedHashMap lhm = (LinkedHashMap)obj;
            String values = "values(";
            values += IdWorker.getIdStr() + ",";
            values += "'" + lhm.get("name") + "',";
            values += "'0900',";
            values += "1,";
            values += "NOW(),";
            values += "NOW());";
            System.out.println(sql + " " + values);
        }*/

        Map<String,String> nameAndNewId = new HashMap<>();
        nameAndNewId.put("火烧山主线","1037256169439121409");
        nameAndNewId.put("五彩湾匝道","1037256169439121410");
        nameAndNewId.put("红旗农场匝道","1037256169439121411");
        nameAndNewId.put("三台油库匝道","1037256169439121412");
        nameAndNewId.put("滋泥泉子匝道","1037256169439121413");
        nameAndNewId.put("南泉子主线","1037256169439121414");
        nameAndNewId.put("三台匝道","1037256169439121415");
        nameAndNewId.put("吉木萨尔匝道","1037256169439121416");
        nameAndNewId.put("泉子街匝道","1037256169439121417");
        nameAndNewId.put("奇台匝道","1037256169439121418");
        nameAndNewId.put("中心团场匝道","1037256169439121419");
        nameAndNewId.put("老奇台匝道","1037256169439121420");
        nameAndNewId.put("双涝坝匝道","1037256169439121421");
        nameAndNewId.put("木垒匝道","1037256169439121422");
        nameAndNewId.put("博斯坦匝道","1037256169439121423");
        nameAndNewId.put("大浪沙匝道","1037256169439121424");
        nameAndNewId.put("巴彦岱匝道","1037256677381918721");
        nameAndNewId.put("达达木图匝道","1037256677398695937");
        nameAndNewId.put("潘津匝道","1037256677398695938");
        nameAndNewId.put("伊宁县匝道","1037256677398695939");
        nameAndNewId.put("六十六团匝道","1037256677398695940");
        nameAndNewId.put("伊东工业园匝道","1037256677398695941");
        nameAndNewId.put("墩麻扎主线","1037256677398695942");
        nameAndNewId.put("惠远东主线","1037256677398695943");
        nameAndNewId.put("沙井子主线","1037256886535073794");
        nameAndNewId.put("沙井子匝道","1037256886535073795");
        nameAndNewId.put("启浪匝道","1037256886535073796");
        nameAndNewId.put("阿恰匝道","1037256886535073797");
        nameAndNewId.put("一间房匝道","1037256886535073798");
        nameAndNewId.put("三岔口匝道","1037256886535073799");
        nameAndNewId.put("三道班匝道","1037256886535073800");
        nameAndNewId.put("伽师总场匝道","1037256886535073801");
        nameAndNewId.put("西克尔匝道","1037256886535073802");
        nameAndNewId.put("大山口匝道","1037256886535073803");
        nameAndNewId.put("格达良匝道","1037256886535073804");
        nameAndNewId.put("阿图什东匝道","1037256886535073805");
        nameAndNewId.put("阿图什西匝道","1037256886535073806");
        nameAndNewId.put("阿扎克匝道","1037256886535073807");
        nameAndNewId.put("塔库提匝道","1037256886535073808");
        nameAndNewId.put("乌恰匝道","1037256886535073809");
        nameAndNewId.put("库曲湾匝道","1037256886535073810");
        nameAndNewId.put("麦盖提主线","1037256886535073811");
        nameAndNewId.put("牌楼匝道","1037256886535073812");
        nameAndNewId.put("塔吉克匝道","1037256886535073813");
        nameAndNewId.put("四十二团匝道","1037256886535073814");
        nameAndNewId.put("岳普湖匝道","1037256886535073815");
        nameAndNewId.put("江巴孜匝道","1037256886535073816");
        nameAndNewId.put("夏普吐勒匝道","1037256886535073817");
        nameAndNewId.put("阿克喀什匝道","1037256886535073818");
        nameAndNewId.put("喀什主线","1037256886535073819");
        nameAndNewId.put("巴楚匝道","1037256886535073820");
        nameAndNewId.put("阿克萨克马热勒匝道","1037256886564433921");
        nameAndNewId.put("色力布亚匝道","1037256886564433922");
        nameAndNewId.put("阿瓦提匝道","1037256886564433923");
        nameAndNewId.put("艾里西湖匝道","1037256886564433924");
        nameAndNewId.put("莎车北匝道","1037256886564433925");
        nameAndNewId.put("莎车西匝道","1037256886564433926");
        nameAndNewId.put("莎车主线","1037256886564433927");
        nameAndNewId.put("克南主线","1037257187841282050");
        nameAndNewId.put("西郊匝道","1037257187841282051");
        nameAndNewId.put("克西匝道","1037257187841282052");
        nameAndNewId.put("白碱滩匝道","1037257187841282053");
        nameAndNewId.put("百口泉匝道","1037257187841282054");
        nameAndNewId.put("乌尔禾匝道","1037257187841282055");
        nameAndNewId.put("和什托洛盖匝道","1037257187841282056");
        nameAndNewId.put("乌图布拉克匝道","1037257187841282057");
        nameAndNewId.put("巴音托海匝道","1037257187841282058");
        nameAndNewId.put("福海渔场匝道","1037257187841282059");
        nameAndNewId.put("福海匝道","1037257187841282060");
        nameAndNewId.put("阿尔达匝道","1037257187841282061");
        nameAndNewId.put("丰庆湖匝道","1037257187841282062");
        nameAndNewId.put("187团匝道","1037257187841282063");
        nameAndNewId.put("北屯匝道","1037257187841282064");
        nameAndNewId.put("切尔克齐匝道","1037257187841282065");
        nameAndNewId.put("塔斯塔克匝道","1037257187862253570");
        nameAndNewId.put("阿勒泰主线","1037257187862253571");
        nameAndNewId.put("哈图匝道","1037257187862253572");
        nameAndNewId.put("铁厂沟匝道(克塔)","1037257187862253573");
        nameAndNewId.put("乌雪特匝道","1037257187862253574");
        nameAndNewId.put("额敏东匝道","1037257187862253575");
        nameAndNewId.put("额敏匝道","1037257187862253576");
        nameAndNewId.put("团结农场匝道","1037257187862253577");
        nameAndNewId.put("塔城主线","1037257187862253578");
        nameAndNewId.put("乌苏东临时主线","1037257621767225345");
        nameAndNewId.put("乌苏东匝道","1037257621767225346");
        nameAndNewId.put("西大沟匝道","1037257621767225347");
        nameAndNewId.put("红星农场匝道","1037257621767225348");
        nameAndNewId.put("高泉匝道","1037257621767225349");
        nameAndNewId.put("古尔图匝道","1037257621767225350");
        nameAndNewId.put("托托匝道","1037257621767225351");
        nameAndNewId.put("沙泉子匝道","1037257621767225352");
        nameAndNewId.put("精河敖包匝道","1037257621767225353");
        nameAndNewId.put("精河匝道","1037257621767225354");
        nameAndNewId.put("八十三团匝道","1037257621767225355");
        nameAndNewId.put("大河沿子匝道","1037257621767225356");
        nameAndNewId.put("五台匝道","1037257621767225357");
        nameAndNewId.put("博乐岔口匝道","1037257621767225358");
        nameAndNewId.put("五台主线","1037257621767225359");
        nameAndNewId.put("乌拉泊匝道","1037257896297017346");
        nameAndNewId.put("甘泉堡主线","1037257896297017347");
        nameAndNewId.put("米东匝道","1037257896297017348");
        nameAndNewId.put("铁厂沟匝道(东绕)","1037257896297017349");
        nameAndNewId.put("甘沟匝道","1037257896297017350");
        nameAndNewId.put("石人子沟匝道","1037257896297017351");
        nameAndNewId.put("观园路匝道","1037257896297017352");
        nameAndNewId.put("乌拉泊北匝道","1037257896297017353");
        nameAndNewId.put("乌拉泊西主线","1037257896297017354");
        nameAndNewId.put("乌拉泊南匝道","1037257896297017355");
        nameAndNewId.put("延安路匝道","1037257896297017356");
        nameAndNewId.put("白山泉主线","1037258159414132737");
        nameAndNewId.put("白山泉匝道","1037258159414132738");
        nameAndNewId.put("镜儿泉匝道","1037258159414132739");
        nameAndNewId.put("工业园匝道","1037258159414132740");
        nameAndNewId.put("骆驼圈子主线","1037258159414132741");

        final String sql = "INSERT INTO etc_close_tollgate_lc(`rec_id`,`entry_id`,`entry_name`,`exit_id`,`exit_name`,`one`,`two`,`three`,`four`,`five`,`fl`,`lc`,`status`,`ins_time`,`chg_time`)";
        ObjectMapper om = new ObjectMapper();
        Map map = om.readValue(new File("E:\\无感支付\\ETC\\1.json"), Map.class);
        ArrayList toll = (ArrayList)map.get("result");
        for(Object obj : toll) {
            LinkedHashMap lhm = (LinkedHashMap)obj;
            String values = "values(";
            values += IdWorker.getIdStr() + ",";
            String entry = String.valueOf(lhm.get("entry"));
            int index1 = entry.lastIndexOf("(");
            String entryName = entry.substring(0, index1);
            values += nameAndNewId.get(entryName) + ",";
            values += "'" + entryName + "',";
            String name = String.valueOf(lhm.get("name"));
            int index2 = name.lastIndexOf("(");
            String exitName = name.substring(0, index2);
            values += nameAndNewId.get(exitName) + ",";
            values += "'" + exitName + "',";
            values += lhm.get("one") + ",";
            values += lhm.get("two") + ",";
            values += lhm.get("three") + ",";
            values += lhm.get("four") + ",";
            values += lhm.get("five") + ",";
            values += lhm.get("fl") + ",";
            values += lhm.get("lc") + ",";
            values += "1,";
            values += "NOW(),";
            values += "NOW());";
            System.out.println(sql + " " + values);
        }

    }
}
