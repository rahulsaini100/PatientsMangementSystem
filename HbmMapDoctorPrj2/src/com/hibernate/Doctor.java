package com.hibernate;
import java.util.HashSet;import java.util.Set;
import javax.persistence.CascadeType;import javax.persistence.Entity;
import javax.persistence.GeneratedValue;import javax.persistence.Id;
import javax.persistence.OneToMany;import javax.persistence.Table;
@Entity
@Table(name= "Doctor")
public class Doctor {
@Id
@GeneratedValue
private int doctor_id;
private String doctor_name;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
private Set<Patients> patients = new HashSet<Patients>(0);
public Set<Patients> getPatients() {return patients;}
public void setPatients(Set<Patients> patients) 
{this.patients = patients;}
public int getDoctor_id() {
	return doctor_id;
}
public void setDoctor_id(int doctor_id) {
	this.doctor_id = doctor_id;
}
public String getDoctor_name() {
	return doctor_name;
}
public void setDoctor_name(String doctor_name) {
	this.doctor_name = doctor_name;
}
}
