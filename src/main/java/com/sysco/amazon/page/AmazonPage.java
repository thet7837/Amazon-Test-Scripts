package com.sysco.amazon.page;

import com.sysco.amazon.common.Constant;
import com.sysco.amazon.utill.DriverEnvironmentalSetupUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class AmazonPage {
    public static SyscoLabUI syscoLabUI;
    private static Logger log = LogManager.getLogger();
    protected By lblAmazonLogo = By.xpath("//div[@id='nav-logo']");
    protected By btnSign    = By.xpath("//span[contains(@id, 'accountList-nav')]");
    protected By btnContinue    = By.xpath("//input[@id='continue']");
    protected By txtEmail = By.id("ap_email");
    protected By txtErrorMessage = By.xpath("//span[@class= 'a-list-item']");
    protected By drpDwnItemCategory = By.xpath("//select[contains(@class, 'nav-search-dropdown')]");
    protected By btnSearch    = By.xpath("//input[@value= 'Go']");
    protected By btnBabyFashion    = By.xpath("//a[@title= 'Baby Girls (0-24m)']");
    protected By txtBabyFashion = By.xpath("//h2[contains(@class, 'size-mini')]//a[contains(@class, 's-link-style')]");
    protected By btnItemSize = By.xpath("//span[contains(@id, 'size_name')and contains(@class, 'text-swatch-button') ]");
    protected By drpDwnItemSize = By.xpath("//select[contains(@name, 'selected_size_name')]");
    //protected By drpDwnQuantity = By.xpath("//select[@name= 'quantity']");
    protected By drpDwnQuantity = By.xpath("//li[contains(@aria-labelledby, 'quantity')]");
    protected By btnQuantity = By.xpath("//div[@id='selectQuantity']//span[contains(@class, 'dropdown-container')]");
    protected By btnAddToCart = By.xpath("//input[@id= 'add-to-cart-button']");
    protected By txtItemCount = By.xpath("//span[contains(@id, 'subtotal-item-count')]");
    protected By btnCheckOut = By.xpath("//input[@data-feature-id= 'proceed-to-checkout-action']");
    protected By btnSignSecurely = By.xpath("//a[text()[normalize-space() = 'Sign in securely']]");

    //Open the Amazon WebSite
    public void openAmazon() {
        if (Constant.RUN_LOCALLY) {
            DriverEnvironmentalSetupUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            syscoLabUI = new SyscoLabWUI(capabilities);
            syscoLabUI.navigateTo(Constant.App_URL);
            syscoLabUI.driver.manage().window().maximize();

        }


    }
    //Check the Amazon Log
    public void logoAmazonVerify(){
        boolean logoPresent =syscoLabUI.findElement(lblAmazonLogo).isDisplayed();
        Assert.assertEquals(true,logoPresent);

    }

    //Check the Error message when input the Invalid Email Address
    public void errorEmailMessage(String email){
        //  syscoLabUI.click(btnSign);
        syscoLabUI.click(txtEmail);
        syscoLabUI.sendKeys(txtEmail,email);
        log.info("Entered the username");
        syscoLabUI.click(btnContinue);
        String ErrorMessage=  syscoLabUI.findElement(txtErrorMessage).getText();
        String ExpectError="We cannot find an account with that email address";
        Assert.assertEquals(ErrorMessage, ExpectError);
    }

    //Amazon Shopping Cart Flow Verification
    public void checkoutAmazon(String category,String item,String size,String quantity) {
        syscoLabUI.click(drpDwnItemCategory);
        Select drpItem = new Select(syscoLabUI.findElement(drpDwnItemCategory));
        drpItem.selectByVisibleText(category);
        syscoLabUI.click(btnSearch);
        syscoLabUI.click(btnBabyFashion);
        commonDropDownElementSelection(txtBabyFashion,item);

        if(syscoLabUI.findElements( drpDwnItemSize ).size() == 0){
            commonDropDownElementSelection(btnItemSize,size);

        }else {
            Select drpItemSize = new Select(syscoLabUI.findElement(drpDwnItemSize));
            drpItemSize.selectByVisibleText(size);
        }
        syscoLabUI.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        syscoLabUI.click(btnQuantity);
        commonDropDownElementSelection(drpDwnQuantity,quantity);
        syscoLabUI.click(btnAddToCart);

        if(syscoLabUI.findElements( btnCheckOut ).size() != 0){
            String Size=syscoLabUI.findElement(txtItemCount).getText();
            Assert.assertEquals(Size,"Cart subtotal ("+quantity+" items):");
            syscoLabUI.click(btnCheckOut);
        }else{
            syscoLabUI.click(btnSignSecurely);

        }


    }

//Common Function that used to select the DRopDown Element
    public void commonDropDownElementSelection(By drpDwnElement,String value){
        List<WebElement> listOfQuantityElements = syscoLabUI.findElements(drpDwnElement);
        for (WebElement elementQuantity:listOfQuantityElements) {
            System.out.println(elementQuantity.getText());
            if( elementQuantity.getText().equalsIgnoreCase(value)){
                elementQuantity.click();
                break;

            }
        }
    }

    public void quitDriver() {

        syscoLabUI.quit();
    }
}
