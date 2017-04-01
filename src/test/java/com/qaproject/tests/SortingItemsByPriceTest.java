package com.qaproject.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import webdriver.BaseTest;

import com.qaproject.pages.BytovayaTekhnikaPage;
import com.qaproject.pages.CooktopsPage;
import com.qaproject.pages.MainCatalogMenuPage;
import com.qaproject.pages.TutByMainPage;
import com.qaproject.pages.VstraivaemayaBytovayaTekhnikaPage;
import com.qaproject.pages.objects.CookTop;

public class SortingItemsByPriceTest extends BaseTest {
	CookTop cookTop;

	@Parameters({ "priceFrom", "manufacturer", "onStock" })
	@BeforeTest
	public void setUp(String priceFrom, String manufacturer, String onStock) {

		cookTop = new CookTop().withPriceFrom(priceFrom)
				.withManufacturer(manufacturer).withinStock(onStock);

		logStep();
		info(getLoc("CookTop created"));
	}

	@Override
	public void runTest() {

		logStep();
		TutByMainPage tutByMainPage = new TutByMainPage();
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
		cooktopsPage.selectCookTopsByParameters(cookTop);

		List<Double> cooktopList = cooktopsPage.getListOfCooktops();
		Collections.sort(cooktopList);

		Assert.assertEquals(cooktopsPage.getSortedListOfCooktopsLowestFirst(),
				cooktopList);
	}

}
