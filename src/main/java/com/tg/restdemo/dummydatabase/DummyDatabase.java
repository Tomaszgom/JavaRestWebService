package com.tg.restdemo.dummydatabase;

import java.util.HashMap;
import java.util.Map;

import com.tg.restdemo.model.Client;
import com.tg.restdemo.model.PurchaseOrder;

/**
 * DummyDatabase class mocks the functionality of data base
 * class is used for the simplicity of Web Service implementation, which aim is to present REST API implementation
 * DummyDatabase is not thread-safe and is to be replaced with database instance
 * example database connectivity is implemented in other demo projects
 */

public class DummyDatabase {

	private static Map<Long, PurchaseOrder> purchaseOrders = new HashMap<>();
	private static Map<String, Client> clients = new HashMap<>();

	
	public static Map<Long, PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}
	
	public static Map<String, Client> getClients() {
		return clients;
	}

	
	
	
}

