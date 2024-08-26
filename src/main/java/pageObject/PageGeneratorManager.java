package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageGeneratorManager {
	public AppiumDriver<MobileElement> appiumDriver;
	public PageGeneratorManager(AppiumDriver<MobileElement> appiumDriver) {
		// TODO Auto-generated constructor stub
		this.appiumDriver = appiumDriver;
	}

	public static LoginPageOb getLoginPage(AppiumDriver<MobileElement> appiumDriver) {
		return new LoginPageOb(appiumDriver);
	}

	public static NhapHangPageOb getShopPage(AppiumDriver<MobileElement> appiumDriver) {
		return new NhapHangPageOb(appiumDriver);
	}

	public static BrandPageOb getBrandPage(AppiumDriver<MobileElement> appiumDriver) {
		return new BrandPageOb(appiumDriver);
	}
	public static TaiKhoanPageOb getTaiKhoanPage(AppiumDriver<MobileElement> appiumDriver) {
		return new TaiKhoanPageOb(appiumDriver);
	}
	public static DichVuPageOb getDichVuPage(AppiumDriver<MobileElement> appiumDriver) {
		return new DichVuPageOb(appiumDriver);
	}
	public static TienDienPageOb getTienDienPage(AppiumDriver<MobileElement> appiumDriver) {
		return new TienDienPageOb(appiumDriver);
	}
	public static TienNuocPageOb getTienNuocPage(AppiumDriver<MobileElement> appiumDriver) {
		return new TienNuocPageOb(appiumDriver);
	}

	public static NPPPageOb getDistributorPage(AppiumDriver<MobileElement> appiumDriver) {
		return new NPPPageOb(appiumDriver);
	}

	public static DetailNPPPageOb getDetailDistributorPage(AppiumDriver<MobileElement> appiumDriver) {
		return new DetailNPPPageOb(appiumDriver);
	}
}
