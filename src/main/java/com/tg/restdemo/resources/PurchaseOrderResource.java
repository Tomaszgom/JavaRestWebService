package com.tg.restdemo.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.tg.restdemo.model.PurchaseOrder;
import com.tg.restdemo.service.PurchaseOrderService;

/**
 * Purchase Orders root resource exposed at "purchase-orders" path
 */

@Path("/purchase-orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseOrderResource {
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as XML media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	PurchaseOrderService purchaseOrderService = new PurchaseOrderService();
	 	
    @GET	
    @Produces(MediaType.APPLICATION_XML)
	public List<PurchaseOrder> getPurchaseOrders() {
    	
		return purchaseOrderService.getAllPurchaseOrders();
		
	}
    
    @GET
	public List<PurchaseOrder> getPurchaseOrders(@BeanParam PurchaseOrderFilterBean filterBean) {
		
		if (filterBean.getYear() > 0) {
			return purchaseOrderService.getAllPurchaseOrdersForMonth(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return purchaseOrderService.getAllPurchaseOrdersPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return purchaseOrderService.getAllPurchaseOrders();
	}

	@POST
	public Response addPurchaseOrder(PurchaseOrder purchaseOrder, @Context UriInfo uriInfo) {
		
		PurchaseOrder newPurchaseOrder = purchaseOrderService.addPurchaseOrder(purchaseOrder);
		String newId = String.valueOf(newPurchaseOrder.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newPurchaseOrder)
				.build();
	}
	
	@PUT
	@Path("/{purchaseOrderId}")
	public PurchaseOrder updatePurchaseOrder(@PathParam("purchaseOrderId") long id, PurchaseOrder purchaseOrder) {
		// PathParam allows update id always to be picked up from the path (not from received json)
		purchaseOrder.setId(id);
		return purchaseOrderService.updatePurchaseOrder(purchaseOrder);
	}
	
	@DELETE
	@Path("/{purchaseOrderId}")
	public void deletePurchaseOrder(@PathParam("purchaseOrderId") long id) {
		purchaseOrderService.removePurchaseOrder(id);
	}
	
	
	@GET
	@Path("/{purchaseOrderId}")
	public PurchaseOrder getPurchaseOrder(@PathParam("purchaseOrderId") long id, @Context UriInfo uriInfo) {
		PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrder(id);
		purchaseOrder.addLink(getUriForSelf(uriInfo, purchaseOrder), "self");
		purchaseOrder.addLink(getUriForClient(uriInfo, purchaseOrder), "client");
		//purchaseOrder.addLink(getUriForComments(uriInfo, purchaseOrder), "purchaseorder");
		
		return purchaseOrder;		
	}


	private String getUriForClient(UriInfo uriInfo, PurchaseOrder purchaseOrder) {
		URI uri = uriInfo.getBaseUriBuilder()
       		 .path(ClientResource.class)
       		 .path(purchaseOrder.getProductName())
             .build();
        return uri.toString();
	}

	private String getUriForSelf(UriInfo uriInfo, PurchaseOrder purchaseOrder) {
		String uri = uriInfo.getBaseUriBuilder()
		 .path(PurchaseOrderResource.class)
		 .path(Long.toString(purchaseOrder.getId()))
		 .build()
		 .toString();
		return uri;
	}
	
	
	

}


