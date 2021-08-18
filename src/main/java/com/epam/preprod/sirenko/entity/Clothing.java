package com.epam.preprod.sirenko.entity;

import java.util.Objects;

/**
 * Clothing entity.
 *
 * @author E.Sirenko
 **/
public class Clothing extends Products {
	private String size;
	private String season;
	
	public Clothing() {
	}
	
	public Clothing(String size, String season) {
		this.size = size;
		this.season = season;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getSeason() {
		return season;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	
	@Override
	public String toString() {
		return "Clothing{" +
				"size='" + size + '\'' +
				", season='" + season + '\'' +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Clothing)) return false;
		if (!super.equals(o)) return false;
		Clothing clothing = (Clothing) o;
		return getSize().equals(clothing.getSize()) && getSeason().equals(clothing.getSeason());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getSize(), getSeason());
	}
}
