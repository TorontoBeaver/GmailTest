package com.gmail.qa.testcases;

import com.gmail.qa.base.Browser;
import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.IntroductionPage;
import com.gmail.qa.pages.LogInPage;
import com.gmail.qa.pages.NewMessagePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class HomePageTest {

	public static Properties prop;
	NewMessagePage newMessagePage = new NewMessagePage();
	LogInPage logInPage = new LogInPage();

	@BeforeClass

	public void setUpConfigFileProperties() {

		prop = new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream("src/main/java/com/gmail/qa/config/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test

	public void openHomePageTest() {

		System.out.println("Open LogInPage");

		logInPage.open();
		System.out.println("LogIn to Home Page");

		HomePage homePage = logInPage.userLogIn(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.isUserAvatarDisplayed());
	}

	@Test

	public void openNewMessagePageTest() {

		new HomePage().clickComposeButton();
		Assert.assertTrue(newMessagePage.subjectFieldIsDisplayed());
	}

	@Test

	public void wrightAndSendEmailMessageTest() {
		new NewMessagePage().sendMessage(prop.getProperty("email"), prop.getProperty("subject"), prop.getProperty("text"));
		Assert.assertTrue(newMessagePage.emailRecipientIsDisplayed());
	}


	@Test
	public void deleteReceivedMessageTest(){

	}


	@AfterClass(description = "close browser")

	public void kill() {
		Browser.kill();
	}
}



























