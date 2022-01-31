package com.sysco.amazon.function;

import com.sysco.amazon.page.CheckOutPage;

public class CheckOut {

    private  CheckOut(){

    }
    public static final CheckOutPage checkoutpage = new CheckOutPage();

    //Select Product
    public static void selectProduct(String product) {
        checkoutpage.selectProduct(product);

    }

    //Select Size
    public static void selectSize(String size) {
        checkoutpage.selectProductSize(size);

    }

    //Select Quantity
    public static void selectQuantity(String quantity) {
        checkoutpage.clickQuantity();
        checkoutpage.selectQuantity(quantity);

    }

    //Click Add To Cart Button
    public static void clickAddToCart() {
        checkoutpage.clickAddToCart();

    }
    //Verify Add To Cart Button
    public static boolean addToCartIsDisplayed() {

        return checkoutpage.isDisplayedAddToCart();
    }


    //Click Checkout Button
    public static void clickCheckout(String quantity) {
        checkoutpage.clickCheckout(quantity);

    }

}
