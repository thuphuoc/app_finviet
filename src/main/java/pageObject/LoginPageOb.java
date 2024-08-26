package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import pageUIs.LoginPageUI;
public class LoginPageOb extends BasePage {
    private AppiumDriver<MobileElement> appiumDriver;
    public LoginPageOb(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }
    public void clickToAccessDevice() {
        waitForWebElementVisible(appiumDriver,LoginPageUI.ACCESS_DEVICE_BUTTON);
        clickToElement(appiumDriver,LoginPageUI.ACCESS_DEVICE_BUTTON);
    }

    public void clickToAccessMedia() {
        waitForWebElementVisible(appiumDriver,LoginPageUI.ACCESS_MEDIA_BUTTON);
        clickToElement(appiumDriver,LoginPageUI.ACCESS_MEDIA_BUTTON );
    }


    public void inputToPhone(String phone){
        waitForWebElementVisible(appiumDriver,LoginPageUI.PHONE_TEXTBOX);
        sendKeyToElement(appiumDriver,LoginPageUI.PHONE_TEXTBOX,phone);
    }

    public void inputToPassword(String password){
        waitForWebElementVisible(appiumDriver,LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(appiumDriver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public void clickToIgnoreText() {
        clickToElement(appiumDriver,LoginPageUI.IGNORE_TEXT);
    }

    public void clickToLoginButton(){
        waitForWebElementVisible(appiumDriver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(appiumDriver,LoginPageUI.LOGIN_BUTTON);
    }
}
