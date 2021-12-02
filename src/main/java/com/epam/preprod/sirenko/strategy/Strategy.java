package com.epam.preprod.sirenko.strategy;

import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;

import java.math.BigDecimal;

public interface Strategy {
	PetGroup getPetGroup();
	Season getSeason();
	Size getSize();
	String getStringName();
	String getStringBrandName();
	int getInt();
	BigDecimal getBigDecimal();
}
