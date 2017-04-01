package com.qaproject.tests;

import com.qaproject.pages.BytovayaTekhnikaPage;
import com.qaproject.pages.CooktopItemDetailsPage;
import com.qaproject.pages.CooktopsPage;
import com.qaproject.pages.MainCatalogMenuPage;
import com.qaproject.pages.TutByMainPage;
import com.qaproject.pages.VstraivaemayaBytovayaTekhnikaPage;

import webdriver.BaseTest;

public class AddingItemToShoppingListTest extends BaseTest {

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
		cooktopsPage.sortListOfCooktopsLowestFirst();
		cooktopsPage.chooseCheapestCooktopItemAndGetDetails();
		
		logStep();
		CooktopItemDetailsPage cooktopItemDetailsPage = new CooktopItemDetailsPage();
		cooktopItemDetailsPage.addItemToShoppingList();
		
		String nameItem = cooktopItemDetailsPage.getItemName();
		cooktopItemDetailsPage.openShoppingList();
		cooktopItemDetailsPage.assertItemInShoppingListPresent(nameItem);
	}

}
