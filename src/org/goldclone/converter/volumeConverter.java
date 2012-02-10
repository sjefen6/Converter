package org.goldclone.converter;

public class volumeConverter {

	private static volumeConverter instance = null;

	protected volumeConverter() {
		// Exists only to defeat instantiation.
	}

	public static volumeConverter getInstance() {
		if (instance == null) {
			instance = new volumeConverter();
		}
		return instance;
	}

//    <item>Cubicmillimeter</item>
//    <item>Cubiccentimeter</item>
//    <item>Cubicdecimeter</item>
//    <item>Cubickilometer</item>
//    <item>Cubicinches</item>
//    <item>Cubicfeet</item>
//    <item>Cubicyards</item>
//    <item>Milliliters</item>
//    <item>Centiliters</item>
//    <item>Deciliters</item>
//    <item>Liters</item>

	public double convert(double input, int from, int to) {
		double cmMeter;

		if (from == 0) {// Cubicmillimeter
			cmMeter = input;
		} else if (from == 1) { // Cubiccentimeter
			cmMeter = input * 1000;
		} else if (from == 2) {// Cubicdecimeter
			cmMeter = input * Math.pow(10, 6);
		} else if (from == 3) { // Cubickilometer
			cmMeter = input * Math.pow(10, 18);
		} else if (from == 4) { // Cubicinches
			cmMeter = input * 16387;
		} else if (from == 5) { // Cubicfeet
			cmMeter = input * 2.832 * Math.pow(10, 7);
		} else if (from == 6) { // Cubicyards
			cmMeter = input * 7.646 * Math.pow(10, 8);
		} else if (from == 7) { // Milliliters
			cmMeter = input * 1000;
		} else if (from == 8) { // Centiliters
			cmMeter = input * 10000;
		} else if (from == 9) { // Deciliters
			cmMeter = input * 100000;
		} else { // Liters
			cmMeter = input * Math.pow(10, 6);
		}

		
		if (to == 0) {// Cubicmillimeter
			return cmMeter;
		} else if (to == 1) { // Cubiccentimeter
			return cmMeter / 1000;
		} else if (to == 2) {// Cubicdecimeter
			return cmMeter / Math.pow(10, 6);
		} else if (to == 3) { // Cubickilometer
			return cmMeter / Math.pow(10, 18);
		} else if (to == 4) { // Cubicinches
			return cmMeter / 16387;
		} else if (to == 5) { // Cubicfeet
			return cmMeter / (2.832 * Math.pow(10, 7));
		} else if (to == 6) { // Cubicyards
			return cmMeter / (7.646 * Math.pow(10, 8));
		} else if (to == 7) { // Milliliters
			return cmMeter / 1000;
		} else if (to == 8) { // Centiliters
			return cmMeter / 10000;
		} else if (to == 9) { // Deciliters
			return cmMeter / 100000;
		} else { // Liters
			return cmMeter / Math.pow(10, 6);
		}
	}
}
