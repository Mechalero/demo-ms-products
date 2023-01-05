package com.lcgm.ms.app.products.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="product")
@Getter @Setter @NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int code;
	private String name;
	private String codeBar;
	private float price;
	private float tax;
	private String photo;
	private String description;
	private int stock;

}
