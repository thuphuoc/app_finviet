package testcases;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.*;
import platform.Platform;

public class ThanhToanDien extends DriverFactory {
	//Declare
	private AppiumDriver<MobileElement> appiumDriver;
	private LoginPageOb loginPage;
	private NhapHangPageOb shopPage;
	private TaiKhoanPageOb taikhoanPage;
	private DichVuPageOb dichvuPage;

	private TienDienPageOb tiendienPage;
	//@Parameters("browser")
	@BeforeClass
	public void beforeClass() {
		appiumDriver = DriverFactory.getDriverEco(Platform.ANDROID);
		loginPage = PageGeneratorManager.getLoginPage(appiumDriver);
	}

	@Test
	public void TC01_Verify_ThongTin_ThanhToan_Dien() throws InterruptedException {
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
		tiendienPage = dichvuPage.openToTienDienPage();
		System.out.println("get_Popup_List_NCC_Dien : " + tiendienPage.get_Popup_List_NCC_Dien());
		tiendienPage.chooseToNCC_Dien("Hồ Chí Minh");
		tiendienPage.clickToChange_NCC_Dien();
		tiendienPage.chooseToNCC_Dien("Hà Nội");
		tiendienPage.clickToChange_NCC_Dien();
		tiendienPage.chooseToNCC_Dien("Miền Bắc");
		tiendienPage.clickToChange_NCC_Dien();
		tiendienPage.chooseToNCC_Dien("Miền Trung");
		tiendienPage.clickToChange_NCC_Dien();
		tiendienPage.chooseToNCC_Dien("Miền Nam");
		tiendienPage.clickToChange_NCC_Dien();
		tiendienPage.chooseToNCC_Dien("Hồ Chí Minh");
		//Assert.assertEquals(tiendienPage.getInforOfNCC_Dien(),"Hồ Chí Minh");
		System.out.println("getInforOfNCC_Dien : " + tiendienPage.getInforOfNCC_Dien());
	}

	@Test(priority = 1)
	public void TC02_Verify_ThongTin_ThanhToan_Dien_Thanhcong(){
		tiendienPage.inputToMaKhachHangDien("PE03000088638");
		tiendienPage.sleepInSecond(2);
		tiendienPage.clickToTiepTucButton();
		Assert.assertEquals(tiendienPage.getNCC_DIEN_AfterInputMaKH(),"Điện lực Hồ Chí Minh");
		Assert.assertEquals(tiendienPage.getSoTien_AfterInputMaKH(),"297,000");
		Assert.assertEquals(tiendienPage.getKhachHang_AfterInputMaKH(),"Hua Van Cuong cuong");
		Assert.assertEquals(tiendienPage.getDiachi_AfterInputMaKH(),"34 Hoàng Việt");
		Assert.assertEquals(tiendienPage.getMaKH_AfterInputMaKH(),"PE03000088638");
		Assert.assertEquals(tiendienPage.getKyThanhToan_AfterInputMaKH(),"11/2020");
		Assert.assertEquals(tiendienPage.getXuTichLuyDuoc(),"100 Xu");
	}


	@Test(priority = 2)
	public void TC03_Verify_ThongTin_ThanhToan_Dien_ThatBai() throws InterruptedException {
		tiendienPage.clickToBackButton();
		tiendienPage.inputToMaKhachHangDien("PE16000156822");
		tiendienPage.clickToTiepTucButton();
		Assert.assertEquals(tiendienPage.getErrorMessage(),"Thất bại");
	}

	@Test(priority = 3)
	public void TC04_Verify_ThongTin_ThanhToan_Dien_ThatBai() throws InterruptedException {
		tiendienPage.inputToMaKhachHangDien("PE16000156821");
		tiendienPage.clickToTiepTucButton();
		Assert.assertEquals(tiendienPage.getErrorMessage(),"Thất bại");
	}

	@Test(priority = 4)
	public void TC05_Verify_ThongTin_ThanhToan_Dien_ThatBai() throws InterruptedException {
		tiendienPage.inputToMaKhachHangDien("PE16000156824");
		tiendienPage.clickToTiepTucButton();
		Assert.assertEquals(tiendienPage.getErrorMessage(),"Thất bại");
	}

	@AfterClass
	public void afterClass() {
		appiumDriver.quit();
	}
}
