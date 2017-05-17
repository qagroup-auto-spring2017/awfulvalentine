package com.valentine.data;

public class ProductDataModel {

	private String title;

	private double unitPrice;

	public ProductDataModel(String title, double unitPrice) {
		this.title = title;
		this.unitPrice = unitPrice;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		long temp;
		temp = Double.doubleToLongBits(unitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDataModel other = (ProductDataModel) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (Double.doubleToLongBits(unitPrice) != Double.doubleToLongBits(other.unitPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product Details [title=" + title + ", unitPrice=" + unitPrice + "]";
	}
	
}
