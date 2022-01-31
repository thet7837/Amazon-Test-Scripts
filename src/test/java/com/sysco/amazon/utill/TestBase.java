package com.sysco.amazon.utill;

import com.sysco.amazon.function.Home;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class TestBase {
    DataUtil testData=new DataUtil();
    DriverEnvironmentalSetupUtil pagesetup=new DriverEnvironmentalSetupUtil();

    @BeforeTest
    public void dataSet() throws IOException {
        testData.getData();
        pagesetup.setToRunLocally();

    }
    @AfterClass
    public void quitDriver() {
        pagesetup.quitDriver();

    }
}
