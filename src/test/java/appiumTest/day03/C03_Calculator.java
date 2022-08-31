package appiumTest.day03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C03_Calculator {

    @Test
    public void testCalculator() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement menuButton = driver.findElementByAccessibilityId("Apps");
        menuButton.click();

        WebElement calculator = driver.findElementByAccessibilityId("Calculator");
        calculator.click();

        WebElement eight = driver.findElement(By.id("com.android.calculator2:id/digit_8"));
        eight.click();

        WebElement multiply = driver.findElementByAccessibilityId("multiply");
        multiply.click();

        WebElement seven = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
        seven.click();

        WebElement equals = driver.findElementByAccessibilityId("equals");
        equals.click();

        WebElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
        System.out.println("Result = "+result.getText());

    }
}
