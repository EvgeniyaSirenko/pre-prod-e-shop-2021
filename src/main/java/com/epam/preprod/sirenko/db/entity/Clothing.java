package com.epam.preprod.sirenko.db.entity;

import com.epam.preprod.sirenko.db.Season;
import com.epam.preprod.sirenko.db.Size;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Clothing entity.
 *
 * @author E.Sirenko
 *
 **/
public class Clothing extends Product {
	private Size size;
	private Season season;
	
	public Clothing() {
	}
	
	public Clothing(String name, BigDecimal price, Size clothingSize, Season clothingSeason) {
		super(name, price);
		size = clothingSize;
		season = clothingSeason;
	}
	
	public Size getSize() {
		return size;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Season getSeason() {
		return season;
	}
	
	public void setSeason(Season season) {
		this.season = season;
	}
	
	@Override
	public String toString() {
		return "Clothing{" +
				"size=" + size +
				", season=" + season +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Clothing)) return false;
		if (!super.equals(o)) return false;
		Clothing clothing = (Clothing) o;
		return getSize() == clothing.getSize() && getSeason() == clothing.getSeason();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getSize(), getSeason());
	}
}
