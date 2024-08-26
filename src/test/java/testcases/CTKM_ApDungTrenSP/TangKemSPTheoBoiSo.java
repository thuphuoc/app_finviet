package testcases.CTKM_ApDungTrenSP;

import commons.DIRECTION;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.*;
import platform.Platform;

public class TangKemSPTheoBoiSo extends DriverFactory {
	//Declare
	private AppiumDriver<MobileElement> appiumDriver;
	private LoginPageOb loginPage;
	private NhapHangPageOb shopPage;
	private NPPPageOb nppPage;

	private  DetailNPPPageOb detailNPPPage;
	//@Parameters("browser")
	@BeforeClass
	public void beforeClass() {
		appiumDriver = DriverFactory.getDriverEco(Platform.ANDROID);
		loginPage = PageGeneratorManager.getLoginPage(appiumDriver);
	}

	@Test
	public void TC01_Verify_ADTSP_TangKemSPTheoBoiSo_CungLoai() {
		//loginPage.clickToAccessPhone();
		loginPage.clickToIgnoreText();
		loginPage.inputToPhone("0968686868");
		loginPage.clickToLoginButton();
		loginPage.inputToPassword("111111");
		shopPage = PageGeneratorManager.getShopPage(appiumDriver);
		nppPage = (NPPPageOb) shopPage.openPurchasePage(appiumDriver,"Nhập hàng theo Nhà phân phối");
		nppPage.clickToTimKiemTextBox();
		nppPage.inputToTimKiemTextBox("PHUOC_NPP 1");
		nppPage.pressEnterKeyboard();
		nppPage.clickToXemNPPButton();
		detailNPPPage = PageGeneratorManager.getDetailDistributorPage(appiumDriver);
		detailNPPPage.swipeToIndustry("Bia, nước uống có cồn");
		detailNPPPage.chooseToIndustryDynamic("Bia, nước uống có cồn");
//		detailNPPPage.scrollToScreen(50,50,90,20);
		detailNPPPage.clickToOrderQuantityProductDynamic("2");
		detailNPPPage.increaseQuantityOrder_Dynamic("1");
//		Assert.assertEquals(detailNPPPage.getGiftLabelWhenHasGiftPromotion(),"Quà tặng");
//		detailNPPPage.clickToBuyNowButton();
//		Assert.assertEquals(detailNPPPage.getSchemeName(),"AUTO_MOBILE_ApdungtrenSP_TangkemSPtheoboiso_cungloai");
//		Assert.assertEquals(detailNPPPage.getGiftName(),"Bia Budweiser 1 - 330ml - Két 24 chai");
//		Assert.assertEquals(detailNPPPage.getGiftQuantity(),"x2 Két");
//		detailNPPPage.clickToBackArrowButton("Đặt hàng");
//		detailNPPPage.OpenOrderDetail_ShopCart();
//		detailNPPPage.DeleteOrderProduct();
//		detailNPPPage.ConfirmDeleteOrderProduct();
//		detailNPPPage.clickToBackArrowButton("Giỏ hàng");
//
//		detailNPPPage.chooseToIndustryDynamic("Nước ngọt, nước trà giải khát");
////		detailNPPPage.scrollToScreen(50,50,80,30);
//		detailNPPPage.clickToOrderQuantityProductDynamic("2");
//		detailNPPPage.increaseQuantityOrder_Dynamic("1");
//		detailNPPPage.inputToQuantityProduct("4");
//		detailNPPPage.pressEnterKeyboardQuantityProduct();
//		detailNPPPage.clickToBuyNowButton();
//		Assert.assertEquals(detailNPPPage.getSchemeName(),"AUTO_MOBILE_ApdungtrenSP_TangkemSPtheoboiso_Khacloai");
//		detailNPPPage.clickToChooseGiftOnProduct();
//		detailNPPPage.chooseGiftOnProductDynamic("1");
//		detailNPPPage.increaseQuantityOrder_Dynamic("1");
//		System.out.println("##############verifyProductIsDisabled#################: " + detailNPPPage.verifyProductIsDisabled("2"));
//		Assert.assertFalse(detailNPPPage.verifyProductIsDisabled("2"));
//		detailNPPPage.chooseGiftOnProductDynamic("1");
//		detailNPPPage.chooseGiftOnProductDynamic("2");
//		detailNPPPage.increaseQuantityOrder_Dynamic("1");
//		detailNPPPage.increaseQuantityOrder_Dynamic("1");
//		Assert.assertFalse(detailNPPPage.verifyProductIsDisabled("1"));
	}

/*	@Test
	public void TC02_Verify_ADTSP_TangKemSPTheoBoiSo_KhacLoai() {
		detailNPPPage.clickToBackArrowButton("Đặt hàng");
		detailNPPPage.OpenOrderDetail_ShopCart();
		detailNPPPage.DeleteOrderProduct();
		detailNPPPage.ConfirmDeleteOrderProduct();
		//detailNPPPage.scrollToScreen(50,50,90,20);
		detailNPPPage.clickToBackArrowButton("Giỏ hàng");
		detailNPPPage.chooseToIndustryDynamic("Nước ngọt, nước trà giải khát");
		detailNPPPage.clickToOrderQuantityProductDynamic("2");
		detailNPPPage.increaseQuantityOrder_Dynamic("1");
		detailNPPPage.inputToQuantityProduct("4");
		detailNPPPage.pressEnterKeyboardQuantityProduct();
		detailNPPPage.clickToBuyNowButton();
		Assert.assertEquals(detailNPPPage.getSchemeName(),"AUTO_MOBILE_ApdungtrenSP_TangkemSPtheoboiso_Khacloai");
		detailNPPPage.clickToChooseGiftOnProduct();
		detailNPPPage.chooseGiftOnProductDynamic("1");
		detailNPPPage.increaseQuantityOrder_Dynamic("1");
	}*/


	@AfterClass
	public void afterClass() {
		appiumDriver.closeApp();
	}
}
