package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import com.mysql.cj.protocol.a.NativeConstants.StringLengthDataType;

@Entity
@Table(name = "flats")
public class Flats {

	private Integer flatId;
	private String apartmentName, flatDescription, petsAllowed, status, ownerName;
	private City selectedCity;
	private double floorSpace, price;
	private int numberOfBalconies, numberOfBedrooms, numberOfBathrooms;
	private User associatedUser;
	private Date startDate, endDate;
	private Address address;
	private Estate estateType = Estate.valueOf("FLAT");

	public Flats() {
		System.out.println("in ctor of flats");
	}


	
	
	public Flats(String apartmentName, String flatDescription, String petsAllowed, String status, String ownerName,
			double floorSpace, double price, int numberOfBalconies, int numberOfBedrooms, int numberOfBathrooms,
			Date startDate, Date endDate) {
		super();
		this.apartmentName = apartmentName;
		this.flatDescription = flatDescription;
		this.petsAllowed = petsAllowed;
		this.status = status;
		this.ownerName = ownerName;
		this.floorSpace = floorSpace;
		this.price = price;
		this.numberOfBalconies = numberOfBalconies;
		this.numberOfBedrooms = numberOfBedrooms;
		this.numberOfBathrooms = numberOfBathrooms;
		this.startDate = startDate;
		this.endDate = endDate;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flat_id")
	public Integer getFlatId() {
		return flatId;
	}

	public void setFlatId(Integer flatId) {
		this.flatId = flatId;
	}

	@Column(name = "apartment_name")
	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	@Column(name = "flat_description")
	public String getFlatDescription() {
		return flatDescription;
	}

	public void setFlatDescription(String flatDescription) {
		this.flatDescription = flatDescription;
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

	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(name = "addressLine1", column = @Column(name = "flat_number")),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "street")) })
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getAssociatedUser() {
		return associatedUser;
	}

	public void setAssociatedUser(User associatedUser) {
		this.associatedUser = associatedUser;
	}


	

	@Column(name = "estate_type")
	public Estate getEstateType() {
		return estateType;
	}




	public void setEstateType(Estate estateType) {
		this.estateType = estateType;
	}




	@Override
	public String toString() {
		return "Flats [flatId=" + flatId + ", apartmentName=" + apartmentName + ", flatDescription=" + flatDescription
				+ ", petsAllowed=" + petsAllowed + ", status=" + status + ", ownerName=" + ownerName + ", selectedCity="
				+ selectedCity + ", floorSpace=" + floorSpace + ", price=" + price + ", numberOfBalconies="
				+ numberOfBalconies + ", numberOfBedrooms=" + numberOfBedrooms + ", numberOfBathrooms="
				+ numberOfBathrooms + ", associatedUser=" + associatedUser + ", startDate=" + startDate + ", endDate="
				+ endDate + ", address=" + address + "]";
	}

}
