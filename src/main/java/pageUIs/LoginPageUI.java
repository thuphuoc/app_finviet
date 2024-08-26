package pageUIs;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LoginPageUI {
	public static  String ACCESS_DEVICE_BUTTON = "id=com.android.permissioncontroller:id/permission_allow_foreground_only_button";
	public static  String ACCESS_MEDIA_BUTTON = "id=com.android.permissioncontroller:id/permission_allow_button";

	public static final String IGNORE_TEXT = "xpath=//android.widget.TextView[@text='Bỏ qua']";
	public static final String PHONE_TEXTBOX = "xpath=//android.widget.EditText[@text='Nhập số điện thoại']";


	public static final String PASSWORD_TEXTBOX = "AndroidUI=new UiSelector().textContains(\"Nhập mật khẩu\")";
	public static final String LOGIN_BUTTON = "AndroidUI=new UiSelector().textContains(\"Đăng nhập\")";
	public static final String ERROR_MESSAGE = "AndroidUI=new UiSelector().textContains(\"Sai mật khẩu\")";
}
