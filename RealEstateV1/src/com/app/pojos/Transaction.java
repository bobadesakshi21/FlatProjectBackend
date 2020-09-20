package com.app.pojos;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "transaction")
public class Transaction {

	private Integer txId;
	private int flatId,houseId;
	private User ownerId,buyerId; 
	private double paymentAmount;
	private Date startDate,endDate,billingDate;
	private String estateType;

	public Transaction() {
		System.out.println("in ctor of transaction");
	}

	public Transaction(double paymentAmount, Date startDate, Date endDate, Date billingDate, String estateType) {
		super();
		this.paymentAmount = paymentAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.billingDate = billingDate;
		this.estateType = estateType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tx_id")
	public Integer getTxId() {
		return txId;
	}

	public void setTxId(Integer txId) {
		this.txId = txId;
	}

	
	@Column(name = "flat_id")
	public int getFlatId() {
		return flatId;
	}

	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}

	@Column(name = "house_id")
	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	@ManyToOne
	@JoinColumn(name = "owner_id")
	public User getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(User ownerId) {
		this.ownerId = ownerId;
	}

	@ManyToOne
	@JoinColumn(name = "buyer_id")
	public User getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(User buyerId) {
		this.buyerId = buyerId;
	}

	@Column(name = "payment_amount")
	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "billing_date") 
	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	@Column(name = "estate_name")
	public String getEstateType() {
		return estateType;
	}

	public void setEstateType(String estateType) {
		this.estateType = estateType;
	}

	
	
	

}

	
	
	
	
	


