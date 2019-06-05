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
	
	private int client_id;
	private String firstName;
	private String lastName;
	private String city;
	private Integer points;
	private Date lastLoginDate;
	//private List<PurchaseOrder> purchaseOrders;

	public Client() {
		
	}
	
	@Override
	public String toString() {
		return "Client [Client_id=" + client_id + ", firstName=" + firstName + ", lastName=" + lastName + ", city="
				+ city + ", points=" + points + ", lastLoginDate=" + lastLoginDate + "]";
	}
	
	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int cl_id) {
		client_id = cl_id;
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

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


}