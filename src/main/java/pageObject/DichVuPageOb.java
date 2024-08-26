package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageUIs.DichVuPageUI;

public class DichVuPageOb extends BasePage {
    private AppiumDriver<MobileElement> appiumDriver;
    public DichVuPageOb(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }
    public TienDienPageOb openToTienDienPage(){
        waitForWebElementClickable(appiumDriver, DichVuPageUI.HOADON_DIEN_ICON);
        //System.out.println("appiumDriver Basepage pageName 3.1: " + pageName);
        clickToElement(appiumDriver, DichVuPageUI.HOADON_DIEN_ICON);
        return PageGeneratorManager.getTienDienPage(appiumDriver);
    }

    public TienNuocPageOb openToTienNuocPage(){
        waitForWebElementClickable(appiumDriver, DichVuPageUI.HOADON_NUOC_ICON);
        clickToElement(appiumDriver, DichVuPageUI.HOADON_NUOC_ICON);
        return PageGeneratorManager.getTienNuocPage(appiumDriver);
    }
}
