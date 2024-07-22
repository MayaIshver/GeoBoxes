package swen221Ass1;
record GeoPoint(double latitude, double longitude) {
	GeoPoint{
		//includes 90 and -90 as acceptable
		//if(!(latitude >= -90.0 ||  90.0 <= latitude) || !(longitude >= -180 || longitude < 180)) {
		//	throw new IllegalArgumentException();
		//} //if fails will throw illegal argument expection
		
		//includes 180 as acceptable but not -180
		System.out.println("long "+longitude);
		System.out.println(!(longitude >= -180 && longitude < 180));
		if(!(longitude >= -180 && longitude < 180) ){
			throw new IllegalArgumentException();
		} 
		System.out.println("lat "+latitude);
		System.out.println(!(latitude >= -90 && latitude <= 90));
		
		if(!(latitude >= -90 && latitude <= 90) ){
			throw new IllegalArgumentException();
		} 
		
	}
	public String toString(int precision) {
		//System.out.print(precision);
		String print = String.format("[latitude: %."+precision+"f, longitude: %."+precision+"f]", latitude, longitude);

		System.out.println(print);
		return String.format("[latitude: %."+precision+"f, longitude: %."+precision+"f]", latitude, longitude);
	}
	public String toString() {
		String print =String.format("[latitude: %.8f, longitude: %.8f]", latitude, longitude);
		
		System.out.println(print);
		return String.format("[latitude: %.8f, longitude: %.8f]", latitude, longitude);
	
	}
	public GeoPoint average(GeoPoint p) {
		//point one is this point 
		//point 2 is p point 
		//avg longitute - wrong
		double avglong = (this.longitude + p.longitude)/2;
		//avg latitude 
		double avglat = (this.latitude + p.latitude)/2;
		return new GeoPoint(avglat, avglong);
	}
	
}


