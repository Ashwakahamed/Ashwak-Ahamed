package com.runner;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo.Your_logo_sample_pojo;
import com.utility.Common_methods;

public class HeaderFooterVerify extends Common_methods {

	Your_logo_sample_pojo l;
	String header_initial;
	String footer_initial;
	String header_after_click;
	String footer_after_click;

	@BeforeClass

	private void befAll() {

		launchBrowser();
		launchUrl("http://automationpractice.com/index.php");
		l = new Your_logo_sample_pojo();
	}

	@BeforeMethod
	private void beforeHeaderFooterValidation() {

		header_initial = toGetText(l.headerContact);
		footer_initial = toGetText(l.footerinformation);

		System.out.println("Before Click header: " + header_initial);
		System.out.println("Before Click footer: " + footer_initial);
	}

	@AfterMethod
	private void afterHeaderFooterValidation() {
		header_after_click = toGetText(l.headerContact);
		footer_after_click = toGetText(l.footerinformation);

		System.out.println("After Click header: " + header_after_click);
		System.out.println("After Click footer: " + footer_after_click);

		Assert.assertEquals(header_initial, header_after_click);
		Assert.assertEquals(footer_initial, footer_after_click);
	}

	@Test(priority = 1)
	private void aTest() {
		btnClick(l.women);
		System.out.println("Women");
	}

	@Test(priority = 2)
	private void bTest() {
		btnClick(l.dress);
		System.out.println("Dress");
	}

	@Test(priority = 3)
	private void cTest() {
		btnClick(l.tShirt);
		System.out.println("TShirt");
	}



}
