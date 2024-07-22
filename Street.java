package swen221Ass1;
record Street(GeoBox boundingBox, String name, int length) {
	Street{
		if(boundingBox == null || name == null) {
			throw new NullPointerException();
		}
	}
	
	public String toString() {
		return name;
	}

}