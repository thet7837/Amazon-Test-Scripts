package com.sysco.amazon.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static com.sysco.amazon.page.HomePage.syscoLabUIOgm;

public class CheckOutPage {
    private static Logger log = LogManager.getLogger();
    protected By txtBabyFashion = By.xpath("//h2[contains(@class, 'size-mini')]//a[contains(@class, 's-link-style')]");
    protected By drpDwnItemSize = By.xpath("//select[contains(@name, 'selected_size_name')]");
    protected By btnItemSize = By.xpath("//span[contains(@id, 'size_name')and contains(@class, 'text-swatch-button') ]");
    protected By btnQuantity = By.xpath("//div[@id='selectQuantity']//span[contains(@class, 'dropdown-container')]");
    protected By drpDwnQuantity = By.xpath("//li[contains(@aria-labelledby, 'quantity')]");
    protected By btnAddToCart = By.xpath("//input[@id= 'add-to-cart-button']");
    protected By btnCheckOut = By.xpath("//input[@data-feature-id= 'proceed-to-checkout-action']");
    protected By btnSignSecurely = By.xpath("//a[text()[normalize-space() = 'Sign in securely']]");
    protected By txtItemCount = By.xpath("//span[contains(@id, 'subtotal-item-count')]");

    //Select the Product
    public  void selectProduct(String item) {
        List<WebElement> listOfElements = syscoLabUIOgm.findElements(txtBabyFashion);
        for (WebElement element : listOfElements) {
            if (element.getText().equalsIgnoreCase(item)) {
                element.click();
                break;
            }
        }

    }

    //Select  Product Size
    public  void selectProductSize(String size) {
        if(syscoLabUIOgm.findElements( drpDwnItemSize ).size() == 0){
            List<WebElement> listOfQuantityElements = syscoLabUIOgm.findElements(btnItemSize);
            for (WebElement elementQuantity:listOfQuantityElements) {
                if( elementQuantity.getText().equalsIgnoreCase(size)){
                    elementQuantity.click();
                    break;

                }
            }

        }else {
            Select drpItemSize = new Select(syscoLabUIOgm.findElement(drpDwnItemSize));
            drpItemSize.selectByVisibleText(size);
        }

    }

    //Click Quantity Button
    public  void clickQuantity() {
        try {

            syscoLabUIOgm.waitTillElementLoaded(btnQuantity);

        } catch (Exception e) {

            log.info("Quantity button is not visible and yet to be loaded");
        }
        syscoLabUIOgm.moveToAndClick(btnQuantity);
    }

    //Select Quantity From DropDown
    public  void selectQuantity(String quantity) {
        List<WebElement> listOfQuantityElements = syscoLabUIOgm.findElements(drpDwnQuantity);
        for (WebElement elementQuantity:listOfQuantityElements) {
            if( elementQuantity.getText().equalsIgnoreCase(quantity)){
                elementQuantity.click();
                break;

            }
        }

    }

    //Click Add To Cart Button
    public  void clickAddToCart() {
        syscoLabUIOgm.click(btnAddToCart);
    }
    //Add To Cart Button Verification
    public boolean isDisplayedAddToCart() {
        syscoLabUIOgm.findElement(btnAddToCart);
        return  syscoLabUIOgm.isDisplayed(btnAddToCart);

    }
    //Click Checkout Button
    public  void clickCheckout(String quantity) {
        if(syscoLabUIOgm.findElements( btnCheckOut ).size() != 0){
            String size=syscoLabUIOgm.findElement(txtItemCount).getText();
            Assert.assertEquals(size,"Cart subtotal ("+quantity+" items):");
            syscoLabUIOgm.click(btnCheckOut);
        }else{
            syscoLabUIOgm.click(btnSignSecurely);

        }
    }
}
