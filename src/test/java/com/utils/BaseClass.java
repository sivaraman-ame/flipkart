package com.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static WebElement element;

	public static void firefoxDriver() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\USER\\sivaraman\\QatarAirline\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	public static void chromeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\USER\\sivaraman\\QatarAirline\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void iEDriver() {
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\USER\\sivaraman\\QatarAirline\\Driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}

	public static void launchPage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void waitImplicit(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static WebElement xpath(String xpath) {
		element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public static WebElement id(String id) {
		element = driver.findElement(By.id(id));
		return element;
	}

	public static WebElement name(String name) {
		element = driver.findElement(By.name(name));
		return element;
	}

	public static WebElement className(String classpath) {
		element = driver.findElement(By.className(classpath));
		return element;
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void doubleclk(WebElement element) {

		Actions act = new Actions(driver);
		act.doubleClick(element).perform();

	}

	public static String getAttribute(WebElement element, String name) {
		String text = element.getAttribute(name);
		System.out.println(text);
		return text;
	}

	public static String getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;

	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void moveToElement(WebElement element) {

		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public static void dragAndDrop(String srcxpth, String trgtxpth) {
		WebElement source = xpath(srcxpth);
		WebElement target = xpath(trgtxpth);
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	public static void contextClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();

	}

	public static void frame(String frname) {
		driver.switchTo().frame(frname);
	}

	public static void windowHandle() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String x : child) {
			if (!x.equals(parent)) {
				driver.switchTo().window(x);
			}
		}
	}

	public static void scrollDown(WebElement element) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void scrollUp(String xpath) {
		element = xpath(xpath);
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void screenShot(String fpath) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(fpath);
		FileUtils.copyFile(source, dest);
	}

	public static void selectValue(String xpath, String value) {
		element = xpath(xpath);
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public static void deSelectValue(String xpath, String value) {
		element = xpath(xpath);
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	public static void selectInt(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static void deSelectInt(String xpath, int index) {
		element = xpath(xpath);
		Select s = new Select(element);
		s.deselectByIndex(index);
	}

	public static void selectText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public static void deSelectText(String xpath, String text) {
		element = xpath(xpath);
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}

	public static void deSelectAll(String xpath) {
		element = xpath(xpath);
		Select s = new Select(element);
		s.deselectAll();
	}

	public static void getoption(String xpath) {
		element = xpath(xpath);
		Select s = new Select(element);
		List<WebElement> li = s.getOptions();
		int size = li.size();
		System.out.println(size);
	}

	public static void printalloption(String xpath) {
		element = xpath(xpath);
		Select s = new Select(element);
		List<WebElement> li = s.getOptions();
		for (WebElement x : li) {
			String text = x.getText();
			System.out.println(text);

		}
	}

	public static void getSelectedOption(String xpath) {
		element = xpath(xpath);
		Select s = new Select(element);
		List<WebElement> li = s.getAllSelectedOptions();
		int size = li.size();
		System.out.println(size);

	}

	public static void printAllSelectedOptions(String xpath) {
		element = xpath(xpath);
		Select s = new Select(element);
		List<WebElement> li = s.getAllSelectedOptions();
		for (WebElement x : li) {
			String text = x.getText();
			System.out.println(text);

		}

	}

	public static void getFirstSelectedOption(String xpath) {
		element = xpath(xpath);
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);

	}

	public static void isMultiple() {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	public static void robotDown(int value) throws AWTException {
		Robot rt = new Robot();
		for (int i = 0; i < value; i++) {
			rt.keyPress(KeyEvent.VK_DOWN);
			rt.keyRelease(KeyEvent.VK_DOWN);
		}
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void robotCopy() throws AWTException {
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_C);
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_C);
	}

	public static void robotPaste() throws AWTException {
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_V);
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_V);
	}

	public static void robotCut() throws AWTException {
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_X);
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_X);
	}

	public static void alertAccept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public static void alertDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public static void alertSendKeysAccept(String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
		a.accept();
	}

	public static void alertSendKeysDismiss(String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
		a.dismiss();
	}

	public static void To(String url) {
		driver.navigate().to(url);
	}

	public static void Back() {
		driver.navigate().back();
	}

	public static void Forward() {
		driver.navigate().forward();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void isDisplayed() {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}

	public static void isEnabled() {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}

	public static void isSelected() {
		boolean selected = element.isSelected();
		System.out.println(selected);
	}

	public static void frameParent() {
		driver.switchTo().parentFrame();
	}

	public static void frameDefault() {
		driver.switchTo().defaultContent();
	}

	public static void javaScriptSendKeys(String args) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript(args, element);
	}

	public static void javaScriptclick() {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].click()", element);
	}

	public static String readExcelValue(String name, int row, int cell) throws IOException {
		String value;

		File f = new File("C:\\Users\\USER\\sivaraman\\Flipkart\\filemaintenance\\second.xlsx");
		FileInputStream st = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(st);
		Sheet sheet = book.getSheet(name);
		Row r = sheet.getRow(row);
		Cell c = r.getCell(cell);
		int cellType = c.getCellType();
		if (cellType == 1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
			value = dateFormat.format(date);
		} else {
			double d = c.getNumericCellValue();
			long lo = (long) d;
			value = String.valueOf(lo);

		}
		return value;

	}

	public static void createExcelValue(String value, String name, int row, int cell) throws IOException {

		File f = new File("C:\\Users\\USER\\sivaraman\\Flipkart\\filemaintenance\\third.xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet(name);
		Row r = sheet.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(value);
		FileOutputStream st = new FileOutputStream(f);
		book.write(st);

	}

}
