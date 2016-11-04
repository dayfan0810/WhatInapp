package com.hope.com.whatinapp.constants;

/**
 * Created by Day on 2016/8/11.
 */
public interface Urls {
    //接口中的成員變量都是常量，不用public static final
    String SERVER_URL = "http://10.0.2.2:8081/WhatinApp";
    String SERVER_UPDATE_URL = SERVER_URL+"/updateinfo.xml";
    //我把電腦的端口號改爲8081了，因爲占用了
}
