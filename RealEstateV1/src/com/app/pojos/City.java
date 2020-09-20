package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

	private Integer cityId;
	private String cityName;
	private int pincode;
	private List<Flats> flatList = new ArrayList<>();
	private List<House> houseList = new ArrayList<>();

	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(String cityName, int pincode) {
		super();
		this.cityName = cityName;
		this.pincode = pincode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "city_name")
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@OneToMany(mappedBy = "selectedCity", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Flats> getFlatList() {
		return flatList;
	}

	public void setFlatList(List<Flats> flatList) {
		this.flatList = flatList;
	}

	// convinience helper methods for flats
	private void addFlats(Flats f) {
		flatList.add(f);
		f.setSelectedCity(this);
	}

	private void removeFlat(Flats f) {
		flatList.remove(f);
		f.setSelectedCity(null);

	}
	
	
	@OneToMany(mappedBy = "selectedCity", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<House> getHouseList() {
		return houseList;
	}

	public void setHouseList(List<House> houseList) {
		this.houseList = houseList;
	}
	
	// convinience helper methods for house
	private void addHouse(House h) {
		houseList.add(h);
		h.setSelectedCity(this);
	}
	
	private void removeHouse(House h) {
		houseList.remove(h);
		h.setSelectedCity(null);

	}
	

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", pincode=" + pincode + ", flatList=" + flatList
				+ "]";
	}

}
