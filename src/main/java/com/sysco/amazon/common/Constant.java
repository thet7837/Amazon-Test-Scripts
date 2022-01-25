package com.sysco.amazon.common;


public class Constant {

    public final static String App_URL=System.getProperty("app.url","https://www.amazon.com/");
    public final static String USER_EMAIL=System.getProperty("email","yunsn@hm");
    public static final boolean RUN_LOCALLY = Boolean.parseBoolean(System.getProperty("run.locally", "true"));



}
