package webdriver.elements;

import org.openqa.selenium.By;

/**
 * Class, Describing element Checkbox
 */
public class CheckBox extends BaseElement {
	/**
	 * @param locator
	 * @param name
	 */
	public CheckBox(final By locator, final String name) {
		super(locator, name);
	}

	public CheckBox(String string, String name) {
		super(string, name);
	}

	public CheckBox(By locator) {
		super(locator);
	}

	protected String getElementType() {
		return getLoc("loc.checkbox");
	}

	public boolean isEnabled() {
		return this.getElement().isEnabled();
	}

	public void checkCheckBox() {
		waitForIsElementPresent();
		if (!(browser.getDriver()).findElement(locator).isSelected()) {
			mouseMoveToElement();
			clickByMouse();
		}
	}

	public void uncheckCheckBox() {
		if ((browser.getDriver()).findElement(locator).isSelected()) {
			mouseMoveToElement();
			clickByMouse();
		}
	}

}
