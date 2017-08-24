package com.santhoshproject.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class supplier 
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
int id;
@Column
String name;
@Column
String address;
@Column
long phonenumber;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Long getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(Long phonenumber) {
	this.phonenumber = phonenumber;
}
}
