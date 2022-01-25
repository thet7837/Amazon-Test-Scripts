package com.sysco.amazon.utill;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUtil {
    protected static String email;
    protected static String category;
    protected static String item;
    protected static String size;
    protected static String quantity;
    protected static FileInputStream fs;


    public static void getAmazonData() throws IOException {

        Properties prop = new Properties();
        fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\AmazonTestData.properties");
        prop.load(fs);

        email = prop.getProperty("email");
        category = prop.getProperty("category");
        item=prop.getProperty("item");
        size=prop.getProperty("size");
        quantity=prop.getProperty("quantity");
    }

    public String getEmail() {

        return email;
    }
    public String getCategory() {

        return category;
    }
    public String getSize() {

        return  size;
    }
    public String getQuantityl() {

        return quantity;
    }
    public String getItem() {

        return item;
    }
}
