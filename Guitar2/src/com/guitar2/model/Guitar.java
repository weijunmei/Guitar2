package com.guitar2.model;
public class Guitar {
	private double price;
	private GuitarSpec guitarSpec;
	private String serialNumber;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public GuitarSpec getGuitarSpec() {
		return guitarSpec;
	}
	public void setGuitarSpec(GuitarSpec guitarSpec) {
		this.guitarSpec = guitarSpec;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}	
}
