package appiumTest.day05;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class C01_Browserstack_Dualingo {

    public static String userName = "dantejugking_GhfdNs";
    public static String accessKey = "BGYJN4sEmqyhogyhCX4n";

    @Test
    public void browserstack01() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("networkLogs", "true");

        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy M52");
        capabilities.setCapability("app", "bs://53ed854d92aa7d90c8da8a581384f83df46e64c1");


        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement> (new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement getStarted = driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));
        System.out.println("Get Started Element Text : "+getStarted.getText());
        getStarted.click();

        WebElement english = driver.findElement(By.xpath("//*[@text=\"English\"]"));
        english.click();

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(881, 1870))
                .moveTo(PointOption.point(874, 230))
                .release()
                .perform();

        WebElement turkish = driver.findElement(By.xpath("//*[@text=\"Turkish\"]"));
        turkish.click();

        WebElement okButton = driver.findElement(By.id("android:id/button1"));
        okButton.click();

        WebElement jobOffers = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"work\"]"));
        jobOffers.click();

        WebElement serious = driver.findElement(By.id("com.duolingo:id/xpGoalOptionSerious"));
        serious.click();

        WebElement continueButton = driver.findElement(By.id("com.duolingo:id/xpGoalContinueButton"));
        continueButton.click();

        WebElement aLittleBit = driver.findElement(By.id("com.duolingo:id/placementHeader"));
        aLittleBit.click();

        WebElement testeBasla = driver.findElement(By.id("com.duolingo:id/primaryButton"));
        Assert.assertTrue(testeBasla.isDisplayed());

    }
}
