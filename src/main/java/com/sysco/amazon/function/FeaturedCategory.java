package com.sysco.amazon.function;


import com.sysco.amazon.page.FeaturedCategoryPage;

public class FeaturedCategory {

private FeaturedCategory(){

}
    public static final FeaturedCategoryPage featuredcategorypage = new FeaturedCategoryPage();


    //Select the Featured category
    public static void clickFeaturedCategoryButton(){
        featuredcategorypage.clickFeatureCategory();

    }

}
