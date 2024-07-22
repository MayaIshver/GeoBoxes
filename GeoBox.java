package swen221Ass1;
record GeoBox(GeoPoint northEast, GeoPoint southWest) {	
	GeoBox{
		
		if(!(northEast.latitude() >= -80 && northEast.latitude() <= 80) ){
			throw new IllegalArgumentException();
		} 
		
		if(!(southWest.latitude() >= -80 && southWest.latitude() <= 80) ){
			throw new IllegalArgumentException();
		} 
		if(!(northEast.latitude()>=southWest.latitude())){
			throw new IllegalArgumentException();
		} 
		if(!(northEast.longitude()>=southWest.longitude())){
			throw new IllegalArgumentException();
		} 
		if(!(northEast.latitude()-southWest.latitude()<=30) ){
			throw new IllegalArgumentException();
		} 
		if(!(northEast.longitude()-southWest.longitude()<=30) ){
			throw new IllegalArgumentException();
		} 
		if(northEast == null || southWest == null) {
			throw new NullPointerException();
		}
		
	}
	public String toString() {
	      return "GeoBox[ne="+northEast.toString()+", sw="+southWest.toString()+"]";
	}
	
	public GeoPoint nw() {
		return new GeoPoint(northEast.latitude(), southWest.longitude());
	}
	public GeoPoint se() {
		
		return new GeoPoint(southWest.latitude(), northEast.longitude());
	}
	public GeoPoint ne() {
		return northEast;
	}
	public GeoPoint sw() {
		return southWest;
	}
	
	public GeoPoint center() {
		double clong = (northEast.longitude()+southWest.longitude())/2;
		double clat = (northEast.latitude()+southWest.latitude())/2;
		return new GeoPoint(clat, clong);
	}
		
}


