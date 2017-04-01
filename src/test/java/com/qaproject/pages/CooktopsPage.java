package com.qaproject.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.CheckBox;
import webdriver.elements.TextBox;

import com.qaproject.pages.objects.CookTop;

public class CooktopsPage extends BaseForm {

	private By chbInStockLocator = By.xpath("//label[@for='onstock']");
	private CheckBox chbOnStock = new CheckBox(chbInStockLocator, "On Stock");

	private By chbManufacturerLocator = By.xpath("//*[@id='152900']");
	private CheckBox chbManufacturer = new CheckBox(chbManufacturerLocator,
			"Manufacturer");

	private By chbAllManufacturerLocator = By.xpath("//*[@id='toggleBrand']");
	private CheckBox chbAllManufacturer = new CheckBox(
			chbAllManufacturerLocator, "All Manufacturer");

	private By txbPriceFromLocator = By.xpath("//*[@id='7351759']");

	private TextBox txbPriceFrom = new TextBox(txbPriceFromLocator, "PriceFrom");

	private By cooktopsPriceLocator = By.xpath("//*[@class='prop_price']");

	private By btnKupiTutByLocator = By
			.xpath("//a[@class='name-resource'][contains(text(), 'КУПИ')]");
	private Button btnKupiTutBy = new Button(btnKupiTutByLocator, "Kupi.Tut.By");

	private By btnLowestFirstLocator = By.xpath("(//div[@class='sort']//a)[2]");
	private Button btnLowestFirst = new Button(btnLowestFirstLocator,
			"Sorted: LowestFirst");

	private By btnSendLocator = By
			.xpath("//*[@id='filters_form']//*[@class='send']/input");
	private Button btnSend = new Button(btnSendLocator, "Send Button");

	private By btnFirstCooktopItemLocator = By
			.xpath("(//a[@class='full-link'])[1]");
	private Button btnFirstCooktopItem = new Button(btnFirstCooktopItemLocator,
			"Cooktop Item");

	private String viewedSection;
	private By viewedSectionLocator = By.xpath("//*[@class='last']");

	public CooktopsPage() {
		super(By.xpath("//h1"), "Варочные панели");
		viewedSection = browser.getDriver().findElement(viewedSectionLocator)
				.getText();
	}

	public String getViewedSection() {
		return viewedSection;
	}

	public void openMainCatalogMenuPage() {
		btnKupiTutBy.clickByMouse();
	}

	public List<Double> getListOfCooktops() {
		List<Double> listCooktopDoublePrices = new ArrayList<Double>();
		List<WebElement> listCooktopPrices = new ArrayList<WebElement>();
		listCooktopPrices = browser.getDriver().findElements(
				cooktopsPriceLocator);

		for (WebElement сooktopPrice : listCooktopPrices) {

			String strPrice = сooktopPrice.getText();

			Pattern pricePattern = Pattern.compile("\\d+\\s?\\d+(,)\\d{2}");
			Matcher mPrice = pricePattern.matcher(strPrice.replaceAll(" ", ""));
			mPrice.find();
			strPrice = mPrice.group(0);

			String prc = strPrice.replace(",", ".");

			listCooktopDoublePrices.add(Double.parseDouble(prc));
			info(getLoc("CooktopPrice: " + prc));
		}
		return listCooktopDoublePrices;
	}

	public void sortListOfCooktopsLowestFirst() {
		btnLowestFirst.clickByMouse();
	}

	public void chooseCheapestCooktopItemAndGetDetails() {
		btnFirstCooktopItem.clickByMouse();
	}

	public List<Double> getSortedListOfCooktopsLowestFirst() {
		sortListOfCooktopsLowestFirst();
		return getListOfCooktops();
	}

	public void selectCookTopsByParameters(CookTop cookTop) {
		if (Integer.parseInt(cookTop.getInStock()) > 0)
			chbOnStock.checkCheckBox();
		else {
			chbOnStock.uncheckCheckBox();
		}

		txbPriceFrom.clickByMouse();
		txbPriceFrom.type(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		txbPriceFrom.type(cookTop.getPriceFrom());

		chbAllManufacturer.clickByMouse();

		chbManufacturer.clickByMouse();

		btnSend.clickByMouse();

	}

}
