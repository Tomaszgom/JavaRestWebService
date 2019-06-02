package com.tg.restdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.tg.restdemo.model.PurchaseOrder;

public class PurchaseOrderService {

	public List<PurchaseOrder> getPurchaseOrdersAll(){
		PurchaseOrder porder1 = new PurchaseOrder(100, "Prodict 11");
		PurchaseOrder porder2 = new PurchaseOrder(200, "Prodict 12");
		PurchaseOrder porder3 = new PurchaseOrder(200, "Prodict 13");
		PurchaseOrder porder4 = new PurchaseOrder(200, "Prodict 14");
		
		
		List<PurchaseOrder> pordersList = new ArrayList<>();
		pordersList.add(porder1);
		pordersList.add(porder2); 
		pordersList.add(porder3); 
		pordersList.add(porder4); 
		 
		return pordersList;
				
	}
	
}
