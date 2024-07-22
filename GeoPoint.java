package swen221Ass1;

/**
 * Creates a GeoPoint, which is a point in the world identified by it's latitude (height from the 
 * South pole (-90) to the North pole (90)) and it's longitude (like its x-value, from -180(also known as 180 or 0) 
 * to 180(also known as -180 or 0) because of its wrap around nature). 
 * 
 * @param latitude 
 * 			A double value with the height of the point essentially 
 * @param longitude 
 * 			A double value with the horizontal location of the point 

 * @author Maya Ishver 
 */
record GeoPoint(double latitude, double longitude) {
	/**
	 * Compact constructor for GeoPoint
	 * @param latitude 
	 * 			A double value with the height of the point essentially 
	 * @param longitude 
	 * 			A double value with the horizontal location of the point 
	 * @throws IllegalArgumentException 
	 * 			If latitude or longitude is outside of its range. 
	 * 
	 */
	GeoPoint{
		
		if(!(longitude >= -180 && longitude < 180) ){
			throw new IllegalArgumentException();
		} 
		
		if(!(latitude >= -90 && latitude <= 90) ){
			throw new IllegalArgumentException();
		} 
	}
	
	/**
	 * /**
	 * Returns the latitude and longitude formated into a string, with the precision 
	 * giving the amount of decimal places to be used.
	 * @param precision
	 * 			The amount of decimal places to format the longitude and latitude values 
	 * @return String 
	 * 			The latitude and longitude values to precision decimal places.
	 */
	public String toString(int precision) {
		return String.format("[latitude: %."+precision+"f, longitude: %."+precision+"f]", latitude, longitude);
	}
	
	/**
	 * Returns the latitude and longitude formated into a string, with 8 decimal places. 
	 * 
	 * @return String 
	 * 			The latitude and longitude values to 8 decimal places.
	 */
	public String toString() {
		return String.format("[latitude: %.8f, longitude: %.8f]", latitude, longitude);
	
	}
	
	/**
	 * Averages this GeoPoint's and the specified GeoPoint's longitudes and latitudes to return 
	 * a new GeoPoint, between them. 
	 * @param p
	 * 			The other GeoPoint to average with
	 * @return GeoPoint
	 * 			A GeoPoint between the specified ones. 
	 */
	public GeoPoint average(GeoPoint p) {		
		double avgLong = avgLongs(p.longitude());

		double avgLat = (this.latitude + p.latitude)/2;
		return new GeoPoint(avgLat, avgLong);
	}
	
	/**
	 * Checking if the longitude average is in the other direction, closer to the -180 rather than 0.
	 * @param long2
	 * 			Longitude of the given GeoPoint to average against.
	 * @return avgLong
	 * 			The average longitude
	 */
	public double avgLongs(double long2){
		double avgLong = (this.longitude()+ long2)/2;
		/*Checking if the average is closer to 180 than 0
		 *I used this site to help me: 
		 *https://stackoverflow.com/questions/1878907/how-can-i-find-the-smallest-difference-between-two-angles-around-a-point
		 */
		if(((long2-this.longitude())>180)) {
			avgLong -=180;
		}
		else if(((long2-this.longitude())<-180)) {
			avgLong +=180;
		}
		else if((long2-this.longitude())==0) {
			if(long2 !=0 || this.longitude() != 0) {
				avgLong = 180;
			}
		}
		return avgLong;
	}
}


