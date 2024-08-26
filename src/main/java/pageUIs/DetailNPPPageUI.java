package pageUIs;

public class DetailNPPPageUI {
    public static String INDUSTRY_ICON_DYNAMIC = "xpath=//android.widget.TextView[@text='%s']";

    //public static String ORDER1_ICON = "xpatha=(//android.view.ViewGroup[@content-desc=\"Thêm vào giỏ hàng\"])[%s]/android.view.ViewGroup";
    public static String ORDER_QUANTITY_ICON_DYNAMIC = "xpatha=(//android.view.ViewGroup[@content-desc=\"Thêm vào giỏ hàng\"])[%s]/android.view.ViewGroup";
    public static String RESULT_QUANTITY_ICON = "xpath=//android.widget.EditText[@text='1']";

    //public static String INCREASE_QUANTITY_ICON = "xpath=//android.widget.EditText[@text='1']//following-sibling::android.view.ViewGroup";
    //public static String INCREASE_QUANTITY_ICON = "xpath=//android.widget.TextView[@text='100,000đ']//following-sibling::android.view.ViewGroup//android.view.ViewGroup[2]";
    //public static String INCREASE_QUANTITY_ICON = "xpath=//android.widget.TextView[@text='%s']//following-sibling::android.view.ViewGroup//android.view.ViewGroup[2]";
    public static String INCREASE_QUANTITY_ICON_DYNAMIC = "xpatha=(//android.view.ViewGroup[@content-desc=\"Tăng số lượng\"])[%s]/android.view.ViewGroup";
    public static String DECREASE_QUANTITY_ICON_DYNAMIC = "xpatha=(//android.view.ViewGroup[@content-desc=\"Giảm số lượng\"])[%s]/android.view.ViewGroup";
    public static String QUANTITY_PRODUCT_TEXTBOX = "xpath=//android.widget.EditText[@content-desc=\"Nhập số lượng\"]";
    public static String BUY_NOW_BUTTON = "xpath=//android.widget.TextView[@text='Mua ngay']";
    public static String BACK_ARROW_ICON_DYNAMIC = "xpath=//android.widget.TextView[@text='%s']//preceding-sibling::android.view.ViewGroup";
    public static String PRICE_PRODUCT_LABEL = "xpath=//android.widget.TextView[contains(@text,'Yogurt - Chai')]//following-sibling::android.widget.TextView[1]";


    public static String COUNT_PRODUCT_LABEL = "xpath=//android.widget.TextView[contains(@text,'sản phẩm')]";
    public static String PROMOTION_GIFT_LABEL = "xpath=//android.widget.TextView[contains(@text,'Quà tặng')]";
    public static String TOTAL_PRICE_PRODUCT_LABEL = "xpath=//android.widget.TextView[@text='Thành tiền']//following-sibling::android.widget.TextView";
    public static String SCHEME_NAME_LABEL = "xpath=//android.view.ViewGroup[@content-desc=\"Khuyến mãi\"]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView";
    public static String GIFT_NAME_LABEL = "xpath=//android.view.ViewGroup[@content-desc=\"Danh sách quà tặng\"]/android.widget.TextView[2]";
    public static String GIFT_QUANTITY_LABEL = "xpath=//android.view.ViewGroup[@content-desc=\"Danh sách quà tặng\"]/android.widget.TextView[1]";
    public static String GIFT_UPDATE_LABEL = "xpath=//android.view.ViewGroup[@content-desc=\"Sửa quà\"]/android.widget.TextView";
    public static String CHOOSE_GIFT_PROMOTION_BUTTON = "xpath=//android.view.ViewGroup[@content-desc=\"Chọn quà\"]/android.widget.TextView";
    public static String CHOOSE_GIFT_PROMOTION_DYNAMIC_CHECKBOX = "xpatha=(//android.view.ViewGroup[@content-desc=\"Chọn/ Bỏ chọn\"])[%s]";
    //public static String DECREASE_QUANTITY_GIFT_PROMOTION_DYNAMIC_ICON = "xpatha=(//android.view.ViewGroup[@content-desc=\"Giảm số lượng\"])[%s]";
    //public static String INCREASE_QUANTITY_GIFT_PROMOTION_DYNAMIC_ICON = "xpatha=(//android.view.ViewGroup[@content-desc=\"Tăng số lượng\"])[%s]";


    public static String THEM_GIO_HANG_BUTTON = "xpatha=(//android.view.ViewGroup[@content-desc=\"Thêm vào giỏ hàng\"])[%s]/android.widget.TextView";
    public static String ADD_PROMOTION_LABEL = "xpath=//android.view.ViewGroup[@content-desc=\"Thêm khuyến mãi\"]/android.widget.TextView";
    public static String ERROR_PROMOTION_LABEL = "xpath=//android.view.ViewGroup[@content-desc=\"Thông báo\"]/android.widget.TextView";
    public static String CONFIRM_CHOOSE_GIFT_POPUP = "xpath=android.widget.TextView[@text='Đồng ý']";
    public static String BACK_TO_CHOOSE_GIFT_POPUP = "xpath=android.widget.TextView[@text='Quay lại']";
    public static String PROMOTION_SHOP_CART = "xpath=//android.view.ViewGroup[@content-desc=\"Thêm khuyến mãi\"]/android.widget.TextView";
    public static String PROMOTION_NPP = "xpath=//android.view.ViewGroup[@content-desc=\"Ưu đãi NPP\"]/android.view.ViewGroup[1]/android.widget.TextView";
    public static String VIEW_SHOP_CART_ICON = "xpath=//android.view.ViewGroup[@content-desc=\"Xem giỏ hàng\"]/android.view.ViewGroup[1]";

    public static String DELETE_ORDER_PRODUCT_ICON = "xpath=//android.widget.TextView[@text='Giỏ hàng']//following-sibling::android.view.ViewGroup";
    public static String DELETE_CONFIRM_ORDER_PRODUCT_BUTTON = "xpath=//android.widget.TextView[@text='Xoá']";

    public static String PRODUCT_PRICE_LABEL = "xpath=//android.widget.TextView[@text='100,000đ']";
    public static String BACK_ARROW_ICON_AFTER_DELETE_ORDER = "xpath=//android.widget.TextView[@text='Giỏ hàng']//preceding-sibling::android.view.ViewGroup";

    public static String FILTER = "xpath=//android.widget.TextView[@text=\"Bộ lọc\"]";

}
