package com.gmail.qa.pages;

import org.openqa.selenium.By;

public class LogInPage extends AbstractPage {


	private static final By USER_NAME_FIELD_LOCATOR = By.id("identifierId");
	private static final By NEXT_BUTTON_LOCATOR = By.id("identifierNext");
	private static final By NEXT_BUTTON2_LOCATOR = By.id("passwordNext");
	private static final By PASSWORD_LOCATOR = By.xpath("//input[@name='password']");




	public HomePage logInUserName(String username, String password) {

		browser.type(USER_NAME_FIELD_LOCATOR, username);
		browser.click(NEXT_BUTTON_LOCATOR);
		browser.type(PASSWORD_LOCATOR, password);
		browser.click(NEXT_BUTTON2_LOCATOR);
		return new HomePage();
	}


}

