package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	private Integer id;
	private String name, email, password;
	private Role userRole;
	private String mobile;
	private List<Flats> flatList = new ArrayList<>();
	private List<House> houseList = new ArrayList<>();
	private List<Transaction> ownerTxList = new ArrayList<>();
	private List<Transaction> buyerTxList = new ArrayList<>();

	public User() {
		System.out.println("in def ctor of user");
	}

	public User(String name, String email, String password, Role userRole, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.mobile = mobile;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role")
	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@OneToMany(mappedBy = "associatedUser", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Flats> getFlatList() {
		return flatList;
	}

	public void setFlatList(List<Flats> flatList) {
		this.flatList = flatList;
	}

	// CONVINIENCE METHODS FOR FLAT
	public void addFlat(Flats f) {
		flatList.add(f);
		f.setAssociatedUser(this);
	}

	public void removeFlat(Flats f) {
		flatList.remove(f);
		f.setAssociatedUser(null);
	}

	@OneToMany(mappedBy = "associatedUser", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<House> getHouseList() {
		return houseList;
	}

	public void setHouseList(List<House> houseList) {
		this.houseList = houseList;
	}

	// convinience helper methods for house
	public void addHouse(House h) {
		houseList.add(h);
		h.setAssociatedUser(this);
	}

	public void removeHouse(House h) {
		houseList.remove(h);
		h.setAssociatedUser(null);

	}

	@OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Transaction> getOwnerTxList() {
		return ownerTxList;
	}

	public void setOwnerTxList(List<Transaction> ownerTxList) {
		this.ownerTxList = ownerTxList;
	}
	
	private void addOwnerTx(Transaction tx) {
		ownerTxList.add(tx);
		
	}

	@OneToMany(mappedBy = "buyerId", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Transaction> getBuyerTxList() {
		return buyerTxList;
	}

	public void setBuyerTxList(List<Transaction> buyerTxList) {
		this.buyerTxList = buyerTxList;
	}
	
	//convinience methods
	public void addBuyerTx(Transaction tx) {
		buyerTxList.add(tx);
		tx.setBuyerId(this);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", userRole="
				+ userRole + ", mobile=" + mobile + ", flatList=" + flatList + ", houseList=" + houseList + "]";
	}

}
