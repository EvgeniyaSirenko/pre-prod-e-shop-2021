package com.epam.preprod.sirenko;

/**
 * String key wrapper, as HashCode uses sum of first four elements of string
 *
 * @author E.Sirenko
 **/
public class SumOfFirstFourElementsOfStringAsHashCode {
		private String key;
		
		@Override
		public int hashCode() {
			int result = 0;
			char[] keyArray = key.toCharArray();
			for (int i = 0; i < keyArray.length; i++) {
				if (i < 4) {
					result += keyArray[i];
				}
			}
			return result;
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
