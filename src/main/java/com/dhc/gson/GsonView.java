package com.dhc.gson;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by DuHongcai on 2016/10/19.
 */
public class GsonView extends org.springframework.web.servlet.view.AbstractView {
    private int responseStatuse = HttpStatus.OK.value();

    private String jsonObjectName;
    private SerializerFeature[] features;

    public GsonView(){}

    public GsonView(String jsonObjectName){super(); this.jsonObjectName = jsonObjectName;}

    public GsonView(String jsonObjectName,SerializerFeature[] features){
        super();
        this.jsonObjectName = jsonObjectName;
        this.features = features;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setStatus(getResponseStatuse());
        response.setContentType(getContentType());

        Object object =(jsonObjectName==null ? model:model.get(jsonObjectName));
        String jsonStr = "";
        if (features == null){
            jsonStr = JSON.toJSONString(object);
        }else{
            jsonStr = JSON.toJSONString(object,features);
        }
        PrintWriter out = response.getWriter();
        out.write(jsonStr);
        out.flush();
    }

    public String getContentType(){
        return "text/html;charset=utf-8";
    }


    public int getResponseStatuse() {
        return responseStatuse;
    }

    public void setResponseStatuse(int responseStatuse) {
        this.responseStatuse = responseStatuse;
    }

    public String getJsonObjectName() {
        return jsonObjectName;
    }

    public void setJsonObjectName(String jsonObjectName) {
        this.jsonObjectName = jsonObjectName;
    }

    public SerializerFeature[] getFeatures() {
        return features;
    }

    public void setFeatures(SerializerFeature[] features) {
        this.features = features;
    }
}
