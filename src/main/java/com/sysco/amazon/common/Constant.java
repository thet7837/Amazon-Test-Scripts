package com.sysco.amazon.common;


public class Constant {

    public static final String APP_URL=System.getProperty("app.url","https://www.amazon.com/");
    public static final String USER_EMAIL=System.getProperty("email","yunsn@hm");
    public static final String LOGO_NOT_EXIST="Amazon Logo not found";
    public static final String CATEGORY_NOT_EXIST="Category DropDown not found";
    public static final String ADDTOCART_NOT_EXIST="Add To cart Button not found";
    public static final String CONTINUE_NOT_EXIST="Continue Button not found";
    public static final boolean RUN_LOCALLY = Boolean.parseBoolean(System.getProperty("run.locally", "true"));

    private Constant(){

    }

}
