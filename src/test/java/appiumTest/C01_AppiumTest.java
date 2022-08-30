package appiumTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class C01_AppiumTest {

    @Test
    public void testAppium01() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel3");
        // cmd'ye emulator -list-avds => cihaz ismini bu kod sayesinde buluruz.
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        // cmd'ye adb shell getprop ro.build.version.release => version bulmak için
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\alkan\\IdeaProjects\\Appium\\src\\app\\Duolingo.apk");



        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

        WebElement getStarted = driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));
        System.out.println("Get Started Element Text : "+getStarted.getText());
        getStarted.click();

        WebElement english = driver.findElement(By.xpath("//*[@text=\"English\"]"));
        english.click();

        TouchAction touchAction = new TouchAction(driver);


        WebElement turkish = driver.findElement(By.xpath("//*[@text=\"Turkish\"]"));
        turkish.click();

        WebElement okButton = driver.findElement(By.id("android:id/button1"));
        okButton.click();

        WebElement jobOffers = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"work\"]/android.widget.TextView"));
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
