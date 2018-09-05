package com.gmail.qa.testcases;

import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.IntroductionPage;
import com.gmail.qa.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginTest {

	public static Properties prop;

	public LoginTest() {

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

	public void positiveLoginTest() {

		IntroductionPage introductionPage = new IntroductionPage();

		introductionPage.open();
		System.out.println("Starting positive Login test");

		LogInPage logInPage = introductionPage.openSignInPage();

		HomePage homePage = logInPage.userLogIn(prop.getProperty("username"), prop.getProperty("password"));

		Assert.assertTrue(homePage.isUserAvatarDisplayed());

	}

	@Test

	public void negativeLoginTestWrongUserId() {

		IntroductionPage introductionPage = new IntroductionPage();

		introductionPage.open();

		System.out.println("Starting incorrect LogIn useID test");

		LogInPage logInPage = introductionPage.openSignInPage();

		HomePage homePage = logInPage.wrongUserLoginID(prop.getProperty("wrongUserID"));

		Assert.assertTrue(logInPage.isUWrongUserNameErrorMessageDisplayed());

	}

	@Test

	public void negativeLoginTestWrongPassword() {

		IntroductionPage introductionPage = new IntroductionPage();

		introductionPage.open();

		System.out.println("Starting incorrect LogIn userPassword test");

		LogInPage logInPage = introductionPage.openSignInPage();

		HomePage homePage = logInPage.wrongUserLoginPassword(prop.getProperty("username"), prop.getProperty("wrongPassword"));

		Assert.assertTrue(logInPage.isWrongPasswordErrorMessageDisplayed());

	}


}
