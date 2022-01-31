package com.sysco.amazon.test;

import com.sysco.amazon.common.Constant;
import com.sysco.amazon.function.*;
import com.sysco.amazon.utill.DataUtil;
import com.sysco.amazon.utill.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTests extends TestBase {
    DataUtil testData=new DataUtil();
    SoftAssert softAssertion= new SoftAssert();

    @Test
    public void testAmazonSite(){

        Home.logoIsDisplayed();
        softAssertion.assertTrue(Home.logoIsDisplayed(), Constant.LOGO_NOT_EXIST);
        Home.selectCategory(testData.getCategory());
        Home.searchCategory();
        FeaturedCategory.clickFeaturedCategoryButton();

    }

    @Test(dependsOnMethods = "testAmazonSite")
    public void testCheckoutFlow(){

        CheckOut.selectProduct(testData.getItem());
        CheckOut.selectSize(testData.getSize());
        CheckOut.selectQuantity(testData.getQuantity());
        softAssertion.assertTrue(CheckOut.addToCartIsDisplayed(), Constant.ADDTOCART_NOT_EXIST);
        CheckOut.clickAddToCart();
        CheckOut.clickCheckout(testData.getQuantity());
        softAssertion.assertAll();

    }

    @Test(dependsOnMethods = "testCheckoutFlow")
    public void testInvalidEmailErrorMessage(){

        Login.setEmail(testData.getEmail());
        softAssertion.assertTrue(Login.continueIsDisplayed(), Constant.CONTINUE_NOT_EXIST);
        Login.clickContinueButton();
        Login.verifyEmailErrorMessage(testData.getErrormessage());
        softAssertion.assertAll();

    }

}
