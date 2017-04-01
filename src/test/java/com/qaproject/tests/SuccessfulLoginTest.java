package com.qaproject.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import webdriver.BaseTest;

import com.qaproject.pages.LoginCredentialPage;
import com.qaproject.pages.TutByMainPage;

public class SuccessfulLoginTest extends BaseTest {

	TutByMainPage tutByMainPage;
	String userName, userEmail, userPassWord;

	@Parameters({ "userName", "userEmail", "passWord" })
	@BeforeTest
	public void SetUp(String _userName, String _userEmail, String _passWord) {
		this.userName = _userName;
		this.userEmail = _userEmail;
		this.userPassWord = _passWord;
	}

	@Override
	public void runTest() {

		logStep();

		tutByMainPage = new TutByMainPage();
		tutByMainPage.openLoginCredentialPage();

		logStep();
		LoginCredentialPage loginCredentialPage = new LoginCredentialPage();
		loginCredentialPage.typeLogin(userEmail);
		loginCredentialPage.typePassWord(userPassWord);
		loginCredentialPage.uncheckCheckBox();
		loginCredentialPage.sendCredential();

		logStep();
		tutByMainPage.getLoggedInUserName();

		assertEquals(tutByMainPage.getLoggedInUserName(), userName);

	}
}
