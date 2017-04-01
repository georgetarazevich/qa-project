package com.qaproject.pages;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;

public class MainCatalogMenuPage extends BaseForm {

	By btnLastViewedSectionLocator = By
			.xpath("(//*[@id='box-popular_categories']//a[@class='in']//span)[3]");
	Button btnLastViewedSection = new Button(btnLastViewedSectionLocator, "Last Viewed Section");
	
	By btnBytovayaTekhnikaLocator = By
			.xpath("//*[@data-ga-event-action='https://kupi.tut.by/bytovaya-tekhnika/']");
	Button btnBytovayaTekhnika = new Button(btnBytovayaTekhnikaLocator, "Bytovaya Tekhnika");

	public MainCatalogMenuPage() {
		super(By.xpath("//*[@class='name-resource']"), "kupi.tut.by");
	}

	public void openBytovayaTekhnikaSection() {
		btnBytovayaTekhnika.clickByMouse();
	}

	public String getLastViewedSectionInfo() {
		return btnLastViewedSection.getText();
	}
}
