package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import pageUIs.TienDienPageUI;

public class TienDienPageOb extends BasePage {
    private AppiumDriver<MobileElement> appiumDriver;
    public TienDienPageOb(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public void chooseToNCC_Dien(String ncc){
        waitForElementClickableDynamic(appiumDriver, TienDienPageUI.DYNAMIC_CHOOSE_NHACUNGCAP_DIEN_LISTBOX,ncc);
        clickToElementDynamic(appiumDriver, TienDienPageUI.DYNAMIC_CHOOSE_NHACUNGCAP_DIEN_LISTBOX,ncc);
    }
    public void clickToChange_NCC_Dien(){
        waitForWebElementClickable(appiumDriver, TienDienPageUI.CHANGE_NHACUNGCAP_DIEN_LISTBOX);
        clickToElement(appiumDriver, TienDienPageUI.CHANGE_NHACUNGCAP_DIEN_LISTBOX);
    }

    public String getInforOfNCC_Dien(){
        waitForWebElementVisible(appiumDriver, TienDienPageUI.CHANGE_NHACUNGCAP_DIEN_LISTBOX);
        return getElementText(appiumDriver, TienDienPageUI.CHANGE_NHACUNGCAP_DIEN_LISTBOX);
    }

    public String get_Popup_List_NCC_Dien(){
        waitForWebElementVisible(appiumDriver, TienDienPageUI.NHACUNGCAP_DIEN_POPUP_LISTBOX);
        return getListElementText(appiumDriver, TienDienPageUI.NHACUNGCAP_DIEN_POPUP_LISTBOX).toString();
    }

    public void inputToMaKhachHangDien(String maKH_Dien) {
        waitForWebElementVisible(appiumDriver,TienDienPageUI.MAKHACHHANG_DIEN_TEXTBOX_NEW);
        sendKeyToElement(appiumDriver,TienDienPageUI.MAKHACHHANG_DIEN_TEXTBOX_NEW,maKH_Dien);
    }

    public void clickToTiepTucButton() {
        waitForWebElementClickable(appiumDriver,TienDienPageUI.TIEPTUC_DIEN_BUTTON);
        clickToElement(appiumDriver,TienDienPageUI.TIEPTUC_DIEN_BUTTON);
    }

    public String getNCC_DIEN_AfterInputMaKH() {
        waitForWebElementVisible(appiumDriver, TienDienPageUI.NHACUNGCAP_DIEN_LABEL);
        return getElementText(appiumDriver, TienDienPageUI.NHACUNGCAP_DIEN_LABEL);
    }


    public String getSoTien_AfterInputMaKH() {
        waitForWebElementVisible(appiumDriver, TienDienPageUI.SOTIEN_DONG_DIEN_LABEL);
        return getElementText(appiumDriver, TienDienPageUI.SOTIEN_DONG_DIEN_LABEL);
    }

    public String getKhachHang_AfterInputMaKH() {
        waitForWebElementVisible(appiumDriver, TienDienPageUI.KHACHHANG_DIEN_LABEL);
        return getElementText(appiumDriver, TienDienPageUI.KHACHHANG_DIEN_LABEL);
    }

    public String getDiachi_AfterInputMaKH() {
        waitForWebElementVisible(appiumDriver, TienDienPageUI.DIACHI_DIEN_LABEL);
        return getElementText(appiumDriver, TienDienPageUI.DIACHI_DIEN_LABEL);
    }

    public String getMaKH_AfterInputMaKH() {
        waitForWebElementVisible(appiumDriver, TienDienPageUI.MAKHACHHANG_DIEN_LABEL);
        return getElementText(appiumDriver, TienDienPageUI.MAKHACHHANG_DIEN_LABEL);
    }

    public String getKyThanhToan_AfterInputMaKH() {
        waitForWebElementVisible(appiumDriver, TienDienPageUI.KYTHANHTOAN_DIEN_LABEL);
        return getElementText(appiumDriver, TienDienPageUI.KYTHANHTOAN_DIEN_LABEL);
    }

    public void clickToBackButton() {
        waitForWebElementClickable(appiumDriver,TienDienPageUI.BACK_SCREEN_ICON);
        clickToElement(appiumDriver,TienDienPageUI.BACK_SCREEN_ICON);
    }
    public String getErrorMessage() {
        waitForWebElementVisible(appiumDriver, TienDienPageUI.ERROR_MESSAGE_LABEL);
        return getElementText(appiumDriver, TienDienPageUI.ERROR_MESSAGE_LABEL);
    }

    public String getXuTichLuyDuoc() {
        waitForWebElementVisible(appiumDriver,TienDienPageUI.XU_TICHLUYDUOC_LABEL );
        return getElementText(appiumDriver, TienDienPageUI.XU_TICHLUYDUOC_LABEL);
    }
}
