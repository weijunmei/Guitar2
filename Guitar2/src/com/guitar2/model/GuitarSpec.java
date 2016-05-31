package com.guitar2.model;
public class GuitarSpec {
	private builder builder;
	private String model;
	private type type;
	private wood topWood;
	private wood backWood;
	public builder getBuilder() {
		return builder;
	}
	public void setBuilder(builder builder) {
		this.builder = builder;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public type getType() {
		return type;
	}
	public void setType(type type) {
		this.type = type;
	}
	public wood getTopWood() {
		return topWood;
	}
	public void setTopWood(wood topWood) {
		this.topWood = topWood;
	}
	public wood getBackWood() {
		return backWood;
	}
	public void setBackWood(wood backWood) {
		this.backWood = backWood;
	}
	public Boolean matches(GuitarSpec guitarSpec){
		if(guitarSpec.getType()!=null && !guitarSpec.getType().equals(type)){
			return false;
		}
		if(guitarSpec.getBuilder()!=null && !guitarSpec.getBuilder().equals(builder)){
			return false;
		}
		if(guitarSpec.getModel()!=null && !guitarSpec.getModel().equals(model)){
			return false;
		}
		if(guitarSpec.getTopWood()!=null && !guitarSpec.getTopWood().equals(topWood)){
			return false;
		}
		if(guitarSpec.getBackWood()!=null && !guitarSpec.getBackWood().equals(backWood)){
			return false;
		}
		return true;	
	}
}
