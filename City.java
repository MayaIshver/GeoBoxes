package swen221Ass1;


import java.util.HashSet;
import java.util.Set;

record City2(String name, int population, Set<Street> streetsSet) {
	City2{
		if(!(population>=0)) {
			throw new IllegalArgumentException();
		}
	}
	
	public void population(int i) {
		if(!(i>=0)) {
			throw new IllegalArgumentException();
		}
		population = i;
		
	}
	
	
	public void addStreet(Street street) {
		streetsSet.add(street);
	}
	
	
}