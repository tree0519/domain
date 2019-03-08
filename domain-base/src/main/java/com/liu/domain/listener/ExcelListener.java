package com.liu.domain.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 监听类，可以自定义
 * @Date 2018-06-05
 * @Time 16:58
 */
public class ExcelListener extends AnalysisEventListener {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private ArrayList<List<String>> datas = new ArrayList<>();

    /**
     * 通过 AnalysisContext 对象还可以获取当前 sheet，当前行等数据
     */
    @Override
    public void invoke(Object object, AnalysisContext context) {
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        if (null !=object && StringUtils.isNotBlank(object.toString())){
            ArrayList<String> result =(ArrayList<String>)object;
            datas.add(result);
            //根据自己业务做处理
        }

    }

    private void doSomething(Object object) {
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        /*
            datas.clear();
            解析结束销毁不用的资源
         */
    }

    public ArrayList<List<String>> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<List<String>> datas) {
        this.datas = datas;
    }


}