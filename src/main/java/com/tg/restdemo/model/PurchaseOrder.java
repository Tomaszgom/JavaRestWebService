package com.tg.restdemo.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author Tomasz Gomoradzki
 * Purchase Order model object
 *
 */

@XmlRootElement
public class PurchaseOrder {
	
	private long id;
	private double orderValue;
	private String productName;
	private Date orderDate;

	
	public PurchaseOrder() {
		
	}
		
	public PurchaseOrder(double orderValue, String productName) {
		this.orderValue = orderValue;
		this.productName = productName;
		this.orderDate = new Date();
	}

	@Override
	public String toString() {
		return "PurchaseOrder [order_id=" + id + ", orderValue=" + orderValue
				+ ", productName=" + productName + ", orderDate=" + orderDate + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


}
