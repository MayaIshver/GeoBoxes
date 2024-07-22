package swen221Ass1;

/**
 * Creates a Street with a given name, length and GeoBox. This is used to help create addresses, 
 * is added to cities when they expand and help checks that the Buildings GeoBox is correct. 
 * 
 * @param boundingBox
 * 				The GeoBox of where the street is.
 * @param name 
 * 				Name of the street 
 * @param length
 * 				Length of the street in meters and a whole number 
 * 

 * @author Maya Ishver
 */
record Street(GeoBox boundingBox, String name, int length) {
	/**
	 * Compact constructor for GeoPoint
	 * @param boundingBox
	 * 				The GeoBox of where the street is.
	 * @param name 
	 * 				Name of the street 
	 * @param length
	 * 				Length of the street in meters and a whole number 
	 * 
	 * @throws NullPointerException 
	 * 			If the name or boundingBox value is null 
	 * @throws IllegalArgumentException
	 * 			If length is negative 
	 */
	Street{
		if(boundingBox == null || name == null) {
			throw new NullPointerException();
		}
		
		if(length<0) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Returns the name of the Street.
	 * @return name 
	 * 			The name of the Street
	 */
	public String toString() {
		return name;
	}

}