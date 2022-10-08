package com.pojo;//button[@name='submitNewsletter']

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Common_methods;

public class Your_logo_sample_pojo extends Common_methods {

	public Your_logo_sample_pojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Women']")
	public WebElement women;

	@FindBy(xpath = "(//a[text()='Dresses'])[2]")
	public WebElement dress;

	@FindBy(xpath = "(//a[text()='T-shirts'])[2]")
	public WebElement tShirt;

	@FindBy(xpath = "//a[text()='Contact us']")
	public WebElement headerContact;

	@FindBy(xpath = "//h4[text()='Information']")
	public WebElement footerinformation;

	@FindBy(xpath = "//p[contains(@class,'alert')]")
	public WebElement alert1;

	@FindBy(xpath = "//input[@id='newsletter-input']")
	public WebElement newsLetterTextField;

	@FindBy(xpath = "//button[@name='submitNewsletter']")
	public WebElement newsLetterSearchButton;

	@FindBy(xpath = "//p[contains(@class,'alert')]")
	public WebElement newsLetterAlertStatus;

	@FindBy(xpath = "//a[@title='My Store']")
	public WebElement pageLogo;

}
