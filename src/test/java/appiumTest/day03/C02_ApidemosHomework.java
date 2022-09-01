package appiumTest.day03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C02_ApidemosHomework {

    @Test
    public void testApiDemos() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\alkan\\IdeaProjects\\Appium\\src\\app\\apidemos.apk");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    /*
        1. Apidemos'a girilir
        2. Preference tıklanır
        3. Preference dependencies tıklanır
        4. WiFi check box aktif edilir.
        5. Wifi Settings tıklanır
        6. Gelen ekrana 'Appium çok güzel' yazılır ve OK tıklanır
        7. Tekrar tıklayıp yazılan cümleyi dogrulayıp konsola yazdırınız.
     */

        driver.findElementByAccessibilityId("Preference").click();
        driver.findElementByAccessibilityId("3. Preference dependencies").click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("//*[@text=\"WiFi settings\"]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Appium çok güzel");
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text=\"WiFi settings\"]")).click();

        WebElement textBox = driver.findElement(By.id("android:id/edit"));
        Assert.assertEquals("Appium çok güzel", textBox.getText());
        System.out.println(textBox.getText());

    }
}