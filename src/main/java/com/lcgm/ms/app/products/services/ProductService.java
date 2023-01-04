package com.lcgm.ms.app.products.services;

import java.util.Optional;

import com.lcgm.ms.app.products.models.entity.Product;

public interface ProductService {
	
	public Iterable<Product> findAll();
	
//	public Page<Product> findAll(Pageable pageable);
	
	public Optional<Product> findById(Long id);
	
	public Product save(Product entity);
	
	public void deleteById(Long id);

}
