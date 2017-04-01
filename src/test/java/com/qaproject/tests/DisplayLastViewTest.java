package com.qaproject.tests;

import webdriver.BaseTest;

import com.qaproject.pages.BytovayaTekhnikaPage;
import com.qaproject.pages.CooktopsPage;
import com.qaproject.pages.MainCatalogMenuPage;
import com.qaproject.pages.TutByMainPage;
import com.qaproject.pages.VstraivaemayaBytovayaTekhnikaPage;

public class DisplayLastViewTest extends BaseTest {

	TutByMainPage tutByMainPage;

	@Override
	public void runTest() {

		logStep();
		tutByMainPage = new TutByMainPage();
		tutByMainPage.openTutByShopsPage();

		logStep();
		MainCatalogMenuPage mainCatalogMenuPage = new MainCatalogMenuPage();
		mainCatalogMenuPage.openBytovayaTekhnikaSection();

		logStep();
		BytovayaTekhnikaPage bytovayaTekhnikaPage = new BytovayaTekhnikaPage();
		bytovayaTekhnikaPage.openVstraivaemayaBytovayaTekhnikaPage();

		logStep();
		VstraivaemayaBytovayaTekhnikaPage vstraivaemayaBytovayaTekhnikaPage = new VstraivaemayaBytovayaTekhnikaPage();
		vstraivaemayaBytovayaTekhnikaPage.openCooktopsPage();

		logStep();
		CooktopsPage cooktopsPage = new CooktopsPage();
		cooktopsPage.openMainCatalogMenuPage();

		assertEquals(mainCatalogMenuPage.getLastViewedSectionInfo(),
				cooktopsPage.getViewedSection());

	}

}
