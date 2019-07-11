package com.tg.restdemo.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tg.restdemo.model.Client;
import com.tg.restdemo.service.ClientService;

/**
 * 
 * Client Resource Class (Controller) handling Client requests
 *
 */

	@Path("/clients")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public class ClientResource {

		private ClientService clientService = new ClientService();	
		
		@GET
		public List<Client> getClients() {
			return clientService.getAllClients();
		}
		
		@POST
		public Client addClient(Client client) {
			return clientService.addClient(client);
		}
		
		@GET
		@Path("/{clientName}")
		public Client getClient(@PathParam("clientName") String clientName) {
			return clientService.getClient(clientName);
		}
		
		@PUT
		@Path("/{clientName}")
		public Client updateClient(@PathParam("clientName") String clientName, Client client) {
			client.setLastName(clientName);
			return clientService.updateClient(client);
		}
		
		@DELETE
		@Path("/{clientName}")
		public void deleteClient(@PathParam("clientName") String clientName) {
			clientService.removeClient(clientName);
		}
		
		
		
	}
