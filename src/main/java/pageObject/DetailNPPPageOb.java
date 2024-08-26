package pageObject;

import commons.BasePage;
import commons.DIRECTION;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageUIs.BasePageUI;
import pageUIs.DetailNPPPageUI;
import pageUIs.NPPPageUI;

public class DetailNPPPageOb extends BasePage {
    private AppiumDriver<MobileElement> appiumDriver;
    private AndroidDriver<MobileElement> androidDriver;
    public DetailNPPPageOb(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }
    public DetailNPPPageOb openToDistributorPage() {
        waitForWebElementClickable(appiumDriver, BasePageUI.TAIKHOAN_BOTTOM_MENU);
        clickToElement(appiumDriver, BasePageUI.TAIKHOAN_BOTTOM_MENU);
        return PageGeneratorManager.getDetailDistributorPage(appiumDriver);
    }

    public void chooseToIndustryDynamic(String industryName) {
        waitForWebElementVisibleDynamic(appiumDriver, DetailNPPPageUI.INDUSTRY_ICON_DYNAMIC,industryName);
        clickToElementDynamic(appiumDriver,DetailNPPPageUI.INDUSTRY_ICON_DYNAMIC,industryName);
        sleepInSecond(2);
    }

    public void swipeToIndustry(String industryName){
        for (int i = 0; i < 3; i++) {
            swipe(androidDriver,DIRECTION.DOWN,1000);
        }
//        swipeScreenToElement(appiumDriver, DIRECTION.DOWN, DetailNPPPageUI.INDUSTRY_ICON_DYNAMIC,industryName);
    }

/*    public void clickToOrderOneICON() {
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.ORDER1_ICON);
        clickToElement(appiumDriver,DetailNPPPageUI.ORDER1_ICON);
    }*/
    public void clickToOrderQuantityProductDynamic(String positionNumber) {
        waitForElementClickableDynamic(appiumDriver, DetailNPPPageUI.ORDER_QUANTITY_ICON_DYNAMIC,positionNumber);
        clickToElementDynamic(appiumDriver,DetailNPPPageUI.ORDER_QUANTITY_ICON_DYNAMIC,positionNumber);
        sleepInSecond(2);
    }

