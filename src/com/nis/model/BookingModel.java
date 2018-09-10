package com.nis.model;

public class BookingModel {
private int bookingid;
private String clientemail;
private String mobileno;
private String vehicleid;
private String currentdate;
private String bookingfrom;
private String bookingto;
private String source;
private String destination;
private String status;
public int getBookingid() {
	return bookingid;
}
public String getClientemail() {
	return clientemail;
}
public String getMobileno() {
	return mobileno;
}
public String getVehicleid() {
	return vehicleid;
}
public String getCurrentdate() {
	return currentdate;
}
public String getBookingfrom() {
	return bookingfrom;
}
public String getBookingto() {
	return bookingto;
}
public String getSource() {
	return source;
}
public String getDestination() {
	return destination;
}
public String getStatus() {
	return status;
}
public void setBookingid(int bookingid) {
	this.bookingid = bookingid;
}
public void setClientemail(String clientemail) {
	this.clientemail = clientemail;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
public void setVehicleid(String vehicleid) {
	this.vehicleid = vehicleid;
}
public void setCurrentdate(String currentdate) {
	this.currentdate = currentdate;
}
public void setBookingfrom(String bookingfrom) {
	this.bookingfrom = bookingfrom;
}
public void setBookingto(String bookingto) {
	this.bookingto = bookingto;
}
public void setSource(String source) {
	this.source = source;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public void setStatus(String status) {
	this.status = status;
}


}
