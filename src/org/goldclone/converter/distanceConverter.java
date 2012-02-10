package org.goldclone.converter;

public class distanceConverter {

	private static distanceConverter instance = null;

	protected distanceConverter() {
		// Exists only to defeat instantiation.
	}

	public static distanceConverter getInstance() {
		if (instance == null) {
			instance = new distanceConverter();
		}
		return instance;
	}

//    <item>Angstrom</item>
//    <item>Micron</item>
//    <item>Millimeter</item>
//    <item>Centimeter</item>
//    <item>Decimeter</item>
//    <item>Meter</item>
//    <item>Kilometer</item>
//    <item>Inches</item>
//    <item>Feet</item>

	public double convert(double input, int from, int to) {
		double meter;

		if (from == 0) {// Angstrom
			meter = input * Math.pow(10, -10);
		} else if (from == 1) { // Micron
			meter = input * Math.pow(10, -6);
		} else if (from == 2) {// Millimeter
			meter = input * 0.001;
		} else if (from == 3) { // Centimeter
			meter = input * 0.01;
		} else if (from == 4) { // Decimeter
			meter = input * 0.1;
		} else if (from == 5) { // Meter
			meter = input;
		} else if (from == 6) { // Kilometer
			meter = input * 1000;
		} else if (from == 7) { // Inches
			meter = input * 0.0254;
		} else { // Feet
			meter = input * 0.3048;
		}

		
		if (to == 0) {// Angstrom
			return meter / Math.pow(10, -10);
		} else if (to == 1) { // Micron
			return meter / Math.pow(10, -6);
		} else if (to == 2) {// Millimeter
			return meter / 0.001;
		} else if (to == 3) { // Centimeter
			return meter / 0.01;
		} else if (to == 4) { // Decimeter
			return meter / 0.1;
		} else if (to == 5) { // Meter
			return meter;
		} else if (to == 6) { // Kilometer
			return meter / 1000;
		} else if (to == 7) { // Inches
			return meter / 0.0254;
		} else { // Feet
			return meter / 0.3048;
		}
	}
}
