package com.qaproject.pages.objects;

public class CookTop {
	private String priceFrom, manufacturer, onStock;

	public CookTop() {
	};

	public CookTop withPriceFrom(String _priceFrom) {
		this.priceFrom = _priceFrom;
		return this;
	}

	public CookTop withManufacturer(String _manufacturer) {
		this.manufacturer = _manufacturer;
		return this;
	}

	public CookTop withinStock(String _inStock) {
		this.onStock = _inStock;
		return this;
	}

	public String getPriceFrom() {
		return priceFrom;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getInStock() {
		return onStock;
	}

}
