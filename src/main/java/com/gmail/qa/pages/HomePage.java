package com.gmail.qa.pages;

import org.openqa.selenium.By;

public class HomePage extends AbstractPage {


	private static final By COMPOSE_BUTTON_LOCATOR = By.xpath("//div[@gh=\"cm\"]");
	private static final By INBOX__BUTTON_LOCATOR = By.xpath("//a[@title='Inbox']");
	private static final By SENT__BUTTON_LOCATOR = By.xpath("//a[@title='Sent']");
	private static final By MORE__BUTTON_LOCATOR = By.xpath("//span[@class='CJ'][contains(.,'More')]");
	private static final By TRASH__BUTTON_LOCATOR = By.xpath("//a[@title='Trash']");
	private static final By USER_AVATAR_LOCATOR = By.xpath("//a[contains(@aria-label,'potlightexpress@gmail.com')]");


	public NewMessagePage clickComposeButton() {

		browser.click(COMPOSE_BUTTON_LOCATOR);
		return new NewMessagePage();

	}

	public InboxPage clickInboxButton() {

		browser.click(INBOX__BUTTON_LOCATOR);
		return new InboxPage();
	}

	public SentPage clickSentButton() {

		browser.click(SENT__BUTTON_LOCATOR);
		return new SentPage();
	}

	public void clickMoreButton() {

		browser.click(MORE__BUTTON_LOCATOR);

	}

	public TrashPage clickTrashButton() {

		browser.click(TRASH__BUTTON_LOCATOR);
		return new TrashPage();

	}

	public boolean isUserAvatarDisplayed() {
		return browser.isDisplayed(USER_AVATAR_LOCATOR);
	}

}
