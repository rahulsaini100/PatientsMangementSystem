package com.hibernate;
import javax.persistence.CascadeType;import javax.persistence.Entity;
import javax.persistence.GeneratedValue;import javax.persistence.Id;
import javax.persistence.JoinColumn;import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "PATIENTS")
public class Patients {
@Id
@GeneratedValue
private int patient_id;
private String patient_name;
private String patient_address;
private String disease_details;
private String payment_details;
private int age;

@ManyToOne(cascade = CascadeType.ALL)
private Doctor doctor;

public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}


public int getPatient_id() {
	return patient_id;
}
public void setPatient_id(int patient_id) {
	this.patient_id = patient_id;
}
public String getPatient_name() {
	return patient_name;
}
public void setPatient_name(String patient_name) {
	this.patient_name = patient_name;
}
public String getPatient_address() {
	return patient_address;
}
public void setPatient_address(String patient_address) {
	this.patient_address = patient_address;
}
public String getDisease_details() {
	return disease_details;
}
public void setDisease_details(String disease_details) {
	this.disease_details = disease_details;
}
public String getPayment_details() {
	return payment_details;
}
public void setPayment_details(String payment_details) {
	this.payment_details = payment_details;
}

public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}
}