package com.sysco.amazon.page;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {

    public static SyscoLabUI syscoLabUIOgm;

    protected By lblAmazonLogo = By.xpath("//div[@id='nav-logo']");
    protected By drpDwnItemCategory = By.xpath("//select[contains(@class, 'nav-search-dropdown')]");
    protected By btnSearch    = By.xpath("//input[@value= 'Go']");



    //Logo Verification
    public boolean isDisplayedLogo() {
        syscoLabUIOgm.findElement(lblAmazonLogo);
        return  syscoLabUIOgm.isDisplayed(lblAmazonLogo);

    }

    //Click Category Selection Dropdown
    public  void clickCategory() {
        syscoLabUIOgm.click(drpDwnItemCategory);

    }
    //Category Selection Dropdown Verification
    public boolean isDisplayedCategory() {
       syscoLabUIOgm.findElement(drpDwnItemCategory);
        return  syscoLabUIOgm.isDisplayed(drpDwnItemCategory);

    }
    //Select Category From Dropdown
    public  void selectCategory(String category) {
        Select drpItem = new Select(syscoLabUIOgm.findElement(drpDwnItemCategory));
        drpItem.selectByVisibleText(category);

    }

    //Click Search Button
    public  void clickSearch() {
        syscoLabUIOgm.click(btnSearch);

    }

}
