package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageUIs.BasePageUI;
import pageUIs.NPPPageUI;
import pageUIs.TienDienPageUI;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class NPPPageOb extends BasePage {
    private AppiumDriver<MobileElement> appiumDriver;
    public NPPPageOb(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }
    public NPPPageOb openToDistributorPage() {
        waitForWebElementClickable(appiumDriver, BasePageUI.TAIKHOAN_BOTTOM_MENU);
        clickToElement(appiumDriver, BasePageUI.TAIKHOAN_BOTTOM_MENU);
        return PageGeneratorManager.getDistributorPage(appiumDriver);
    }

    public void clickToTimKiemTextBox() {
        waitForWebElementVisible(appiumDriver, NPPPageUI.TIMKIEM_NPP_TEXTBOX);
        clickToElement(appiumDriver,NPPPageUI.TIMKIEM_NPP_TEXTBOX);
    }


    public void inputToTimKiemTextBox(String nppName) {
        waitForWebElementVisible(appiumDriver, NPPPageUI.TIMKIEM_NPP_TEXTBOX);
        sendKeyToElement(appiumDriver,  NPPPageUI.TIMKIEM_NPP_TEXTBOX,nppName);
    }

    public void pressEnterKeyboard(){
//        waitForWebElementVisible(appiumDriver, NPPPageUI.TIMKIEM_NPP_AFTER_INPUT_TEXTBOX);
//        pressKeyToElement(appiumDriver, NPPPageUI.TIMKIEM_NPP_AFTER_INPUT_TEXTBOX);
//        sleepInSecond(1);
         pressEnter((AndroidDriver<MobileElement>) appiumDriver);
    }

    public void clickToXemNPPButtonNew() {
        waitForWebElementClickable(appiumDriver, NPPPageUI.XEM_NPP_BUTTON);
        String a = getElementText(appiumDriver,NPPPageUI.XEM_NPP_BUTTON);
        System.out.println("a= " + a);
        clickToElement(appiumDriver,NPPPageUI.XEM_NPP_BUTTON);
        sleepInSecond(1);
    }

    public void clickToXemNPPButton() {
        waitForWebElementClickable(appiumDriver, NPPPageUI.XEM_NPP_BUTTON);
        //String a = getElementText(appiumDriver,NPPPageUI.XEM_NPP_BUTTON);
        //System.out.println("a= " + a);
        leftPressKeyToElement(appiumDriver,NPPPageUI.XEM_NPP_BUTTON);
    }

    public void clickToTimKiemAfterSearchTextBox() {
        waitForWebElementVisible(appiumDriver, NPPPageUI.TIMKIEM_NPP_TEXTBOX);
        clickToElement(appiumDriver,NPPPageUI.TIMKIEM_NPP_TEXTBOX);
    }


}
