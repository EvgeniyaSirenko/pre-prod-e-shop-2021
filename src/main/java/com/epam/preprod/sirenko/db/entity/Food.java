package com.epam.preprod.sirenko.db.entity;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Food entity.
 *
 * @author E.Sirenko
 *
 **/
public class Food extends Product {
	private int weight;
	
	public Food() {
	}
	
	public Food(String name, BigDecimal price, int foodWeight) {
		super(name, price);
		weight = foodWeight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Food{" +
				"amount=" + weight +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Food)) return false;
		if (!super.equals(o)) return false;
		Food food = (Food) o;
		return getWeight() == food.getWeight();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getWeight());
	}
}
