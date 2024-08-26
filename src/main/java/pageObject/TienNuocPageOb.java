package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageUIs.TienDienPageUI;
import pageUIs.TienNuocPageUI;

public class TienNuocPageOb extends BasePage {
    private AppiumDriver<MobileElement> appiumDriver;
    public TienNuocPageOb(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void chooseToNCC_Nuoc(String nameNCC){
        waitForWebElementClickable(appiumDriver, TienNuocPageUI.NHACUNGCAP_NUOC_POPUP_LISTBOX);
        clickToElement(appiumDriver, TienNuocPageUI.NHACUNGCAP_NUOC_POPUP_LISTBOX);
    }
    public String getInforOfNCC_Nuoc(){
        waitForWebElementVisible(appiumDriver, TienNuocPageUI.NHACUNGCAP_NUOC_HUE_LISTBOX);
        return getElementText(appiumDriver, TienNuocPageUI.NHACUNGCAP_NUOC_HUE_LISTBOX);
    }

    public void chooseToNCC_Dien() {
        waitForWebElementClickable(appiumDriver, TienNuocPageUI.NHACUNGCAP_NUOC_HUE_LISTBOX);
        clickToElement(appiumDriver, TienNuocPageUI.NHACUNGCAP_NUOC_HUE_LISTBOX);
    }

}
