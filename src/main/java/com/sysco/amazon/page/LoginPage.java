package com.sysco.amazon.page;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.sysco.amazon.page.HomePage.syscoLabUIOgm;

public class LoginPage {

    protected By txtEmail = By.id("ap_email");
    protected By btnContinue    = By.xpath("//input[@id='continue']");
    protected By txtErrorMessage = By.xpath("//span[@class= 'a-list-item']");

    //Enter Invalid email Address
    public void setEmail(String email){

        syscoLabUIOgm.click(txtEmail);
        syscoLabUIOgm.sendKeys(txtEmail,email);
    }

    //Click Continue Button
    public void clickContinue(){
        syscoLabUIOgm.click(btnContinue);

    }

    //Continue Button Verification
    public boolean isDisplayedContinue() {
        syscoLabUIOgm.findElement(btnContinue);
        return  syscoLabUIOgm.isDisplayed(btnContinue);

    }

    //Verify Invalid Email Error Message
    public void verifyEmailErrorMessage(String errormessage){
        System.out.println("Test"+errormessage);
        String actualerrormessage=  syscoLabUIOgm.findElement(txtErrorMessage).getText();
        Assert.assertEquals( actualerrormessage,errormessage);

    }
}
