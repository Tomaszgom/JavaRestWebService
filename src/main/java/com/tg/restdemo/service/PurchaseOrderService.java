package com.tg.restdemo.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.tg.restdemo.dummydatabase.DummyDatabase;
import com.tg.restdemo.exceptionhandling.DataNotFoundException;
import com.tg.restdemo.model.PurchaseOrder;

public class PurchaseOrderService {

	private Map<Long, PurchaseOrder> purchaseOrders = DummyDatabase.getPurchaseOrders();
	
	public PurchaseOrderService() {
		purchaseOrders.put(1L, new PurchaseOrder(100, "Product 11"));
		purchaseOrders.put(2L, new PurchaseOrder(200, "Product 12"));
		purchaseOrders.put(3L, new PurchaseOrder(300, "Product 13"));
	}
	
	public List<PurchaseOrder> getAllPurchaseOrders(){
		
		List<PurchaseOrder> pordersList = new ArrayList<PurchaseOrder>(purchaseOrders.values());		 
		return pordersList;
				
	}
		
	public List<PurchaseOrder> getAllPurchaseOrdersForMonth(int month) {
		List<PurchaseOrder> purchaseOrdersForMonth = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (PurchaseOrder purchaseOrder : purchaseOrders.values()) {
			cal.setTime(purchaseOrder.getOrderDate());
			if (cal.get(Calendar.MONTH) == month) {
				purchaseOrdersForMonth.add(purchaseOrder);
			}
		}
		return purchaseOrdersForMonth;
	}
	
	public List<PurchaseOrder> getAllPurchaseOrdersPaginated(int start, int size) {
		ArrayList<PurchaseOrder> list = new ArrayList<PurchaseOrder>(purchaseOrders.values());
		if (start + size > list.size()) return new ArrayList<PurchaseOrder>();
		return list.subList(start, start + size); 
	}
	
	
	public PurchaseOrder getPurchaseOrder(long id) {
		PurchaseOrder purchaseOrder = purchaseOrders.get(id);
		if (purchaseOrders == null) {
			throw new DataNotFoundException("Message with id " + id + " not found");
		}
		return purchaseOrder;
	}
	
	public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder) {
		purchaseOrder.setId(purchaseOrders.size() + 1);
		purchaseOrders.put(purchaseOrder.getId(), purchaseOrder);
		return purchaseOrder;
	}
	
	public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		if (purchaseOrder.getId() <= 0) {
			return null;
		}
		purchaseOrders.put(purchaseOrder.getId(), purchaseOrder);
		return purchaseOrder;
	}
	
	public PurchaseOrder removePurchaseOrder(long id) {
		return purchaseOrders.remove(id);
	}
	
}
