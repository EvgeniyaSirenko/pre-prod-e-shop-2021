package com.epam.preprod.sirenko;

import java.math.BigDecimal;

public interface Strategy {
	Enum getEnum(); //TODO
	String getString();
	int getInt();
	BigDecimal getBigDecimal();
}
