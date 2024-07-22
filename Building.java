package swen221Ass1;

import java.util.Set;
/**
 * The Building interface allows for multiple building to be creates both with a set of 
 * secondary addresses and without. Its static constructors checks that the buildings 
 * parameters are not null and the address matches where the building GeoBox is, 
 * before creating the building of the given type based on the parameters. 
 * 
 * @author Maya Ishver
 */
interface Building{
	/** Gets the set of secondary addresses for the building when implemented by the class/record
	 * @return 
	 * 		The set of secondary addresses
	 */
	Set<Address> secondaryAddresses();
	/** Gets the primary address for the building when implemented by the class/record*
	 * @return
	 * 		The primary address
	 */
	Address primaryAddress();
	/** Gets the GeoBox for the building when implemented by the class/record
	 * @return
	 * 		The GeoBox
	 */
	GeoBox boundingBox();
	
	/**
	 * Creates a building with a single address. 
	 * @param box
	 * 			The GeoBox of the building 
	 * @param address
	 * 			The address of the building 
	 * 
	 * @throws NullPointerException 
	 * 			If the box or address parameter is null 
	 * @throws IllegalArgumentException 
	 * 			If the building GeoBox and the street GeoBox 
	 * 			(by way of the address) don't overlap i.e they are
	 * 			not in the same place
	 * @return simpleBuilding 
	 * 			returns a new simple building object 
	 */
	
	static Building of(GeoBox box, Address address) {
		
		if(box == null || address == null) {
			throw new NullPointerException();
		}
		
		if(!overlapCheck(box,address)) {
			throw new IllegalArgumentException();
		}
		return new simpleBuilding(box,address);
	}
	
	/**
	 * Creates a building with a single address. 
	 * @param box
	 * 			The GeoBox of the building 
	 * @param address
	 * 			The address of the building 
	 * @param addresses
	 * 			A set of the secondary addresses for the building
	 * 
	 * @throws NullPointerException 
	 * 			If the box or address parameter is null 
	 * @throws IllegalArgumentException 
	 * 			If the addresses set is empty or if the building GeoBox
	 * 			and the street GeoBoxes (by way of the addresses) don't 
	 * 			overlap i.e they are not in the same place
	 * @return multiBuilding 
	 * 			returns a new multiBuilding object 
	 */
	static Building of(GeoBox box, Address address, Set<Address> addresses) {
		if(box == null || address == null) {
			throw new NullPointerException();
		}
		if(addresses.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		if(!overlapCheck(box,address)) {
			throw new IllegalArgumentException();
		}
		
		
		for(Address add: addresses) {
			
			if(!overlapCheck(box,add)) {
				throw new IllegalArgumentException();
			}
		}
		
		Set<Address> secondaryAddresses = Set.copyOf(addresses);
		return new multiBuilding(box,address,secondaryAddresses);
	}
	
	/**
	 * Checks that the building is actually at the address entered 
	 * (Checks that the buildings GeoBox overlaps with the addresses GeoBox.)
	 * @param box
	 * 			GeoBox of the building
	 * @param address
	 * 			The Address of the building (could be a primary or secondary address.)
	 * @return boolean 
	 * 			Returns true if they overlap, and false if they don't		
	 */
	
	static boolean overlapCheck(GeoBox box, Address address) {
		//I used this webpage/site to help me: https://www.baeldung.com/java-check-if-two-rectangles-overlap
		
		GeoPoint buildboxbot = box.sw();
		GeoPoint buildboxtop = box.ne();
		
		GeoPoint addboxbot = address.street().boundingBox().sw();
		GeoPoint addboxtop = address.street().boundingBox().ne();
		
		if((buildboxtop.latitude()<addboxbot.latitude()) || (buildboxbot.latitude()>addboxtop.latitude())) {
			//If one box is higher than the other, they don't overlap
			return false;
		}
		if((buildboxtop.longitude()<addboxbot.longitude()) || (buildboxbot.longitude()>addboxtop.longitude())) {
			//If one box is doesn't overlap horizontally at all
			return false;
		}
		return true;
	}
	
}

/**
 * Creates a simple Building. (A building with one primary address and no secondary ones.)
 * @param boundingBox
 * 					The GeoBox of the building 
 * @param primaryAddress 
 * 					The address of the building
 */
record simpleBuilding(GeoBox boundingBox, Address primaryAddress) implements Building {
	
	//Only has a primary address
	@Override
	public Set<Address> secondaryAddresses() {
		return Set.of();
	}

}

/**
 * Creates a Building with one primary address and a set of secondary ones.
 * @param boundingBox
 * 					The GeoBox of the building 
 * @param primaryAddress 
 * 					The address of the building
 * @param secondaryAddresses
 * 					A set of all the other addresses the building may also be on
 */
record multiBuilding(GeoBox boundingBox, Address primaryAddress, Set<Address> secondaryAddresses) implements Building{
	
}








