package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "houses")
public class House {

	private Integer houseId;
	private String houseName,houseDescription,petsAllowed,status,ownerName,garden;
	private City selectedCity;
	private double floorSpace,price;
	private int numberOfBalconies,numberOfBedrooms,numberOfBathrooms,numberOfFloors;
	private User associatedUser;
	private Address address;
	private Estate estateType = Estate.valueOf("HOUSE");

	public House() {
		System.out.println("in ctor of house");
	}


	

	public House(String houseName, String houseDescription, String petsAllowed, String status, String ownerName,
			String garden, double floorSpace, double price, int numberOfBalconies, int numberOfBedrooms,
			int numberOfBathrooms, int numberOfFloors) {
		super();
		this.houseName = houseName;
		this.houseDescription = houseDescription;
		this.petsAllowed = petsAllowed;
		this.status = status;
		this.ownerName = ownerName;
		this.garden = garden;
		this.floorSpace = floorSpace;
		this.price = price;
		this.numberOfBalconies = numberOfBalconies;
		this.numberOfBedrooms = numberOfBedrooms;
		this.numberOfBathrooms = numberOfBathrooms;
		this.numberOfFloors = numberOfFloors;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "house_id")
	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	@Column(name = "house_name")
	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	@Column(name = "house_description")
	public String getHouseDescription() {
		return houseDescription;
	}

	public void setHouseDescription(String houseDescription) {
		this.houseDescription = houseDescription;
	}

	@Column(name = "pets_allowed")
	public String getPetsAllowed() {
		return petsAllowed;
	}

	public void setPetsAllowed(String petsAllowed) {
		this.petsAllowed = petsAllowed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "owner_name")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	

	public String getGarden() {
		return garden;
	}

	public void setGarden(String garden) {
		this.garden = garden;
	}

	@ManyToOne
	@JoinColumn(name = "city_id")
	public City getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(City selectedCity) {
		this.selectedCity = selectedCity;
	}

	@Column(name = "floor_space")
	public double getFloorSpace() {
		return floorSpace;
	}

	public void setFloorSpace(double floorSpace) {
		this.floorSpace = floorSpace;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "number_of_balconies")
	public int getNumberOfBalconies() {
		return numberOfBalconies;
	}

	public void setNumberOfBalconies(int numberOfBalconies) {
		this.numberOfBalconies = numberOfBalconies;
	}

	@Column(name = "number_of_bedrooms")
	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	@Column(name = "number_of_bathrooms")
	public int getNumberOfBathrooms() {
		return numberOfBathrooms;
	}

	public void setNumberOfBathrooms(int numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}

	@Column(name = "number_of_floors")
	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	
	
	
	@Column(name = "estate_type")
	public Estate getEstateType() {
		return estateType;
	}




	public void setEstateType(Estate estateType) {
		this.estateType = estateType;
	}




	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "street")) })
	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getAssociatedUser() {
		return associatedUser;
	}

	public void setAssociatedUser(User associatedUser) {
		this.associatedUser = associatedUser;
	}




	@Override
	public String toString() {
		return "House [houseId=" + houseId + ", houseName=" + houseName + ", houseDescription=" + houseDescription
				+ ", petsAllowed=" + petsAllowed + ", status=" + status + ", ownerName=" + ownerName + ", garden="
				+ garden + ", selectedCity=" + selectedCity + ", floorSpace=" + floorSpace + ", price=" + price
				+ ", numberOfBalconies=" + numberOfBalconies + ", numberOfBedrooms=" + numberOfBedrooms
				+ ", numberOfBathrooms=" + numberOfBathrooms + ", numberOfFloors=" + numberOfFloors
				+ ", associatedUser=" + associatedUser + ", address=" + address + "]";
	}

	
	
	
}
