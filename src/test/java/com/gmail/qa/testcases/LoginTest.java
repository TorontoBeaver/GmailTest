package com.gmail.qa.testcases;

import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.IntroductionPage;
import com.gmail.qa.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test

	public void positiveLoginTest() {

		IntroductionPage introductionPage = new IntroductionPage();

		introductionPage.open();
		System.out.println("Starting positive Login test");

		LogInPage logInPage = introductionPage.openSignInPage();
		HomePage homePage = logInPage.userLogIn("potlightexpress", "Vlad1961$");
		Assert.assertTrue(homePage.isUserAvatarDisplayed());

	}

	@Test

	public void negativeLoginTestWrongUserId() {

		IntroductionPage introductionPage = new IntroductionPage();

		introductionPage.open();

		System.out.println("Starting incorrect userName test");

		LogInPage logInPage = introductionPage.openSignInPage();

		HomePage homePage = logInPage.wrongUserLoginID("wrongUserLoginID");

		Assert.assertTrue(logInPage.isUWrongUserNameErrorMessageDisplayed());

	}

	@Test

	public void negativeLoginTestWrongPassword() {

		IntroductionPage introductionPage = new IntroductionPage();

		introductionPage.open();

		System.out.println("Starting incorrect userPassword test");

		LogInPage logInPage = introductionPage.openSignInPage();

		HomePage homePage = logInPage.wrongUserLoginPassword("potlightexpress","wrongPassword");

		Assert.assertTrue(logInPage.isWrongPasswordErrorMessageDisplayed());

	}


}
