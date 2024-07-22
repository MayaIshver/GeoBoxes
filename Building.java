package swen221Ass1;

import java.util.Set;

interface Building{
	Set secondaryAddresses();
	Address primaryAddress();
	GeoBox boundingBox();
	static Building of(GeoBox b, Address a) {
		if(b == null || a == null) {
			throw new NullPointerException();
		}
		return new simpleBuilding(b,a);
	}
	static Building of(GeoBox b, Address a, Set<Address> adds) {
		if(b == null || a == null || adds == null) {
			throw new NullPointerException();
		}
		if(adds.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Set<Address> secondaryAddresses = Set.copyOf(adds);
		return new multiBuilding(b,a,secondaryAddresses);
	}
	
	
	
}

record simpleBuilding(GeoBox boundingBox, Address primaryAddress) implements Building {
	@Override
	public Set secondaryAddresses() {
		// TODO Auto-generated method stub
		return Set.of();
	}


}

record multiBuilding(GeoBox boundingBox, Address primaryAddress, Set<Address> secondaryAddresses) implements Building {
	
}