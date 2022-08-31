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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_APIDemos {

    @Test
    public void testApiDemos() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\alkan\\IdeaProjects\\Appium\\src\\app\\apidemos.apk");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

/*
    1. Apidemos'u açıyoruz
    2. Views'a tıklıyoruz
    3. Expandable Lists'e tıklıyoruz
    4. Custom Adapter'a tıklıyoruz
    5. People Names'e tıklayıp isimleri alıyoruz
 */

        WebElement views = driver.findElementByAccessibilityId("Views");
        views.click();

        WebElement expandableLists = driver.findElementByAccessibilityId("Expandable Lists");
        expandableLists.click();

        WebElement customAdapter = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[1]"));
        customAdapter.click();

        WebElement peopleNames = driver.findElement(By.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ExpandableListView/android.widget.TextView[1]"));
        peopleNames.click();

        List<AndroidElement> peopleNamesList = driver.findElements(By.className("android.widget.TextView"));
        for (int i = 2; i < 6; i++) {
            System.out.println(peopleNamesList.get(i).getText());
        }

    }
}
