package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    private static AppiumDriver<MobileElement> myDriver;

    @BeforeTest()
    public void launchApplication() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Moto G6");
        capabilities.setCapability("uid","ZF6222DZ3Q");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","9");

        capabilities.setCapability("appPackage","com.google.android.calculator");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        myDriver = new AppiumDriver<MobileElement>(url,capabilities);

        System.out.println("Application Started ....");
    }

    @Test()
    public void calculatorTest() throws InterruptedException {
        Action.waitForPresence(myDriver,myDriver.findElement(By.id("com.google.android.calculator:id/digit_1")),3);
        myDriver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();

        Action.waitForPresence(myDriver,myDriver.findElement(By.id("com.google.android.calculator:id/op_add")),3);
        myDriver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        Action.waitForPresence(myDriver,myDriver.findElement(By.id("com.google.android.calculator:id/digit_2")),3);
        myDriver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        Action.waitForPresence(myDriver,myDriver.findElement(By.id("com.google.android.calculator:id/eq")),3);
        myDriver.findElement(By.id("com.google.android.calculator:id/eq")).click();


        Action.waitForPresence(myDriver,myDriver.findElement(By.id("com.google.android.calculator:id/result_final")),3);
        String strResult = myDriver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals("3",strResult);
    }

    @AfterTest
    public void tearDown(){
        myDriver.quit();
        System.out.println("Execution completed ....");
    }
}
