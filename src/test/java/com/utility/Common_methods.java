package com.utility;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Common_methods {

	public static WebDriver driver;
	public static Actions a;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void launchUrl(String url) {
		driver.get(url);

	}

	public static String toGetText(WebElement element) {
		String t = element.getText();
		return t;

	}

	public static void btnClick(WebElement element) {
		element.click();

	}

	public static void fillText(WebElement ele, String txt) {

		ele.sendKeys(txt);

	}

	public static void scrollIntoview(WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", ele);

	}

	public static void moveToele(WebElement ele) {

		a = new Actions(driver);

		a.moveToElement(ele).perform();
		;

	}

	public static void refreshPage() {
		driver.navigate().refresh();

	}

}
