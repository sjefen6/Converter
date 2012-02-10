package org.goldclone.converter;

public class timeConverter {

	private static timeConverter instance = null;

	protected timeConverter() {
		// Exists only to defeat instantiation.
	}

	public static timeConverter getInstance() {
		if (instance == null) {
			instance = new timeConverter();
		}
		return instance;
	}

//    <item>Milliseconds</item>
//    <item>Seconds</item>
//    <item>Minutes</item>
//    <item>Hours</item>
//    <item>Days</item>
//    <item>Weeks</item>
//    <item>Months</item>
//    <item>Years</item>
//    <item>Decades</item>
//    <item>Centuries</item>

	public double convert(double input, int from, int to) {
		double Seconds;

		if (from == 0) {// Milliseconds
			Seconds = input * 0.001;
		} else if (from == 1) { // Seconds
			Seconds = input;
		} else if (from == 2) {// Minutes
			Seconds = input * 60;
		} else if (from == 3) { // Hours
			Seconds = input * 3600;
		} else if (from == 4) { // Days
			Seconds = input * 86400;
		} else if (from == 5) { // Weeks
			Seconds = input * 604800;
		} else if (from == 6) { // Months
			Seconds = input * 2.628 * Math.pow(10, 6);
		} else if (from == 7) { // Years
			Seconds = input * 3.154 * Math.pow(10, 7);
		} else if (from == 8) { // Decades
			Seconds = input * 3.154 * Math.pow(10, 8);
		} else { // Centuries
			Seconds = input * 3.154 * Math.pow(10, 9);
		}

		
		if (to == 0) {// Milliseconds
			return Seconds / 0.001;
		} else if (to == 1) { // Seconds
			return Seconds;
		} else if (to == 2) {// Minutes
			return Seconds / 60;
		} else if (to == 3) { // Hours
			return Seconds / 3600;
		} else if (to == 4) { // Days
			return Seconds / 86400;
		} else if (to == 5) { // Weeks
			return Seconds / 604800;
		} else if (to == 6) { // Months
			return Seconds / ( 2.628 * Math.pow(10, 6) );
		} else if (to == 7) { // Years
			return Seconds / ( 3.154 * Math.pow(10, 7) );
		} else if (to == 8) { // Decades
			return Seconds / ( 3.154 * Math.pow(10, 8) );
		} else { // Centuries
			return Seconds / ( 3.154 * Math.pow(10, 9) );
		}
	}
}
