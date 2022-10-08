package com.runner;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo.Women_page_pojo;
import com.pojo.Your_logo_sample_pojo;
import com.utility.Common_methods;

public class WomenPageVerify extends Common_methods {

	Women_page_pojo womenPage;
	Your_logo_sample_pojo homePage;

	@BeforeMethod
	private void womenPageMethod() throws InterruptedException {

		womenPage = new Women_page_pojo();
		homePage = new Your_logo_sample_pojo();
		
		moveToele(homePage.women);

		womenPage.selectDressType("Women", "Dresses", "Summer");
		System.out.println("Completed");

	}

	@Test(priority = 7)
	private void womenTest1() throws InterruptedException {

		int noProdBefore = womenPage.allProducts.size();
		System.out.println(noProdBefore);
		btnClick(womenPage.checkBoxInstock);
		Thread.sleep(10000);

		int noProdAfter = womenPage.allProducts.size();
		System.out.println(noProdAfter);
		Assert.assertEquals(noProdBefore, noProdAfter, "Products filter is broken ");

	}

	@Test(priority = 8)
	private void womenTest2() {

		boolean prodPriceListStatus = womenPage.prodPriceList();

		Assert.assertTrue(prodPriceListStatus, "Products sorting is broken");

	}

}
