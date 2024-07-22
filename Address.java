package swen221Ass1;
import java.util.Scanner;
/**
 * Creates an Address based on the street, city and number. It is mostly used for Buildings 
 * so that we can see if the building GeoBox is actually on the street it stays its on. 
 * 
 * @param street
 * 				The Street name and GeoBox of the address 
 * @param city
 * 				The city name of the Address 
 * @param number 
 * 				The number of the building/address, must have one or more numbers, optionally
 * 				followed by a single letter
 * @author Maya Ishver
 */
record Address(Street street, City city, String number) {
	/**
	 * Compact constructor for GeoPoint

	 * @throws NullPointerException
	 * 			If the any of the parameters value is null 
	 * @throws IllegalArgumentException 
	 * 			If the number doesn't match the pattern ([0-9]+[a-z]?)
	 */
	Address{
		if((street == null) || (city == null) || (number == null)) {
			throw new NullPointerException();
		}
		
		Scanner scan = new Scanner(number); 
		//Scanner so I can check if the number matches the pattern
		if (!scan.hasNext("[0-9]+[a-z]?")) {
			scan.close();
			throw new IllegalArgumentException();
		}
		scan.close();
		
		
	}
	/**
	 * Returns the address in a string format.
	 * Format: number, street name, city name 
	 */
	public String toString() {
		return number+" "+street.toString()+" "+city.name;
	}
	
}