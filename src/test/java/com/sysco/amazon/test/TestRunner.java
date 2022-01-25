package com.sysco.amazon.test;

import com.sysco.amazon.function.SearchAmazon;
import com.sysco.amazon.utill.DataUtil;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestRunner {
DataUtil testData=new DataUtil();
@BeforeTest
public void dataSet() throws IOException {
    testData.getAmazonData();
}
    @Test
    public void testAmazonSite(){
        SearchAmazon.navigateToAmazon(testData.getEmail(),testData.getCategory(),testData.getItem(),testData.getSize(),testData.getQuantityl());
        SearchAmazon.quitDriver();


    }

}
