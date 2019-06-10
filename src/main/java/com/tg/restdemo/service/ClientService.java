package com.tg.restdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tg.restdemo.dummydatabase.DummyDatabase;
import com.tg.restdemo.model.Client;

/**
 * 
 * Client Service layer of REST API handling Client related method calls
 *
 */

public class ClientService {

private Map<String, Client> clients = DummyDatabase.getClients();
	
	public ClientService() {
		clients.put("Smith", new Client(1L, "John", "Smith", "London", 100));
		clients.put("Jones", new Client(1L, "Jane", "Jones", "New York", 200));
	}
	
	public List<Client> getAllClients() {
		return new ArrayList<Client>(clients.values()); 
	}
	
	public Client getClient(String clientName) {
		return clients.get(clientName);
	}
	
	public Client addClient(Client client) {
		client.setId(clients.size() + 1);
		clients.put(client.getLastName(), client);
		return client;
	}
	
	public Client updateClient(Client client) {
		if (client.getLastName().isEmpty()) {
			return null;
		}
		clients.put(client.getLastName(), client);
		return client;
	}
	
	public Client removeClient(String clientName) {
		return clients.remove(clientName);
	}
	
	
}

