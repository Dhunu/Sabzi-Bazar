package com.masai.service;

import com.masai.model.BillingDetails;

public interface BillingsService {

	public BillingDetails addBill(BillingDetails bill);
	
	public BillingDetails updateBill(BillingDetails bill);
	
	public BillingDetails viewBill();
}
