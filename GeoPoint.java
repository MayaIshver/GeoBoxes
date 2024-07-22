package swen221Ass1;
record GeoPoint(double latitude, double longitude) {
	GeoPoint{
		assert(-90<latitude<90); //if fails will throw illegal argument expection
		assert(-180<longitude<180);
	}
	public String toString(int precision) {
		String.format("[latitude: %.df ,longitude %.df", precision,latitude, precision,lonitude);
	}
	public String toString() {
		String.format("[latitude: %.8f ,longitude %.8f", latitude, lonitude);
	
	}
	public GeoPoint average(GeoPoint p) {
		//point one is this point 
		//point 2 is p point 
		//avg longitute - wrong
		int avglong = (this.longitude + p.longitude)/2
		//avg latitude 
		int avglat = (this.latitude + p.latitude)/2
	}
	
}


