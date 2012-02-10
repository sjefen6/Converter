package org.goldclone.converter;

public class massConverter {

	private static massConverter instance = null;

	protected massConverter() {
		// Exists only to defeat instantiation.
	}

	public static massConverter getInstance() {
		if (instance == null) {
			instance = new massConverter();
		}
		return instance;
	}

//    <item>Mikrogram</item>
//    <item>Milligram</item>
//    <item>Centigram</item>
//    <item>Decigram</item>
//    <item>Gram</item>
//    <item>Decagram</item>
//    <item>Kilogram</item>
//    <item>Ounces</item>
//    <item>Pounds</item>

	public double convert(double input, int from, int to) {
		double gram;

		if (from == 0) {// Mikrogram
			gram = input * Math.pow(10, -6);
		} else if (from == 1) { // Milligram
			gram = input * 0.001;
		} else if (from == 2) {// Centigram
			gram = input * 0.01;
		} else if (from == 3) { // Decigram
			gram = input * 0.1;
		} else if (from == 4) { // Gram
			gram = input;
		} else if (from == 5) { // Decagram
			gram = input * 10;
		} else if (from == 6) { // Kilogram
			gram = input * 1000;
		} else if (from == 7) { // Ounces
			gram = input * 28.3495231;
		} else { // Pounds
			gram = input * 453.59237;
		}

		
		if (to == 0) {// Mikrogram
			return gram / Math.pow(10, -6);
		} else if (to == 1) { // Milligram
			return gram / 0.001;
		} else if (to == 2) {// Centigram
			return gram / 0.01;
		} else if (to == 3) { // Decigram
			return gram / 0.1;
		} else if (to == 4) { // Gram
			return gram;
		} else if (to == 5) { // Decagram
			return gram / 10;
		} else if (to == 6) { // Kilogram
			return gram / 1000;
		} else if (to == 7) { // Ounces
			return gram / 28.3495231;
		} else { // Pounds
			return gram / 453.59237;
		}
	}
}
