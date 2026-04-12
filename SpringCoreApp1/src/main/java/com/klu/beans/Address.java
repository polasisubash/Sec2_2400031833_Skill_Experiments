package com.klu.beans;

public class Address {
private String street;
private String city;
private String state;
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
//addition method to address details
public void displayAddressDetails() {
	System.out.println("Street Name: "  +street);
	System.out.println("City Name: " +city);
	System.out.println("State Name: " +state);

}
}
