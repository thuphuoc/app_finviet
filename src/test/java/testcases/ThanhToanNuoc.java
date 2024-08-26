package testcases;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.*;
import platform.Platform;

public class ThanhToanNuoc extends DriverFactory {
	//Declare
	private AppiumDriver<MobileElement> appiumDriver;
	private LoginPageOb loginPage;
	private NhapHangPageOb shopPage;
	private TaiKhoanPageOb taikhoanPage;
	private DichVuPageOb dichvuPage;

	private TienNuocPageOb tiendnuocPage;
	//@Parameters("browser")
	@BeforeClass
	public void beforeClass() {
		appiumDriver = DriverFactory.getDriverEco(Platform.ANDROID);
		loginPage = PageGeneratorManager.getLoginPage(appiumDriver);
	}

	@Test
	public void TC01_Verify_ThongTin_ThanhToan_Dien_ThànhCong() throws InterruptedException {
		//loginPage.clickToAccessDevice();
		//loginPage.clickToAccessMedia();
		loginPage.clickToIgnoreText();
		loginPage.inputToPhone("0919000002");
		loginPage.clickToLoginButton();
		loginPage.inputToPassword("111111");
		shopPage = PageGeneratorManager.getShopPage(appiumDriver);
		taikhoanPage = shopPage.openToTaiKhoanPage();
		shopPage= (NhapHangPageOb) taikhoanPage.openPagesAtBottomMenu(appiumDriver,"Nhập hàng");
		dichvuPage= (DichVuPageOb) shopPage.openPagesAtBottomMenu(appiumDriver,"Dịch vụ");
		tiendnuocPage = dichvuPage.openToTienNuocPage();
		//System.out.println("get_Popup_List_NCC_Dien : " + tiendnuocPage.get_Popup_List_NCC_Dien());
		tiendnuocPage.chooseToNCC_Dien();
		//tiendnuocPage.getInforOfNCC_Nuoc_DANANG("Nước Đà Nẵng");
		//Assert.assertEquals(tiendnuocPage.getInforOfNCC_Nuoc_DANANG(),"Nước Đà Nẵng");
		//tiendnuocPage.inputToMaKhachHangDien("PE16000156820");

	}

	@AfterClass
	public void afterClass() {
		appiumDriver.quit();
	}
}
