package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageUIs.BasePageUI;
import pageUIs.TienDienPageUI;

public class NhapHangPageOb extends BasePage {
    private AppiumDriver<MobileElement> appiumDriver;
    public NhapHangPageOb(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }
    public TaiKhoanPageOb openToTaiKhoanPage() {
        waitForWebElementClickable(appiumDriver, BasePageUI.TAIKHOAN_BOTTOM_MENU);
        clickToElement(appiumDriver, BasePageUI.TAIKHOAN_BOTTOM_MENU);
        return PageGeneratorManager.getTaiKhoanPage(appiumDriver);
    }



}
