package com.skv.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	final WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "userName")
	private WebElement usernameEditbox;

	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordEditbox;

	@FindBy(how = How.NAME, using = "login")
	private WebElement singinButton;

	public void enterUsername(String login) {
		usernameEditbox.clear();
		usernameEditbox.sendKeys(login);
	}

	public void enterPassword(String password) {
		passwordEditbox.clear();
		passwordEditbox.sendKeys(password);
	}

	public void clickSigninButton() {
		singinButton.click();
	}

	public HomePage login(String login, String password) {
		enterUsername(login);
		enterPassword(password);
		clickSigninButton();
		return PageFactory.initElements(driver, HomePage.class);
	}
}
