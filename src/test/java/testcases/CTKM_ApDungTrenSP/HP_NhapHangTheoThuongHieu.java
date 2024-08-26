package testcases.CTKM_ApDungTrenSP;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.*;
import platform.Platform;

public class HP_NhapHangTheoThuongHieu extends DriverFactory {
	//Declare
	private AppiumDriver<MobileElement> appiumDriver;
	private LoginPageOb loginPage;
	private NhapHangPageOb shopPage;
	private BrandPageOb brandPage;

	private NPPPageOb nppPage;
	//@Parameters("browser")
	@BeforeClass
	public void beforeClass() {
		appiumDriver = DriverFactory.getDriverEco(Platform.ANDROID);
		loginPage = PageGeneratorManager.getLoginPage(appiumDriver);
	}

	@Test
	public void TC01_Verify_Login() throws InterruptedException {
		//loginPage.clickToAccessPhone();
		loginPage.clickToIgnoreText();
		loginPage.inputToPhone("0919000002");
		loginPage.clickToLoginButton();
		loginPage.inputToPassword("111111");
		shopPage = PageGeneratorManager.getShopPage(appiumDriver);
		brandPage = (BrandPageOb) shopPage.openPurchasePage(appiumDriver,"Nhập hàng theo thương hiệu");
		//nppPage = (NPPPageOb) brandPage.openPurchasePage(appiumDriver,"Nhập hàng theo thương hiệu");
		brandPage.clickToSearchBrand();
		Assert.assertEquals(brandPage.getBrandLogoText(),"THƯƠNG HIỆU");
		Assert.assertEquals(brandPage.getBrandLogoQuestionText(),"Bạn đang cần tìm thương hiệu nào?");

		brandPage.inputToSearchBrand("Bia Việt");
		//Assert.assertEquals(brandPage.getResultFromSearchBrand(),"Bia Việt");
		brandPage.chooseResultBrandAfterSearch();
		//Assert.assertEquals(brandPage.getResultBrandAfterSearch(),"Bia Việt");
		brandPage.getListProductAfterChooseBrand();
	}

	@AfterClass
	public void afterClass() {
		appiumDriver.quit();
	}
}
