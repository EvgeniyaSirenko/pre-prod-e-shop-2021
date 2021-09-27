package com.epam.preprod.sirenko;

/**
 * String key wrapper, as HashCode uses string length
 *
 * @author E.Sirenko
 **/
public class StringLengthAsHashCode {
	private String key;
	
	@Override
	public int hashCode() {
		return key.length();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
}
