package com.sysco.amazon.function;


import com.sysco.amazon.page.LoginPage;

public class Login {
    private static LoginPage loginPage = new  LoginPage ();

    private Login(){

    }
    //Enter Email Address
    public static void setEmail(String email) {
        loginPage.setEmail(email);

    }

    //Click Continue Button
    public static void clickContinueButton() {
        loginPage.clickContinue();

    }
    //Verify Continue Cart Button
    public static boolean continueIsDisplayed() {

        return loginPage.isDisplayedContinue();
    }

    //Verify Invalid Email Error Message
    public static void verifyEmailErrorMessage(String errormessage) {
        loginPage.verifyEmailErrorMessage(errormessage);

    }

}
