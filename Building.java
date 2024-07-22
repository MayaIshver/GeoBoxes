package swen221Ass1;

import java.util.Set;

interface Building2{
	Set secondaryAddresses();
	Address primaryAddress();
	GeoBox boundingBox();
	static Building2 of(GeoBox b, Address a) {
		return new simpleBuilding(b,a); 
	}
	static Building2 of(GeoBox b, Address a, Set<Address> addressSet);
	
	
	
}

record simpleBuilding(GeoBox boundingBox, Address primaryAddress) implements Building2 {

	@Override
	public Set secondaryAddresses() {
		// TODO Auto-generated method stub
		return Set.of();
	}

	
	

	
	
	
}

record multiBuilding(GeoBox boundingBox, Address primaryAddress, Set<Address> secondaryAddresses) implements Building2 {
	
}