package com.nt.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customer")
@Data


public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID")
	private Integer cid;
	@Column(name="CUSTOMER_NAME")
	private String cname;
	@Column(name="CUSTOMER_ADDRESS")
	private String caddrs;
	@Column(name="CUST_BILL_AMT")
	private double billamt;

	
	
}
