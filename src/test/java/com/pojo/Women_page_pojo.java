package com.pojo;//a[text()='Women']//..//ul//li//a[text()='Dresses']//..//ul//a

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Common_methods;

public class Women_page_pojo extends Common_methods {

	public Women_page_pojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[contains(@class,'product_list')]//li[contains(@class,'product')]")
	public List<WebElement> allProducts;

	@FindBy(xpath = "//a[text()='In stock']//parent::label//preceding-sibling::div")
	public WebElement checkBoxInstock;

	public void selectDressType(String catgHeader, String dressHeader, String season) {

		List<WebElement> allDressTypes = driver.findElements(
				By.xpath("//a[text()='" + catgHeader + "']//..//ul//li//a[text()='" + dressHeader + "']//..//ul//a"));
		for (WebElement eachDressType : allDressTypes) {
			String dressSeason = eachDressType.getText();
			if (dressSeason.contains(season)) {
				eachDressType.click();
			}
		}

	}

	public boolean prodPriceList() {
		String path = "//ul[contains(@class,'product_list')]//li[contains(@class,'product')]//h5//..//div[@itemprop='offers']//span[@itemprop='price']";
		List<WebElement> allPriceEle = driver.findElements(By.xpath(path));
		List<String> li1 = new ArrayList<String>();
		boolean status = true;

		for (WebElement eachPriceEle : allPriceEle) {
			String eachPriceText = eachPriceEle.getText().trim();
			li1.add(eachPriceText);
		}

		List<String> li2 = new ArrayList<String>();
		li2.addAll(li1);

		Collections.sort(li2);

		if (li1.equals(li2)) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}

}
