package swen221Ass1;
/**
 * Creates a new GeoBox with two given, unchangeable GeoPoints.
 * The constructor then checks that the GeoBox's given points fit the requirements 
 * @param ne 
 * 			North East GeoPoint of the GeoBox (upper right hand corner)
 * @param sw 
 * 			South West GeoPoint of the GeoBox (lower left hand corner)

 * @author Maya Ishver 
 */
record GeoBox(GeoPoint ne, GeoPoint sw) {
	/**
	 * Compact Constructor for GeoBox 
	 * @param ne 
	 * 			North East GeoPoint of the GeoBox (upper right hand corner)
	 * @param sw 
	 * 			South West GeoPoint of the GeoBox (lower left hand corner)
	 * 
	 * @throws NullPointerException
	 * 			If either GeoPoint is null 
	 * @throws IllegalArgumentException
	 * 			If the points longitudes and latitudes don't meet the requirements. 
	 * 
	 */
	GeoBox{
		if(ne == null || sw == null) {
			throw new NullPointerException();
		}	
		/*Putting the checks used more than once into methods clean up my code and 
		allows for less code repetition, also makes it easier to changes the values in the future*/
		checkLat(ne);
		checkLat(sw);
		nePointCheck(ne.latitude(),sw.latitude());
		checkSpan(ne.latitude(),sw.latitude());
		
		//Check if it spans across the anti-meridian 
		if((ne.longitude()-sw.longitude())<-180) {
			checkSpan(ne.longitude() + 360, sw.longitude());
			nePointCheck(ne.longitude() + 360, sw.longitude());
		}
		else{
			checkSpan(ne.longitude(), sw.longitude());
			nePointCheck(ne.longitude(), sw.longitude());
		} 
		
			
	}
	
	/**
	 * Checks that the given points latitude is within the range (-80) to 80
	 * @param point
	 * 				GeoPoints who's latitude we want to check
	 * @throws IllegalArgumentException
	 * 				If the points latitude isn't in the specified range.
	 * 
	 */
	public void checkLat(GeoPoint point) {
		if(!(point.latitude() >= -80 && point.latitude() <= 80) ){
			throw new IllegalArgumentException();
		} 
	}
	
	/**
	 * Checks that the given values (the latitude or longitude of two points) does not span over 30 degrees
	 * @param l1
	 * 			longitude/latitude of point one, one of the points longitude/latitude 
	 * @param l2
	 * 			longitude/latitude of point two, one of the points longitude/latitude
	 * @throws IllegalArgumentException
	 * 			If the points longitudes/latitudes spans more than the maximum. 
	 * 
	 */
	public void checkSpan(double l1, double l2 ) {
		if((l1-l2)>30) {
			throw new IllegalArgumentException();
		}		 
	}
	
	/**
	 * Checks that the given values (the latitude or longitude) of the north east point is actually northeast 
	 * in relation to the other point's longitude/latitude 
	 * @param l1
	 * 			longitude/latitude of point one, one of the points longitude/latitude 
	 * @param l2
	 * 			longitude/latitude of point two, one of the points longitude/latitude
	 * @throws IllegalArgumentException
	 * 			If the point ones longitudes/latitudes don't meet the requirements. 
	 * 
	 */
	public void nePointCheck(double l1, double l2) {
		if(!(l1>=l2)){
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Return the GeoBoxes values in a formated string
	 * @return
	 * 		Returns a string, printing the GeoBox information 
	 */
	public String toString() {
	      return "GeoBox[ne="+ne.toString()+", sw="+sw.toString()+"]";
	}
	
	/**
	 * Calculating and returning the North West value based on the other two points
	 * @return GeoPoint 
	 * 					Returns a new GeoPoint, northWest 
	 */
	public GeoPoint nw() {
		return new GeoPoint(ne.latitude(), sw.longitude());
	}
	
	/**
	 * Calculating and returning the South East value based on the other two points
	 * @return GeoPoint 
	 * 					Returns a new GeoPoint, northWest 
	 */
	public GeoPoint se() {
		
		return new GeoPoint(sw.latitude(), ne.longitude());
	}
	
	
	/**
	 * Calculating and returning a GeoPoint with a center 
	 * @return GeoPoint 
	 * 					Returns a new GeoPoint, center 
	 */
	public GeoPoint center() {
		return ne.average(sw);
	}
		
}


