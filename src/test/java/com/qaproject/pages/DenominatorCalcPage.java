package com.qaproject.pages;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import webdriver.BaseForm;
import webdriver.elements.TextBox;

public class DenominatorCalcPage extends BaseForm {

	private String oldRublValue;

	private By txbOldValueLocator = By
			.xpath("//*[@id='old_value']");
	private TextBox txbOldValue = new TextBox(txbOldValueLocator,
			"В старых рублях");

	private By txbNewValueRubLocator = By.xpath("//*[@id='comm_rub']");
	private TextBox txbNewValueRub = new TextBox(txbNewValueRubLocator,
			"В новых рублях");

	private By txbNewValueKopLocator = By.xpath("//*[@id='comm_kop']");
	private TextBox txbNewValueKop = new TextBox(txbNewValueKopLocator,
			"и копейках");

	public DenominatorCalcPage() {
		super(By.xpath("//h1"), "Деноминатор");
	}

	public void setOldRublValue(String _oldRublValue) {
		this.oldRublValue = _oldRublValue;
		txbOldValue.clickByMouse();
		txbOldValue.type(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		txbOldValue.type(_oldRublValue);
	}

	public BigDecimal getExpectedResultConversions() {
		BigDecimal bigDecOldRublValue = BigDecimal.valueOf(Double.parseDouble(oldRublValue));
		return bigDecOldRublValue.divide(BigDecimal.valueOf(Double.parseDouble("10000")), 2, RoundingMode.UP);
	}

	public BigDecimal getActualResultConversions() {
				
		String newV = txbNewValueRub.getText() +"." + txbNewValueKop.getText();
		return BigDecimal.valueOf(Double.parseDouble(newV));
	}
}
