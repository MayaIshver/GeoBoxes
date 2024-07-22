package swen221Ass1;


import java.util.HashSet;

import java.util.Set;

/**
 * City's grow everyday, objects of the city class can too. The city class takes a name 
 * and population in its constructor. Its other field is an empty set of streets. Both the 
 * population and the set of streets can be updates as the city grows.
 * 
 * @author Maya Ishver
 */

//Needs to be a class so we can modify the set of streets and population as the city grows
public class City {	
	/** The name of the city (can't be changed once set)*/
	final String name; 
	/** A empty set of streets for the city*/
	Set<Street> streetsSet = new HashSet<Street>();
	/** The population amount for the city*/
	int population; 
	
	/**
	 * City constructor, which takes a name and population and checks the values
	 * @param cityName
	 * 			Name of the city
	 * @param cityPopulation
	 * 			Number of people in city 
	 * @throws NullPointerException 
	 * 			If the name value is null 
	 * @throws IllegalArgumentException
	 * 			If population is negative 
	 */
	public City(String cityName, int cityPopulation) {
		if(cityName == null) {
			throw new NullPointerException();
		}
		name = cityName;
		
		//Can't have a negative population - not realistic
		if(!(cityPopulation>=0)) {
			throw new IllegalArgumentException();
		}
		population = cityPopulation;
	}
	
	/**
	 * Updating the population - setting the population
	 * @param popNum
	 * 			Number of population  
	 * @throws IllegalArgumentException 
	 * 			If population is negative 
	 */
	public void population(int popNum) {
		if(!(popNum>=0)) {
			throw new IllegalArgumentException();
		}
		population = popNum;	
	}
	
	/**
	 * Adding street to the set of streets
	 * @param street
	 * 			A street that is in the city
	 */
	public void addStreet(Street street) {
		streetsSet.add(street);
	}
	
	//Getters
	/**
	 * Get and return population of the city
	 * @return population 
	 * 				The city's population 
	 */
	public int population() {
		return population;
	}
	
	/**
	 * Get and return the streets of the city
	 * @return streetsSet
	 * 			The city's set of streets 
	 */
	public Set<Street> streets() {
		return streetsSet;
	}
	
	/**
	 * Get and return the name of the city
	 * @return name
	 * 			The city's name 
	 */	
	public String name() {
		return name;
	}
	
}