package com.epam.preprod.sirenko.command;

import com.epam.preprod.sirenko.entity.Product;

import java.io.Serializable;
import java.util.List;

public abstract class Command implements Serializable {
	public abstract List<Product> execute();
}
