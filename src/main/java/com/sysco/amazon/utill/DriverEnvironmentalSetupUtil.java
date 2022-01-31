package com.sysco.amazon.utill;



import com.sysco.amazon.common.Constant;
import com.sysco.amazon.page.HomePage;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Logger;

import static com.sysco.amazon.page.HomePage.syscoLabUIOgm;

public class DriverEnvironmentalSetupUtil {
    private static org.apache.logging.log4j.Logger log = LogManager.getLogger();
    private final static String CHROME_DRIVER_PATH="src/main/resources/windows/chromedriver.exe";
    public  static String chromedriver="webdriver.chrome.driver";

    DriverEnvironmentalSetupUtil(){
    /*  Constructor */
    }

    public  static void setToRunLocally(){

        System.setProperty(chromedriver,CHROME_DRIVER_PATH);
        Logger.getLogger(System.getProperty(chromedriver));
        DesiredCapabilities capabilities = null;
        loadLandingPage(capabilities, Constant.APP_URL);

    }
    public static void loadLandingPage(Capabilities capabilities, String url) {

        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        //syscoLabUIOgm.driver.manage().window().maximize();
        SyscoLabUI.driver.manage().window().maximize();


    }
    //Driver Close
    public static void quitDriver() {

        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
            log.info("Close the Driver");

        }
    }
}
