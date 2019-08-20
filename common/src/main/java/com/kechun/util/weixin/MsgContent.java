package com.kechun.util.weixin;

import com.mycommon.config.Contants;

import java.util.Map;

public class MsgContent {
    //    <xml>  <ToUserName>< ![CDATA[toUser] ]></ToUserName>  <FromUserName>< ![CDATA[fromUser] ]></FromUserName>  <CreateTime>1348831860</CreateTime>
// <MsgType>< ![CDATA[text] ]></MsgType>  <Content>< ![CDATA[this is a test] ]></Content>  <MsgId>1234567890123456</MsgId>  </xml>

    public String handler(Map<String, String> map) {
        String msgType = map.get("MsgType");
        if(Contants.EVENT.equals(msgType)){





        }else if(Contants.IMAGE.equals(msgType)){

        }else if(Contants.LINK.equals(msgType)){

        }else if(Contants.NEWS.equals(msgType)){

        }else if(Contants.TEXT.equals(msgType)){



        }



        return null;
    }


}
