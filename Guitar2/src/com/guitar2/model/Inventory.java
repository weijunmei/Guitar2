package com.guitar2.model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Inventory {
	private List guitars;
	public List getGuitars() {
		return guitars;
	}
	public void setGuitars(List guitars) {
		this.guitars = guitars;
	}
	public void addGuitar(Guitar guitar) {
		if (guitar.getPrice() > 0)
			if (guitar.getGuitarSpec() != null)
				System.out.println("add:" + guitar.getGuitarSpec().getType());
		guitars.add(guitar);
	}
	public List FindGuitars(Guitar guitar) {
		List matchingGuitars = new ArrayList();
		for (Iterator i = guitars.iterator(); i.hasNext();) {
			Guitar exGuitar = (Guitar) i.next();
			if (exGuitar.getGuitarSpec().matches(guitar.getGuitarSpec())) {
				if (exGuitar.getPrice() != guitar.getPrice() || guitar.getPrice() == 0) {
					matchingGuitars.add(exGuitar);
				}
			}
		}
		return matchingGuitars;
	}
}
