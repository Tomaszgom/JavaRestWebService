package com.tg.restdemo.model;

import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Tomasz Gomoradzki
 * Client model object
 *
 */

@XmlRootElement
public class Client {
	
	private double id;
	private String firstName;
	private String lastName;
	private String city;
	private Integer points;
	//private List<PurchaseOrder> purchaseOrders;

	public Client() {
		
	}
	

	public Client(double client_id, String firstName, String lastName, String city, Integer points) {
		this.id = client_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.points = points;

	}



	@Override
	public String toString() {
		return "Client [Client_id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", city="
				+ city + ", points=" + points + "]";
	}
	
	public double getId() {
		return id;
	}

	public void setId(double cl_id) {
		id = cl_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPoints() {
		if(points == null) {
			return 0;
		}else{
			return points;			
		}
	}

	public void setPoints(int points) {
		this.points = points;
	}



}