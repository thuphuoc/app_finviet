package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidOptions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import platform.Platform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {
    public AppiumDriver<MobileElement> appiumDriver;
    public static AppiumDriver<MobileElement> getDriver(Platform platform){
        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        AndroidOptions options = new AndroidOptions();
        options.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        desiredCapabilities.setCapability(AUTOMATION_NAME,"uiautomator2");
//        desiredCapabilities.setCapability(UDID,"emulator-5554");
        desiredCapabilities.setCapability(UDID,"R5CW41F151V");
        //R58M316XBAA
        //emulator-5554
        desiredCapabilities.setCapability(APP_PACKAGE,"com.wdiodemoapp");
        desiredCapabilities.setCapability(APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
        URL appiumServer = null;
        try {
            appiumServer = new URL("http://localhost:4723/wd/hub");
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (appiumServer ==null){
            throw  new RuntimeException("Can't construct the appium server URL");
        }
        switch (platform){
            case ANDROID:
                appiumDriver = new AndroidDriver<>(appiumServer, desiredCapabilities);
                break;
            case IOS:
                appiumDriver = new IOSDriver<>(appiumServer, desiredCapabilities);
                break;
        }

        appiumDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return appiumDriver;
    }

    public static AppiumDriver<MobileElement> getDriverEco(Platform platform){
        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability(PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        AndroidOptions options = new AndroidOptions();
        options.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        desiredCapabilities.setCapability(PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(AUTOMATION_NAME,"UiAutomator2");
//        desiredCapabilities.setCapability(UDID,"emulator-5554");
        desiredCapabilities.setCapability(UDID,"R5CW41F151V");
        desiredCapabilities.setCapability(APP_PACKAGE,"vn.com.finviet.eco.test");
        desiredCapabilities.setCapability(APP_ACTIVITY,"vn.com.finviet.eco.MainActivity");
        URL appiumServer = null;
        try {
            appiumServer = new URL("http://localhost:4723/");
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (appiumServer ==null){
            throw  new RuntimeException("Can't construct the appium server URL");
        }
        switch (platform){
            case ANDROID:
                appiumDriver = new AndroidDriver<>(appiumServer, desiredCapabilities);
                break;
            case IOS:
                appiumDriver = new IOSDriver<>(appiumServer, desiredCapabilities);
                break;
        }

        appiumDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return appiumDriver;
    }

}
