package com.epam.preprod.sirenko.entity;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Clothing entity.
 *
 * @author E.Sirenko
 *
 **/
public class Clothing extends Product {
	private int sizeId;
	private int seasonId;
	
	public Clothing() {
	}
	
	public Clothing(String name, BigDecimal price, int clothingSize, int clothingSeason) {
		super(name, price);
		sizeId = clothingSize;
		seasonId = clothingSeason;
	}
	
	public int getSizeId() {
		return sizeId;
	}
	
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	
	public int getSeasonId() {
		return seasonId;
	}
	
	public void setSeasonId(int season) {
		this.seasonId = season;
	}
	
	@Override
	public String toString() {
		return "Clothing{" +
				"sizeId='" + sizeId + '\'' +
				", seasonId='" + seasonId + '\'' +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Clothing)) return false;
		if (!super.equals(o)) return false;
		Clothing clothing = (Clothing) o;
		return getSizeId() == clothing.getSizeId() && getSeasonId() == clothing.getSeasonId();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getSizeId(), getSeasonId());
	}
}
