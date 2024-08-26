package pageUIs;

public class BrandPageUI {
    public static final String SEARCH_BRAND_TEXTBOX = "xpath=//android.widget.EditText[@text='Tìm kiếm']";
    public static final String BRAND_RESULT_SEARCHED = "xpath=//android.widget.TextView[@text='1 kết quả']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]/android.view.ViewGroup";

    public static final String BRAND_RESULT_CHOOSED = "xpath=//android.widget.EditText[@text='Tìm kiếm']/parent::android.view.ViewGroup/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.TextView[1]";

    public static final String BRAND_LABEL_AFTER_CLICK_SEARCH = "xpath=//android.widget.TextView[@text='THƯƠNG HIỆU']";
    public static final String BRAND_LABEL_QUESTION_AFTER_CLICK_SEARCH = "xpath=//android.widget.TextView[@text='Bạn đang cần tìm thương hiệu nào?']";

    public static final String LIST_PRODUCT_AFTER_CHOOSE_BRAND = "xpath=//android.view.ViewGroup/android.widget.ScrollView//android.widget.ScrollView";
}
