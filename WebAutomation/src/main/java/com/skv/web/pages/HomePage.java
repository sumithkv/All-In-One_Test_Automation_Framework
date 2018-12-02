package com.skv.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	final WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.LINK_TEXT, using = "SIGN-OFF")
	private WebElement signOff;

	public LoginPage singOff() {
		signOff.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}

}
