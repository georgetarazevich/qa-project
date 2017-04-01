package com.qaproject.pages;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.CheckBox;
import webdriver.elements.TextBox;

public class LoginCredentialPage extends BaseForm {
	By txbLoginLocator = By.xpath("//input[@class='i-p' and  @name='login']");
	TextBox txbLogin = new TextBox(txbLoginLocator, "Login");

	By txbPassWordLocator = By
			.xpath("//input[@class='i-p' and @name='password']");
	TextBox txbPassWord = new TextBox(txbPassWordLocator, "PassWord");

	By btnSendCredentialLocator = By.xpath("//*[@id='authorize']//input[@class='button auth__enter' and @value='Войти']");
	CheckBox btnSendCredential = new CheckBox(btnSendCredentialLocator, "Войти");
	
	By chkBoxLocator = By.xpath("//*[@id='memory']");
	CheckBox chkBox = new CheckBox(chkBoxLocator, "Запомнить");

	public LoginCredentialPage() {
		super(By.xpath("//form [@class='auth-form']"), "Authorized form");
	}

	public void typeLogin(String login) {
		txbLogin.type(login);
	}

	public void typePassWord(String passWord) {
		txbPassWord.type(passWord);
	}

	public void sendCredential() {
		btnSendCredential.clickByMouse();
	}
	
	public void uncheckCheckBox() {
		chkBox.uncheckCheckBox();
	}

}
