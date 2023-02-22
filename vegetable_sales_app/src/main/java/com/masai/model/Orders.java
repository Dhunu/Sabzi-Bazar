package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer orderNo;
	
	@OneToMany
	private List<VegetableDTO> vegetableList=new ArrayList<>();
	
	private Integer totalAmount;
	private String status;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy= "order")
	private BillingDetails billingDetail;

}
