package com.sysco.amazon.function;

import com.sysco.amazon.page.AmazonPage;


public class SearchAmazon {

    public static final AmazonPage amazonPage = new AmazonPage();

    public static void navigateToAmazon(String email,String category,String item,String size,String quantity){

        amazonPage.openAmazon();
        amazonPage.logoAmazonVerify();
        amazonPage.checkoutAmazon(category,item,size,quantity);
        amazonPage.errorEmailMessage(email);
    }

    public static  void quitDriver(){

        amazonPage.quitDriver();
    }


}
