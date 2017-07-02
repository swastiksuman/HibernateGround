package com.hibernate.onetomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userID;

	@Column(name = "USER_NAME")
	private String userName;
	
	@OneToMany
	@JoinTable(joinColumns=@JoinColumn(name="USER_ID"),
				inverseJoinColumns=@JoinColumn(name="VEHICLE"))
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
