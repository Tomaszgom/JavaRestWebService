package com.tg.restdemo.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tg.restdemo.model.PurchaseOrder;
import com.tg.restdemo.service.PurchaseOrderService;

/**
 * Root resource (exposed at "purchase-orders" path)
 */

@Path("/purchase-orders")
public class PurchaseOrderResource {
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	PurchaseOrderService purchaseOrderService = new PurchaseOrderService();
	 	
    @GET	
    @Produces(MediaType.APPLICATION_XML)
	public List<PurchaseOrder> getPurchaseOrders() {
    	
		return purchaseOrderService.getAllPurchaseOrders();
		
	}

}


