package com.qaproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

public class CooktopItemDetailsPage extends BaseForm {

	public CooktopItemDetailsPage() {
		super(By.xpath("//h1"), "Cooktop Details Page");
	}

	private String lblAddedItemInShoppingListLocator = "(//*[@class='in']//*[contains(text(),'%s')])[1]";

	private By lblItemNameLocator = By.xpath("//h1");
	private Label lblItemName = new Label(lblItemNameLocator);

	private By btnAddToShoppingListLocator = By
			.xpath("//*[@class='state state2']");
	private Button btnAddToShoppingList = new Button(
			btnAddToShoppingListLocator, "Add to Shopping List");

	private By btnShoppingListLocator = By
			.xpath("//*[@id='bottom_bar_header']/li[3]");
	private Button btnShoppingList = new Button(btnShoppingListLocator,
			"Shopping List");

	public void addItemToShoppingList() {

		WebElement element = browser.getDriver().findElement(
				btnAddToShoppingListLocator);
		((JavascriptExecutor) browser.getDriver()).executeScript(
				"arguments[0].scrollIntoView(true);", element);

		btnAddToShoppingList.clickByMouse();
	}

	public void openShoppingList() {
		btnShoppingList.clickByMouse();
	}

	public void assertItemInShoppingListPresent(String nameItem) {
		new Label(By.xpath(String.format(lblAddedItemInShoppingListLocator,
				nameItem)), nameItem).waitForIsElementPresent();
	}

	public String getItemName() {
		return lblItemName.getText().trim();
	}
}
