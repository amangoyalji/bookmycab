package com.nis.model;

public class AgencyBidModel {
private int transactionid;
private String currentdate;
private String currenttime;
private int agencyid;
private int bookingid;
private int bidamount;
public int getTransactionid() {
	return transactionid;
}
public String getCurrentdate() {
	return currentdate;
}
public String getCurrenttime() {
	return currenttime;
}
public int getAgencyid() {
	return agencyid;
}
public int getBookingid() {
	return bookingid;
}
public int getBidamount() {
	return bidamount;
}
public void setTransactionid(int transactionid) {
	this.transactionid = transactionid;
}
public void setCurrentdate(String currentdate) {
	this.currentdate = currentdate;
}
public void setCurrenttime(String currenttime) {
	this.currenttime = currenttime;
}
public void setAgencyid(int agencyid) {
	this.agencyid = agencyid;
}
public void setBookingid(int bookingid) {
	this.bookingid = bookingid;
}
public void setBidamount(int bidamount) {
	this.bidamount = bidamount;
}

 
}
