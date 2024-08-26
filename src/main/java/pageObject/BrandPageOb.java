package pageObject;

import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageUIs.BrandPageUI;

import java.util.List;

public class BrandPageOb extends BasePage {
    private AppiumDriver<MobileElement> appiumDriver;
    public BrandPageOb(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
    }
    public void clickToSearchBrand() {
        waitForWebElementVisible(appiumDriver, BrandPageUI.SEARCH_BRAND_TEXTBOX);
        clickToElement(appiumDriver, BrandPageUI.SEARCH_BRAND_TEXTBOX);
    }
    public void inputToSearchBrand(String brandName) {
        waitForWebElementClickable(appiumDriver, BrandPageUI.SEARCH_BRAND_TEXTBOX);
        sendKeyToElement(appiumDriver,BrandPageUI.SEARCH_BRAND_TEXTBOX, brandName);
    }

    public String getResultFromSearchBrand(){
        waitForWebElementVisible(appiumDriver,BrandPageUI.BRAND_RESULT_SEARCHED);
        System.out.println(getElementText(appiumDriver,BrandPageUI.BRAND_RESULT_SEARCHED));
        return getElementText(appiumDriver,BrandPageUI.BRAND_RESULT_SEARCHED);
    }

    public String getBrandLogoText(){
        waitForWebElementVisible(appiumDriver,BrandPageUI.BRAND_LABEL_AFTER_CLICK_SEARCH);
        System.out.println(getElementText(appiumDriver,BrandPageUI.BRAND_LABEL_AFTER_CLICK_SEARCH));
        return getElementText(appiumDriver,BrandPageUI.BRAND_LABEL_AFTER_CLICK_SEARCH);
    }
    public String getBrandLogoQuestionText(){
        waitForWebElementVisible(appiumDriver,BrandPageUI.BRAND_LABEL_QUESTION_AFTER_CLICK_SEARCH);
        System.out.println(getElementText(appiumDriver,BrandPageUI.BRAND_LABEL_QUESTION_AFTER_CLICK_SEARCH));
        return getElementText(appiumDriver,BrandPageUI.BRAND_LABEL_QUESTION_AFTER_CLICK_SEARCH);
    }

    public void chooseResultBrandAfterSearch() {
        waitForWebElementVisible(appiumDriver, BrandPageUI.BRAND_RESULT_SEARCHED);
        clickToElement(appiumDriver, BrandPageUI.BRAND_RESULT_SEARCHED);
    }

    public String getResultBrandAfterSearch(){
        waitForWebElementVisible(appiumDriver,BrandPageUI.BRAND_RESULT_CHOOSED);
        System.out.println(getElementText(appiumDriver,BrandPageUI.BRAND_RESULT_CHOOSED));
        return getElementText(appiumDriver,BrandPageUI.BRAND_RESULT_CHOOSED);
    }

    public List<String> getListProductAfterChooseBrand() {
        waitForAllWebElementVisible(appiumDriver,BrandPageUI.LIST_PRODUCT_AFTER_CHOOSE_BRAND);
        return getListElementText(appiumDriver,BrandPageUI.LIST_PRODUCT_AFTER_CHOOSE_BRAND);
    }
}