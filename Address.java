package swen221Ass1;
import java.util.Scanner;
import java.util.regex.*;
record Address(Street street, City city, String number) {
	Address{
		Scanner s = new Scanner(number);
		if (!s.hasNext("[0-9]+[a-z]?")) {
			throw new IllegalArgumentException();
		}
		System.out.println("s "+ (street == null));
		System.out.println("c "+ (city == null));
		System.out.println("n "+ (number == null));
		System.out.println("all "+ ((street == null) || (city == null) || (number == null)));
		
		if((street == null) || (city == null) || (number == null)) {
			System.out.println("not valid");
			throw new NullPointerException();
		}
	}
	public String toString() {
		return number+" "+street.toString()+" "+city.name;
	}
	
}