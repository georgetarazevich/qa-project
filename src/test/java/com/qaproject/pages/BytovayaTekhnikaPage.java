package com.qaproject.pages;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;

public class BytovayaTekhnikaPage extends BaseForm {

	By btnVstraivaemayaBytovayaTekhnikaLocator = By
			.xpath("//h3//a[contains(text(),'Встраиваемая техника')]");
	Button btnVstraivaemayaBytovayaTekhnika = new Button(btnVstraivaemayaBytovayaTekhnikaLocator, "Vstraivaemaya Bytovaya Tekhnika");

	public BytovayaTekhnikaPage() {
		super(By.xpath("//h1"), "Бытовая техника");
	}

	public void openVstraivaemayaBytovayaTekhnikaPage() {
		btnVstraivaemayaBytovayaTekhnika.clickByMouse();
	}

}
