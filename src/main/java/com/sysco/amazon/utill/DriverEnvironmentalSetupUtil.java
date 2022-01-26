package com.sysco.amazon.utill;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class DriverEnvironmentalSetupUtil {
    private final static String CHROME_DRIVER_PATH="src/main/resources/windows/chromedriver.exe";
    public  static String chromedriver="webdriver.chrome.driver";

    DriverEnvironmentalSetupUtil(){
    /*  Constructor */
    }

    public  static void setToRunLocally(){

        System.setProperty(chromedriver,CHROME_DRIVER_PATH);
        Logger.getLogger(System.getProperty(chromedriver));

    }
}
