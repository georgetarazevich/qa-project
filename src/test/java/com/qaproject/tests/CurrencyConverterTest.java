package com.qaproject.tests;

import java.math.BigDecimal;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qaproject.pages.DenominatorCalcPage;
import com.qaproject.pages.FinanceTutByPage;
import com.qaproject.pages.FinancialCalculatorsPage;
import com.qaproject.pages.TutByMainPage;

import webdriver.BaseTest;

public class CurrencyConverterTest extends BaseTest {
	private TutByMainPage tutByMainPage;
	private String oldRublValue;

	@Parameters({ "oldRublValue" })
	@BeforeTest
	public void SetUp(String _oldRublValue) {
		oldRublValue = _oldRublValue;
	}

	@Override
	public void runTest() {

		logStep();
		tutByMainPage = new TutByMainPage();
		tutByMainPage.openFinanceTutByPage();

		logStep();
		FinanceTutByPage financeTutByPage = new FinanceTutByPage();
		financeTutByPage.openAllFinancialCalculatorPage();

		logStep();
		FinancialCalculatorsPage financialCalculatorsPage = new FinancialCalculatorsPage();
		financialCalculatorsPage.openDenominatorCalcPage();

		logStep();
		DenominatorCalcPage denominatorCalcPage = new DenominatorCalcPage();

		denominatorCalcPage.setOldRublValue(oldRublValue);
		
		BigDecimal actual = denominatorCalcPage.getActualResultConversions();
		BigDecimal expected = denominatorCalcPage.getExpectedResultConversions();
		
		assertEquals(expected, actual);

	}

}
