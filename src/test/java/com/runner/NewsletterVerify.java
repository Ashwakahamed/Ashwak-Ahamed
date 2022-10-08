package com.runner;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo.Your_logo_sample_pojo;
import com.utility.Common_methods;

public class NewsletterVerify extends Common_methods {
	Your_logo_sample_pojo l;
	String emailValid;

	@BeforeMethod
	private void start() {
		l = new Your_logo_sample_pojo();
		btnClick(l.pageLogo);

	}

	@Test(priority = 4)
	private void newsTest1() throws InterruptedException {

		int min = 100;
		int max = 999;
		int number = (int) (Math.random() * (max - min + 1) + min);

		emailValid = "ahamed" + number + "@yopmail.com";
		System.out.println("Input Field (Newsletter with valid email) : " + emailValid);
		fillText(l.newsLetterTextField, emailValid);
		btnClick(l.newsLetterSearchButton);

	}

	@Test(priority = 5)
	private void newTest2() throws InterruptedException {

		String emailBlank = "";
		System.out.println("Input Field (Newsletter with blank email) : " + emailBlank);
		fillText(l.newsLetterTextField, emailBlank);
		btnClick(l.newsLetterSearchButton);

	}

	@Test(priority = 6)
	private void newTest3() throws InterruptedException {

		String emailExisting = emailValid;
		System.out.println("Input Field (Newsletter with Existing email) : " + emailExisting);
		fillText(l.newsLetterTextField, emailExisting);
		btnClick(l.newsLetterSearchButton);

	}

	@AfterMethod
	private void verifyNewsLetter() {

		if (toGetText(l.newsLetterAlertStatus).contains("success")) {
			System.out.println("Successfully Subscribed");
		} else if (toGetText(l.newsLetterAlertStatus).contains("Invalid")) {
			System.out.println("Input not given in NewsLetter field");
		} else if (toGetText(l.newsLetterAlertStatus).contains("already")) {
			System.out.println("Email is already existing");
		}

	}

}
