package commons;

import io.appium.java_client.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.PageGeneratorManager;
import pageUIs.BasePageUI;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class BasePage {

	public MobileBy getByXpath(String xpathLocator) {
		return (MobileBy) MobileBy.AndroidUIAutomator(xpathLocator);
	}
	
	private By getByLocators(String locatorType) {
		By by =null;
		//System.out.println("locatorType= " + locatorType);
		//System.out.println("Locator Type= " + locatorType);
		if(locatorType.startsWith("id=")||locatorType.startsWith("ID=")||locatorType.startsWith("Id=")) {
			by = MobileBy.id(locatorType.substring(3));
			//System.out.println("by= " + by);
		}else if(locatorType.startsWith("class=")||locatorType.startsWith("CLASS=")||locatorType.startsWith("Class=")){
			by = MobileBy.className(locatorType.substring(6));
		}else if(locatorType.startsWith("name=")||locatorType.startsWith("NAME=")||locatorType.startsWith("Name=")){
			by = MobileBy.className(locatorType.substring(5));
		}else if(locatorType.startsWith("css=")||locatorType.startsWith("CSS=")||locatorType.startsWith("Css=")){
			by = MobileBy.cssSelector(locatorType.substring(4));
		}else if(locatorType.startsWith("xpath=")||locatorType.startsWith("XPATH=")||locatorType.startsWith("Xpath=")){
			by = MobileBy.xpath(locatorType.substring(6));
			//System.out.println("by= " + by);
		}else if(locatorType.startsWith("xpatha=")){
			by = MobileBy.xpath(locatorType.substring(7));
			//System.out.println("by= " + by);
		}
		else if(locatorType.startsWith("AndroidUI=")){
			by = MobileBy.AndroidUIAutomator(locatorType.substring(10));
		}
		else {
			throw new RuntimeException("Locator Type is not Supported");
		}
		return by;
	}

	public WebElement getMobileElement(AppiumDriver appiumDriver, String locatorType) {
		return appiumDriver.findElement(getByLocators((locatorType)));
	}
	public List<WebElement> getListMobileElement(AppiumDriver appiumDriver, String locatorType) {
		return appiumDriver.findElements(getByLocators(locatorType));
	}
	public void clickToElement(AppiumDriver appiumDriver, String locatorType) {
		WebElement element = getMobileElement(appiumDriver,locatorType);
		//System.out.println("clickToElement= " + element);
		element.click();
	}

	protected void sendKeyToElement(AppiumDriver appiumDriver, String locatorType, String textValue) {
		WebElement element = getMobileElement(appiumDriver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public String getElementText(AppiumDriver appiumDriver, String locatorType) {
		return getMobileElement(appiumDriver, locatorType).getText();
	}

	public List<String> getListElementText(AppiumDriver appiumDriver, String locatorType) {
		List<String> allRowValuesAllPage = new ArrayList<String>();
		List<WebElement> allElement = getListMobileElement(appiumDriver,locatorType);
		for (WebElement eachRow : allElement) {
			allRowValuesAllPage.add(eachRow.getText());
			//System.out.println("Get list" + eachRow.getText());
		}
		return allRowValuesAllPage;
	}

	public void waitForWebElementVisible(AppiumDriver appiumDriver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 50);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocators(locatorType)));
	}

	public void waitForWebElementVisibleDynamic(AppiumDriver appiumDriver, String locatorType, String...dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 50);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocators(getXpathDynamic(locatorType, dynamicValue))));
		//System.out.println("##############DYNAMIC#################: " + getXpathDynamic(locatorType, dynamicValue));
	}

	public void waitForAllWebElementVisible(AppiumDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver,50);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locatorType)));
	}
	public void waitForWebElementInvisible(AppiumDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 50);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForWebElementInvisibleDynamic(AppiumDriver appiumDriver, String locatorType, String...dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 50);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocators(getXpathDynamic(locatorType, dynamicValue))));
	}
	public void waitForWebElementClickable(AppiumDriver appiumDriver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 50);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocators((locatorType))));
	}

	public void pressKeyToElement(AppiumDriver appiumDriver, String locatorType) {
		//new Actions(appiumDriver).sendKeys(getMobileElement(appiumDriver,locatorType),Keys.ENTER).perform();
		((AndroidDriver<MobileElement>) appiumDriver).pressKey(new KeyEvent(AndroidKey.ENTER));
		sleepInSecond(1);
	}

	public void leftPressKeyToElement(AppiumDriver appiumDriver, String locatorType) {
		new Actions(appiumDriver).click(getMobileElement(appiumDriver,locatorType)).perform();
	}

	public int getRandomNumber() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(9999);
	}


	public String getXpathDynamic(String locatorType, String...dynamicValue) {
		if(locatorType.startsWith("xpatha=")||locatorType.startsWith("Xpath=")||locatorType.startsWith("XPATH=")||locatorType.startsWith("xpath=")||locatorType.startsWith("xPath=")) {
			locatorType = String.format(locatorType,(Object[]) dynamicValue);
		}
		return locatorType;
	}
	public void waitForElementClickableDynamic(AppiumDriver appiumDriver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocators(getXpathDynamic(locatorType, dynamicValues))));
	}


	public void clickToElementDynamic(AppiumDriver appiumDriver, String locatorType, String... dynamicValues) {
		locatorType = getXpathDynamic(locatorType, dynamicValues);
		getMobileElement(appiumDriver,locatorType ).click();
	}

	public boolean isElementEnabledDynamic(AppiumDriver appiumDriver, String locatorType, String...dynamicValue) {
		return getMobileElement(appiumDriver,getXpathDynamic(locatorType, dynamicValue)).isEnabled();
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BasePage openPagesAtBottomMenu(AppiumDriver appiumDriver, String pageName) {
		waitForElementClickableDynamic(appiumDriver, BasePageUI.DYNAMIC_BOTTOM_MENU, pageName);
		clickToElementDynamic(appiumDriver, BasePageUI.DYNAMIC_BOTTOM_MENU, pageName);
		switch (pageName) {
			case "Nhập hàng":
				return PageGeneratorManager.getShopPage(appiumDriver);
			case "Tài khoản":
				return PageGeneratorManager.getTaiKhoanPage(appiumDriver);
			case "Dịch vụ":
				return PageGeneratorManager.getDichVuPage(appiumDriver);
			default:
				throw new RuntimeException("Invalid page name ^.^");
		}
	}
	public BasePage openPurchasePage(AppiumDriver appiumDriver, String pageName) {
		waitForElementClickableDynamic(appiumDriver, BasePageUI.DYNAMIC_PURCHASE_SUB_MENU, pageName);
		clickToElementDynamic(appiumDriver, BasePageUI.DYNAMIC_PURCHASE_SUB_MENU, pageName);
		switch (pageName) {
			case "Nhập hàng theo Nhà phân phối":
				return PageGeneratorManager.getDistributorPage(appiumDriver);
			case "Nhập hàng theo thương hiệu":
				return PageGeneratorManager.getBrandPage(appiumDriver);
			default:
				throw new RuntimeException("Invalid page name ^.^");
		}
	}

	public void getMobileSizeAndScrollToScreen(AppiumDriver appiumDriver, int xStart,int xEnd,int yStart,int yEnd){
		Dimension windownSize = appiumDriver.manage().window().getSize();
		int screenHight = windownSize.getHeight();
		int screenWidth = windownSize.getWidth();
		int xStartPoint = xStart * screenWidth / 100;
		int xEndPoint = xEnd * screenWidth / 100;

		int yStartPoint = yStart * screenHight / 100;
		int yEndPoint = yEnd * screenHight / 100;

		PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint,yStartPoint);
		PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint,yEndPoint);

		TouchAction touchAction = new TouchAction(appiumDriver);
		touchAction
				.press(startPoint)
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
				.moveTo(endPoint)
				.release()
				.perform();
	}

	//-----------------------

	@SuppressWarnings("rawtypes")
	TouchAction action;

	@SuppressWarnings("static-access")
	public By getLocator(String locator) {
		By by = null;
		if (locator.startsWith("id=")) {
			by = by.id(locator.substring(3));
		} else if (locator.startsWith("name=")) {
			by = by.name(locator.substring(5));
		} else if (locator.startsWith("class=")) {
			by = by.className(locator.substring(6));
		} else if (locator.startsWith("css=")) {
			by = by.cssSelector(locator.substring(4));
		} else if (locator.startsWith("xpath=")) {
			by = by.xpath(locator.substring(6));

		} else {
			throw new RuntimeException("Locator invalid");
		}
		return by;
	}

	public String getLocator(String variableLocator, String... dynamicValues) {
		if (variableLocator.startsWith("xpath=")) {
			variableLocator = String.format(variableLocator, (Object[]) dynamicValues);
		}
		return variableLocator;
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getLocator(locator));
	}

	public WebElement getElement(WebDriver driver, String locator, String... dynamicLocator) {
		locator = getLocator(locator, dynamicLocator);
		return driver.findElement(getLocator(locator));
	}

	public List<WebElement> getListElement(WebDriver driver, String locator) {
		return driver.findElements(getLocator(locator));
	}

	public List<WebElement> getListElement(WebDriver driver, String locator, String... dynamicLocator) {
		return driver.findElements(getLocator(getLocator(locator, dynamicLocator)));
	}

	public int getElementSize(WebDriver driver, String locator) {
		return getListElement(driver, locator).size();
	}

	public void srollHorizonFromEl1ToEl2(PerformsTouchActions driver, WebElement el1, WebElement el2) {
		int midOfY = el2.getLocation().y + (el2.getSize().height / 2);
		int fromXLocation = el2.getLocation().x;
		int toXLocation = el1.getLocation().x;
		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(fromXLocation, midOfY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(toXLocation, midOfY)).release().perform();
	}

	public WebElement getElementDynamic(WebDriver driver, String locator, String... dynamicLocator) {
		locator = getLocatorDynamic(locator, dynamicLocator);
		return driver.findElement(getLocator(locator));
	}

	public String getLocatorDynamic(String variableLocator, String... dynamicValues) {
		if (variableLocator.startsWith("xpath=")) {
			variableLocator = String.format(variableLocator, (Object[]) dynamicValues);
		}
		return variableLocator;
	}

	public int getElementSize(WebDriver driver, String locator, String... dynamicLocator) {
		locator = getLocator(locator, dynamicLocator);
		return getListElement(driver, locator).size();
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String textItem) {
		Select select = new Select(getElement(driver, locator));
		select.selectByValue(textItem);

	}

	public void selectItemDefaultDropdown(WebDriver driver, String locator, String textValue,
										  String... dynamicLocator) {
		Select select = new Select(getElement(driver, locator, dynamicLocator));
		select.selectByVisibleText(textValue);
	}

	public void clickToElement(WebDriver driver, String locator) {
		waitForClickToElement(driver, locator);
		getElement(driver, locator).click();
	}

	public void pressEnter(AndroidDriver<MobileElement>  driver) {
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	public void clickToElement(WebDriver driver, String locator, String... dynamicLocator) {
		waitForClickToElementDynamic(driver, locator, dynamicLocator);
		getElement(driver, locator, dynamicLocator).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String textSenkey) {
		waitForELementVisible(driver, locator);
		WebElement element = getElement(driver, locator);
		element.clear();
		getElement(driver, locator).sendKeys(textSenkey);
	}

	public void cleanText(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		element.clear();
	}

	public void senkeyToElement(WebDriver driver, String textSenkey, String locator, String... dynamicLocator) {
		WebElement element = getElement(driver, getLocator(locator, dynamicLocator));
		element.clear();
		getElement(driver, locator, dynamicLocator).sendKeys(textSenkey);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getElement(driver, locator));
	}

	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}

	public String getElementText(WebDriver driver, String variableLocator, String... dynamicLocator) {
		variableLocator = getLocator(variableLocator, dynamicLocator);
		return getElement(driver, variableLocator).getText().trim();
	}

	public String getElAttribute(WebDriver driver, String locator, String attribute) {
		return getElement(driver, locator).getAttribute(attribute);
	}

	public String getElAttribute(WebDriver driver, String variableLocator, String attribute, String... dynamicLocator) {
		variableLocator = getLocator(variableLocator, dynamicLocator);
		return getElement(driver, variableLocator).getAttribute(attribute);
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 3);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public void getAlertText(WebDriver driver) {
		waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textSenkey) {
		waitForAlertPresence(driver).sendKeys(textSenkey);
	}

	public boolean isElementDisplay(WebDriver driver, String locator) {
		waitForELementVisible(driver, locator);
		return getElement(driver, locator).isDisplayed();
	}

	public boolean isElementDisplay(WebDriver driver, String locator, String... dynamicLocator) {
		waitForELementVisible(driver, locator, dynamicLocator);
		return getElement(driver, locator, dynamicLocator).isDisplayed();
	}

	public boolean isElSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public boolean isElEnable(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public void clickToElementDynamic(WebDriver driver, String locator, String... dynamicLocator) {
		waitForClickToElementDynamic(driver, locator, dynamicLocator);
		getElementDynamic(driver, locator, dynamicLocator).click();
	}

	public void waitForELementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, 30);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locator)));
	}

	public void waitForELementVisible(WebDriver driver, String variableLocator, String... dynamicLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, 30);
		explicitwait.until(
				ExpectedConditions.visibilityOfElementLocated(getLocator(getLocator(variableLocator, dynamicLocator))));
	}

	public void waitForAllELementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, 30);
		explicitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getLocator(locator)));
	}

	public void waitForELementInVisible(WebDriver driver, String locator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, 30);
		explicitwait.until(ExpectedConditions.invisibilityOfElementLocated(getLocator(locator)));
	}

	public void waitForAllELementInVisible(WebDriver driver, String locator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, 30);
		explicitwait.until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, locator)));
	}

	public void waitForClickToElement(WebDriver driver, String locator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, 30);
		explicitwait.until(ExpectedConditions.elementToBeClickable(getLocator(locator)));
	}

	public void waitForClickToElementDynamic(WebDriver driver, String variableLocator, String... dynamicLocator) {
		WebDriverWait explicitwait = new WebDriverWait(driver, 30);
		explicitwait.until(
				ExpectedConditions.elementToBeClickable(getLocator(getLocator(variableLocator, dynamicLocator))));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(driver, locator));
	}

	public void sleepSecond(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	public void swipeScreenToElement(PerformsTouchActions driver, DIRECTION direction, String listElement) {
//		((WebDriver) driver).manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		int sizeList = getElementSize((WebDriver) driver, listElement );
//		while (sizeList == 0) {
//			swipe(driver, direction, 1000);
//			sizeList = getElementSize((WebDriver) driver, listElement);
//		}
//		((WebDriver) driver).manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	}

//	public void swipeScreenToElement(PerformsTouchActions driver, DIRECTION direction, String listElement,
//									 String... dynamicLocator) {
//		((WebDriver) driver).manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		int sizeList = getElementSize((WebDriver) driver, listElement, dynamicLocator);
//		while (sizeList == 0) {
//			swipe(driver, direction, 1000);
//			sizeList = getElementSize((WebDriver) driver, listElement, dynamicLocator);
//		}
//		((WebDriver) driver).manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	}

	public void tapCenterScreenAndSwipe(AndroidDriver<MobileElement> driver) {
		int centerX = getScreenWidth(driver);
		int centerY = getScreenHeight(driver);
		int startY = (int) (centerY * 0.70);
		new TouchAction(driver).press(PointOption.point(centerX / 2, centerY / 2))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(centerX / 2, (int) (centerY * 0.02))).release().perform();
	}

	public void scrollToTop(AndroidDriver<MobileElement> driver, String locatorFrom, String locatorTo,
							String... dynamicLocatorFrom) {
		int x;
		int y;
		if (locatorTo.isEmpty()) {
			x = 70;
			y = 160;
		} else {
			x = getX(driver, locatorTo);
			y = getY(driver, locatorTo);
		}
		new TouchAction(driver)
				.longPress(PointOption.point(getX(driver, locatorFrom, dynamicLocatorFrom),
						getY(driver, locatorFrom, dynamicLocatorFrom)))
				.moveTo(PointOption.point(x, y)).release().perform();
	}

	public void scrollEl1ToEl2ByPoint(AndroidDriver<MobileElement> driver, int xFrom, int yFrom, int xTo, int yTo) {
		new TouchAction(driver).longPress(PointOption.point(xFrom, yFrom)).moveTo(PointOption.point(xTo, yTo)).release()
				.perform();
	}

	@SuppressWarnings("rawtypes")
	public void dropAndDrag(PerformsTouchActions driver, String el1, String el2) {
		action = new TouchAction(driver);
		action.longPress(new LongPressOptions()
						.withElement(new ElementOption().withElement(getElement((WebDriver) driver, el1)))).waitAction()
				.moveTo(new ElementOption().withElement(getElement((WebDriver) driver, el2))).perform();
	}

	@SuppressWarnings("rawtypes")
	public void dropAndDragToPoint(PerformsTouchActions driver, String el1, int x, int y) {
		action = new TouchAction(driver);
		action.longPress(new LongPressOptions()
						.withElement(new ElementOption().withElement(getElement((WebDriver) driver, el1)))).waitAction()
				.moveTo(PointOption.point(x, y)).perform();
	}

//	@SuppressWarnings("rawtypes")
//	public void swipe(PerformsTouchActions driver, DIRECTION direction, long duration) {
//		int startX = 0;
//		int endX = 0;
//		int startY = 0;
//		int endY = 0;
//		int height = getScreenHeight((WebDriver) driver);
//		int width = getScreenWidth((WebDriver) driver);
//		switch (direction) {
//			case LEFT:
//				startY = (int) (height / 2);
//				startX = (int) (width * 0.90);
//				endX = (int) (width * 0.05);
//				new TouchAction(driver).press(PointOption.point(startX, startY))
//						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
//						.moveTo(PointOption.point(endX, startY)).release().perform();
//				break;
//			case RIGHT:
//				startY = (int) (height / 2);
//				startX = (int) (width * 0.05);
//				endX = (int) (width * 0.90);
//				new TouchAction(driver).press(PointOption.point(startX, startY))
//						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
//						.moveTo(PointOption.point(endX, startY)).release().perform();
//				break;
//			case UP:
//				endY = (int) (height * 0.80);
//				startY = (int) (height * 0.20);
//				startX = (width / 2);
//				new TouchAction(driver).press(PointOption.point(startX, startY))
//						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
//						.moveTo(PointOption.point(startX, endY)).release().perform();
//				break;
//			case DOWN:
//				startY = (int) (height * 0.80);
//				endY = (int) (height * 0.20);
//				startX = (width / 2);
//				new TouchAction<>(driver).press(PointOption.point(startX, startY))
//						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
//						.moveTo(PointOption.point(startX, endY)).release().perform();
//				break;
//		}
//	}
	public void swipe(AndroidDriver<MobileElement> driver, DIRECTION direction, long duration) {
		TouchAction<?> touchAction = new TouchAction<>(driver);
		int startX = 0;
		int endX = 0;
		int startY = 0;
		int endY = 0;
		int height = getScreenHeight((driver) );
		int width = getScreenWidth(driver);
		switch (direction) {
			case LEFT:
				startY = (int) (height / 2);
				startX = (int) (width * 0.90);
				endX = (int) (width * 0.05);
				new TouchAction(driver).press(PointOption.point(startX, startY))
						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
						.moveTo(PointOption.point(endX, startY)).release().perform();
				break;
			case RIGHT:
				startY = (int) (height / 2);
				startX = (int) (width * 0.05);
				endX = (int) (width * 0.90);
				new TouchAction(driver).press(PointOption.point(startX, startY))
						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
						.moveTo(PointOption.point(endX, startY)).release().perform();
				break;
			case UP:
				endY = (int) (height * 0.80);
				startY = (int) (height * 0.20);
				startX = (width / 2);
				new TouchAction(driver).press(PointOption.point(startX, startY))
						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
						.moveTo(PointOption.point(startX, endY)).release().perform();
				break;
			case DOWN:
				startY = (int) (height * 0.80);
				endY = (int) (height * 0.20);
				startX = (width / 2);
				touchAction.press(PointOption.point(startX, startY))
						.waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
						.moveTo(PointOption.point(startX, endY)).release().perform();
				break;
		}
	}

	public void scrollHorizonFromEl1ToEl2(PerformsTouchActions driver, WebElement el1, WebElement el2) {
		((WebDriver) driver).manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		int midOfY = el2.getLocation().y + (el2.getSize().height / 2);
		int fromXLocation = el2.getLocation().x;
		int toXLocation = el1.getLocation().x;
		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(fromXLocation, midOfY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(toXLocation, midOfY)).release().perform();
		((WebDriver) driver).manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void pullToRefreshPage(PerformsTouchActions driver, Float device) {
		int deviceWidth = getScreenWidth((WebDriver) driver);
		int deviceHeight = getScreenHeight((WebDriver) driver);
		int midX = (deviceWidth / 2);
		int midY = (deviceHeight / 2);
		int bottomEdge = (int) (deviceHeight * device);
		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(midX, midY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(midX, bottomEdge)).release().perform();
	}

	public int getScreenWidth(WebDriver driver) {
		return driver.manage().window().getSize().getWidth();
	}

	public int getScreenHeight(WebDriver driver) {
		return driver.manage().window().getSize().getHeight();
	}

	public int getHeightEl(WebDriver driver, String locator) {
		return getElement(driver, locator).getSize().getWidth();
	}

	public int getWidthEl(WebDriver driver, String locator) {
		return getElement(driver, locator).getSize().getHeight();
	}

	public Integer getX(WebDriver driver, String locator) {
		return getElement(driver, locator).getLocation().getX();
	}

	public Integer getY(WebDriver driver, String locator) {
		return getElement(driver, locator).getLocation().getY();
	}

	public Integer getX(WebDriver driver, String locator, String... dynamicLocator) {
		return getElement(driver, locator, dynamicLocator).getLocation().getX();
	}

	public Integer getY(WebDriver driver, String locator, String... dynamicLocator) {
		return getElement(driver, locator, dynamicLocator).getLocation().getY();
	}

	@SuppressWarnings("rawtypes")
	public void tapPoint(PerformsTouchActions driver, int x, int y) {
		action = new TouchAction(driver);
		action.tap(PointOption.point(x, y)).perform();
	}

	public void clickToElementAppear(WebDriver driver, String locator) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		int sizeEl = getElementSize(driver, locator);
		if (sizeEl > 0) {
			clickToElement(driver, locator);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public int ranDomNumber(int start, int end) {
		int ranNum = ThreadLocalRandom.current().nextInt(start, end);
		return ranNum;
	}


	public void resetApp(AndroidDriver<MobileElement> driver) {
		driver.resetApp();
	}


}
