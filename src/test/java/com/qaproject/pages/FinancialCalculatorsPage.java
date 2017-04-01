package com.qaproject.pages;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;

public class FinancialCalculatorsPage extends BaseForm {

	private By btnDenominatorCalcLocator = By.xpath("//*[contains(text(), 'Деноминатор')]");
	private Button btnDenominatorCalcPage = new Button(btnDenominatorCalcLocator,
			"DenominatorCalc Button");

	public FinancialCalculatorsPage() {
		super(By.xpath("//table[@class='tbl m-tbl calculator_list']"), "Финансовые калькуляторы");
	}

	public void openDenominatorCalcPage() {
		btnDenominatorCalcPage.clickByMouse();
	}

}
