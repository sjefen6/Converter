package org.goldclone.converter;

public class temperatureConverter {
	
	//The standard temperature is Kelvin

	private static temperatureConverter instance = null;
	private double kelvin;

	protected temperatureConverter() {
		// Exists only to defeat instantiation.
	}

	public static temperatureConverter getInstance() {
		if (instance == null) {
			instance = new temperatureConverter();
		}
		return instance;
	}
	
	public void setKelvin(double kelvin)
	{
		this.kelvin = kelvin;
	}
	
	public void setCelsius(double celsius)
	{
		this.kelvin = celsius + 273.15;
	}
	
	public void setFahrenheit(double fahrenheit)
	{
		this.kelvin = (fahrenheit + 459.67) * (5/9);
	}
	
	public double getKelvin()
	{
		return this.kelvin;
	}
	
	public double getCelsius()
	{
		return this.kelvin - 273.15;
	}
	
	public double getFahrenheit()
	{
		return (this.kelvin * (9/5) - 459.67);
	}
}
