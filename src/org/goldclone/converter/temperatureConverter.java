package org.goldclone.converter;

public class temperatureConverter {

	private static temperatureConverter instance = null;

	protected temperatureConverter() {
		// Exists only to defeat instantiation.
	}

	public static temperatureConverter getInstance() {
		if (instance == null) {
			instance = new temperatureConverter();
		}
		return instance;
	}

	public double convert(double input, int from, int to) {
		double kelvin;

		if (from == 0) {
			kelvin = input + 273.15;
		} else if (from == 1) {
			kelvin = (double) ((input + 460) * (double) (5.0 / 9.0));
		} else {
			kelvin = input;
		}

		if (to == 0) {
			return (kelvin - 273.15);
		} else if (to == 1) {
			return (kelvin * (double) (9.0 / 5.0) - 460);
		} else {
			return kelvin;
		}
	}
}
