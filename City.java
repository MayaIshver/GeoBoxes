package swen221Ass1;


import java.util.HashSet;
import java.util.Set;

public class City {	
	final String name; 
	Set<Street> streetsSet = new HashSet<Street>();
	int population; 
	public City(String n, int pop) {
		if(n == null) {
			throw new NullPointerException();
		}
		name = n;
		if(!(pop>=0)) {
			throw new IllegalArgumentException();
		}
		population = pop;
	}
	public void population(int i) {
		if(!(i>=0)) {
			throw new IllegalArgumentException();
		}
		population = i;
		
	}
	public int population() {
		return population;
	}
	
	public Set<Street> streets() {
		return streetsSet;
	}
	
	public void addStreet(Street street) {
		streetsSet.add(street);
	}
	public String name() {
		return name;
	}
	
}