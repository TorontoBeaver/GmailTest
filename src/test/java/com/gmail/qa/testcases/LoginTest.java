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

		LogInPage logInPage = introductionPage.openSignInPage();
		HomePage homePage = logInPage.logInUserName("potlightexpress", "Vlad1961$");
		Assert.assertTrue(homePage.isUserAvatarDisplayed());

	}
}
