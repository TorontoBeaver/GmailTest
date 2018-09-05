package com.gmail.qa.pages;

import org.openqa.selenium.By;

public class LogInPage extends AbstractPage {


	private static final By USER_NAME_FIELD_LOCATOR = By.id("identifierId");
	private static final By NEXT_BUTTON_LOCATOR = By.id("identifierNext");
	private static final By NEXT_BUTTON2_LOCATOR = By.id("passwordNext");
	private static final By PASSWORD_LOCATOR = By.xpath("//input[@name='password']");
	private static final By EXPECTED_USERNAME_ERROR_MESSAGE = By.xpath("//div[contains(text(),\"Couldn't find your Google Account\")]");
	private static final By EXPECTED_USERPASSWORD_ERROR_MESSAGE = By.xpath("//div[contains(text(),\"Wrong password\")]");


	public HomePage userLogIn(String username, String password) {

		browser.type(USER_NAME_FIELD_LOCATOR, username);
		browser.click(NEXT_BUTTON_LOCATOR);
		browser.type(PASSWORD_LOCATOR, password);
		browser.click(NEXT_BUTTON2_LOCATOR);
		return new HomePage();
	}

	public HomePage wrongUserLoginID(String wrongUsername) {

		browser.type(USER_NAME_FIELD_LOCATOR, wrongUsername);
		browser.click(NEXT_BUTTON_LOCATOR);
		return new HomePage();
	}

	public boolean isUWrongUserNameErrorMessageDisplayed() {
		return browser.isDisplayed(EXPECTED_USERNAME_ERROR_MESSAGE);
	}

	public HomePage wrongUserLoginPassword(String username, String wrongPassword) {

		browser.type(USER_NAME_FIELD_LOCATOR, username);
		browser.click(NEXT_BUTTON_LOCATOR);
		browser.type(PASSWORD_LOCATOR, wrongPassword);
		browser.click(NEXT_BUTTON2_LOCATOR);
		return new HomePage();
	}

	public boolean isWrongPasswordErrorMessageDisplayed() {
		return browser.isDisplayed(EXPECTED_USERPASSWORD_ERROR_MESSAGE);
	}

}