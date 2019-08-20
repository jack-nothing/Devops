package com.kechun.conf;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class ContentSet {

    //{500:服务器异常,200:成功,特别需要可以添加返回值499,498,497}
    private int statusCode;

    //具体返回结果
    private Object content;

    //提示信息或者错误信息
    private String message;

    public static ContentSet getContentSet(int statusCode,Object content,String message){
        return ContentSet.builder().message(message).statusCode(statusCode).content(content).build();
    }

}
