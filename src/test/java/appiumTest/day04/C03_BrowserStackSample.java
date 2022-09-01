package appiumTest.day04;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class C03_BrowserStackSample {

    public static String userName = "dantejugking_GhfdNs";
    public static String accessKey = "BGYJN4sEmqyhogyhCX4n";

    @Test
    public void testBrowserStack() throws MalformedURLException {

        //https://www.browserstack.com/app-automate/capabilities?tag=w3c

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("app", "bs://53ed854d92aa7d90c8da8a581384f83df46e64c1");

        //AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement> (new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



    }

}