    public void inputToQuantityProduct(String quantityProduct) {
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.QUANTITY_PRODUCT_TEXTBOX);
        clickToElement(appiumDriver, DetailNPPPageUI.QUANTITY_PRODUCT_TEXTBOX);
        clickToElement(appiumDriver, DetailNPPPageUI.QUANTITY_PRODUCT_TEXTBOX);
        sleepInSecond(2);
        sendKeyToElement(appiumDriver,DetailNPPPageUI.QUANTITY_PRODUCT_TEXTBOX,quantityProduct);
    }
    public void pressEnterKeyboardQuantityProduct() {
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.QUANTITY_PRODUCT_TEXTBOX);
        pressKeyToElement(appiumDriver, DetailNPPPageUI.QUANTITY_PRODUCT_TEXTBOX);
        sleepInSecond(2);
    }
    public void increaseQuantityOrder_Dynamic(String positionNumberQ) {
        waitForWebElementVisibleDynamic(appiumDriver, DetailNPPPageUI.INCREASE_QUANTITY_ICON_DYNAMIC,positionNumberQ);
        clickToElementDynamic(appiumDriver,DetailNPPPageUI.INCREASE_QUANTITY_ICON_DYNAMIC,positionNumberQ);
        sleepInSecond(3);
    }
    public void decreaseQuantityOrderDynamic(String positionNumber) {
        waitForWebElementVisibleDynamic(appiumDriver, DetailNPPPageUI.DECREASE_QUANTITY_ICON_DYNAMIC,positionNumber);
        clickToElementDynamic(appiumDriver,DetailNPPPageUI.DECREASE_QUANTITY_ICON_DYNAMIC,positionNumber);
        sleepInSecond(1);
    }
    public void clickToBuyNowButton() {
        sleepInSecond(1);
        waitForWebElementClickable(appiumDriver, DetailNPPPageUI.BUY_NOW_BUTTON);
        clickToElement(appiumDriver,DetailNPPPageUI.BUY_NOW_BUTTON);

    }

    public void clickToBackArrowButton(String screenName) {
        waitForWebElementVisibleDynamic(appiumDriver, DetailNPPPageUI.BACK_ARROW_ICON_DYNAMIC,screenName);
        clickToElementDynamic(appiumDriver,DetailNPPPageUI.BACK_ARROW_ICON_DYNAMIC,screenName);
    }
    public String getSchemeName(){
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.SCHEME_NAME_LABEL);
        return getElementText(appiumDriver,DetailNPPPageUI.SCHEME_NAME_LABEL);
    }

    public String getGiftName(){
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.GIFT_NAME_LABEL);
        return getElementText(appiumDriver,DetailNPPPageUI.GIFT_NAME_LABEL);
    }
    public String getGiftQuantity(){
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.GIFT_QUANTITY_LABEL);
        return getElementText(appiumDriver,DetailNPPPageUI.GIFT_QUANTITY_LABEL);
    }
    public String getGiftLabelWhenHasGiftPromotion(){
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.PROMOTION_GIFT_LABEL);
        return getElementText(appiumDriver,DetailNPPPageUI.PROMOTION_GIFT_LABEL);
    }
    public String GetErrorMessagePromotion(){
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.ERROR_PROMOTION_LABEL);
        return getElementText(appiumDriver,DetailNPPPageUI.ERROR_PROMOTION_LABEL);
    }

    public String GetDiscountPriceProduct(){
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.PRICE_PRODUCT_LABEL);
        return getElementText(appiumDriver,DetailNPPPageUI.PRICE_PRODUCT_LABEL);
    }

    public String GetTotalPriceProduct(){
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.TOTAL_PRICE_PRODUCT_LABEL);
        return getElementText(appiumDriver,DetailNPPPageUI.TOTAL_PRICE_PRODUCT_LABEL);
    }

    public void OpenOrderDetail_ShopCart() {
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.VIEW_SHOP_CART_ICON);
        clickToElement(appiumDriver,DetailNPPPageUI.VIEW_SHOP_CART_ICON);
        sleepInSecond(2);
    }

    public void DeleteOrderProduct() {
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.DELETE_ORDER_PRODUCT_ICON);
        clickToElement(appiumDriver,DetailNPPPageUI.DELETE_ORDER_PRODUCT_ICON);
        sleepInSecond(3);
    }
    public void ConfirmDeleteOrderProduct() {
        waitForWebElementVisible(appiumDriver, DetailNPPPageUI.DELETE_CONFIRM_ORDER_PRODUCT_BUTTON);
        clickToElement(appiumDriver,DetailNPPPageUI.DELETE_CONFIRM_ORDER_PRODUCT_BUTTON);
        sleepInSecond(3);
    }

    public void scrollToScreen(int xStart,int xEnd,int yStart,int yEnd) {
        waitForWebElementVisible(appiumDriver,DetailNPPPageUI.COUNT_PRODUCT_LABEL);
        getMobileSizeAndScrollToScreen(appiumDriver,xStart,xEnd,yStart,yEnd);
        sleepInSecond(2);
    }


    public void clickToChooseGiftOnProduct() {
        waitForWebElementClickable(appiumDriver, DetailNPPPageUI.CHOOSE_GIFT_PROMOTION_BUTTON);
        clickToElement(appiumDriver, DetailNPPPageUI.CHOOSE_GIFT_PROMOTION_BUTTON);
    }

    public void chooseGiftOnProductDynamic(String positionProduct) {
        waitForElementClickableDynamic(appiumDriver,DetailNPPPageUI.CHOOSE_GIFT_PROMOTION_DYNAMIC_CHECKBOX,positionProduct);
        clickToElementDynamic(appiumDriver,DetailNPPPageUI.CHOOSE_GIFT_PROMOTION_DYNAMIC_CHECKBOX,positionProduct);
    }

    public boolean verifyProductIsDisabled(String positionProduct){
        //waitForWebElementInvisibleDynamic(appiumDriver,DetailNPPPageUI.CHOOSE_GIFT_PROMOTION_DYNAMIC_CHECKBOX,positionProduct);
        return isElementEnabledDynamic(appiumDriver,DetailNPPPageUI.CHOOSE_GIFT_PROMOTION_DYNAMIC_CHECKBOX,positionProduct);
    }

/*    public void chooseIncreaseGiftOnProductDynamic(String positionIncProduct) {
        waitForElementClickableDynamic(appiumDriver,DetailNPPPageUI.INCREASE_QUANTITY_GIFT_PROMOTION_DYNAMIC_ICON,positionIncProduct);
        clickToElementDynamic(appiumDriver,DetailNPPPageUI.INCREASE_QUANTITY_GIFT_PROMOTION_DYNAMIC_ICON,positionIncProduct);
    }

    public void chooseDecreaseGiftOnProductDynamic(String positionDecProduct) {
        waitForElementClickableDynamic(appiumDriver,DetailNPPPageUI.DECREASE_QUANTITY_GIFT_PROMOTION_DYNAMIC_ICON,positionDecProduct);
        clickToElementDynamic(appiumDriver,DetailNPPPageUI.DECREASE_QUANTITY_GIFT_PROMOTION_DYNAMIC_ICON,positionDecProduct);
    }*/

    public void swipeToTop(){
//        scrollToTop(appiumDriver,DetailNPPPageUI.FILTER,);
    }
}
