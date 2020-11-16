package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action extends Base {

    public static void waitForPresence(AppiumDriver driver, MobileElement mobileElement, int timeLimitInSeconds){
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
