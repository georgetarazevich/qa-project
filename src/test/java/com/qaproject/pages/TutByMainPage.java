package com.qaproject.pages;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.CheckBox;

public class TutByMainPage extends BaseForm {

	By chkBoxUserNameLocator = By
			.xpath("//*[@id='authorize']//*[@class='uname']");
	CheckBox chkBoxUserName = new CheckBox(chkBoxUserNameLocator);

	By btnShopsLocaator = By
			.xpath("(.//*[@id='mainmenu']//a[@class='topbar__link' and @title='Магазины'])[1]");
	Button btnShops = new Button(btnShopsLocaator, "Shops button");

	By btnLoginLocator = By.xpath("(.//*[@id='authorize']//a)[1]");
	Button btnLogin = new Button(btnLoginLocator, "Login Button");

	By btnFinanceTutByPageLocator = By.xpath("(//*[@id='mainmenu']//a[@title='Финансы'])[1]");
	Button btnFinanceTutByPage = new Button(btnFinanceTutByPageLocator, "FinanceTutByPage");
	
	public TutByMainPage() {
		super(By.xpath("//h1/a"), "Tut.by main page");
	}

	public void openTutByShopsPage() {
		btnShops.click();
	}

	public void openLoginCredentialPage() {
		btnLogin.clickByMouse();
	}

	public String getLoggedInUserName() {
		return chkBoxUserName.getText();
	}

	public void openLogOutPage() {
		chkBoxUserName.clickByMouse();
	}

	public void openFinanceTutByPage() {
		btnFinanceTutByPage.clickByMouse();
	}
}
