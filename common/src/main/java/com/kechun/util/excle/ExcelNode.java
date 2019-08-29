package com.kechun.util.excle;

import lombok.Data;

import java.util.Map;

/**
 * excle节点
 */
@Data
public class ExcelNode {
    private int sheet; //sheet页

    // 第一个map key 是 row 多少行，第二个map key是cell 多少列，vlaue 是值
    private Map<Integer,Map<Integer,String>> value;

    //设置多个sheet页，第一个map key 是sheet页，第二个map key 是 row 多少行，第三个map key是cell 多少列，vlaue 是值
    private Map<Integer, Map<Integer,Map<Integer,String>>> setSheets;
}