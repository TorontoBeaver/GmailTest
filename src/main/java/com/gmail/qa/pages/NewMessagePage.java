package com.gmail.qa.pages;

import org.openqa.selenium.By;

public class NewMessagePage extends AbstractPage {


	private static final By ADDRESS_INPUT_LOCATOR = By.xpath("//textarea[@name=\"to\"]");
	private static final By SUBJECT_INPUT_LOCATOR = By.xpath("//input[@name=\"subjectbox\"]");
	private static final By BODY_INPUT_LOCATOR = By.xpath("//div[@aria-label=\"Message Body\"]");
	private static final By SEND_BUTTON_LOCATOR = By.xpath("//div[@role='button' and contains(@data-tooltip,'Send')]");


	public HomePage sendMessage(String newMessageEmail, String newMessageSubject, String newMessage) {

		browser.type(ADDRESS_INPUT_LOCATOR, newMessageEmail);
		browser.type(SUBJECT_INPUT_LOCATOR, newMessageSubject);
		browser.type(BODY_INPUT_LOCATOR, newMessage);
		browser.click(SEND_BUTTON_LOCATOR);

		return new HomePage();
	}

}
