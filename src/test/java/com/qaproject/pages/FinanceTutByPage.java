package com.qaproject.pages;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;

public class FinanceTutByPage extends BaseForm {

	By btnAllFinancialCalculatorLocator = By
			.xpath("(//a[contains(text(), 'Калькуляторы')])[1]");
	 
	
	Button btnAllFinancialCalculator = new Button(
			btnAllFinancialCalculatorLocator, "AllFinancialCalculator Button");

	public FinanceTutByPage() {
		super(By.xpath("//*[@class='b-header']"), "FinanceTutByPage");
	}

	public void openAllFinancialCalculatorPage() {
		btnAllFinancialCalculator.clickByMouse();
	}
}
