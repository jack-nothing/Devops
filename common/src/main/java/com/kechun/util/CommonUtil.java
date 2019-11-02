package com.kechun.util;

import com.alibaba.fastjson.JSONObject;

public class CommonUtil {


    public String[] getProvince_city(){
        String reslut = "";
//        String reslut = HttpClientUtil.getInstance().httpRequestUtils("https://api.map.baidu.com/location/ip","&ak=xxxxxxx");
        System.out.println(reslut);
        JSONObject jsonObject = JSONObject.parseObject(reslut);
        int status = Integer.parseInt(jsonObject.get("status")+"");
        if(status == 0){
            JSONObject jSONObject = (JSONObject)jsonObject.get("content");
            JSONObject jSONObject2 = (JSONObject)jSONObject.get("address_detail");
            String province = (String)jSONObject2.get("province");
            String city = (String)jSONObject2.get("city");
            System.out.println(province+","+city);
        }
        return null;
    }
}