package com.utils;

public class GetRootPath {
    public static String RootPathImg(){
        return Thread.currentThread().getContextClassLoader().getResource("").getPath().split("target")[0]+"src\\main\\webapp\\resources\\img\\";
    }
    public static String RootPathImg_(){
        return Thread.currentThread().getContextClassLoader().getResource("").getPath().split("WEB-INF")[0]+"resources\\img\\";
    }
}