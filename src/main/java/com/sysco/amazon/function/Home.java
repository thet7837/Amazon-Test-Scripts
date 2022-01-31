package com.sysco.amazon.function;

import com.sysco.amazon.common.Constant;
import com.sysco.amazon.page.HomePage;
import com.sysco.amazon.utill.DriverEnvironmentalSetupUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Home {

    private static HomePage homePage = new  HomePage ();
    private  Home(){

    }


    //Verify Logo
    public static boolean logoIsDisplayed() {


        return homePage.isDisplayedLogo();
    }

    //Select Category
    public static void selectCategory(String category) {
        homePage.clickCategory();
        homePage.selectCategory(category);

    }
    //Verify select Category
    public static boolean categoryIsDisplayed() {


        return homePage.isDisplayedCategory();
    }

    //Search Category
    public static void searchCategory() {
        homePage.clickSearch();


    }


}
