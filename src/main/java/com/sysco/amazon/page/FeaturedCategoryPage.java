package com.sysco.amazon.page;

import org.openqa.selenium.By;

import static com.sysco.amazon.page.HomePage.syscoLabUIOgm;

public class FeaturedCategoryPage {
    protected By btnBabyFashion    = By.xpath("//a[@title= 'Baby Girls (0-24m)']");


    //Click feature category Button
    public  void clickFeatureCategory() {
        syscoLabUIOgm.click(btnBabyFashion);

    }

}
