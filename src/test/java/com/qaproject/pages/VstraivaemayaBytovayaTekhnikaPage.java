package com.qaproject.pages;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;

public class VstraivaemayaBytovayaTekhnikaPage extends BaseForm {

	By btnVstraivaemyeRabochiePoverkhnostiLocator = By
			.xpath("//h3//a[contains(text(),'Варочные панели')]");
	Button btnVstraivaemyeRabochiePoverkhnosti = new Button(
			btnVstraivaemyeRabochiePoverkhnostiLocator,
			"Vstraivaemye Rabochie Poverkhnosti");

	public VstraivaemayaBytovayaTekhnikaPage() {
		super(By.xpath("//h1"), "Встраиваемая техника");
	}

	public void openCooktopsPage() {
		btnVstraivaemyeRabochiePoverkhnosti.clickByMouse();
	};

}
