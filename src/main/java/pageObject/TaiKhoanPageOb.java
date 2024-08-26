package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TaiKhoanPageOb extends BasePage {
    private AppiumDriver<MobileElement> appiumDriver;
    public TaiKhoanPageOb(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }



}
