package com.lcgm.ms.app.products.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lcgm.ms.app.products.models.entity.Product;
import com.lcgm.ms.app.products.models.repository.ProductRepository;

@Service
public class ProductServivceImpl implements ProductService{

	@Autowired
	protected ProductRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Product> findAll() {
		return repository.findAll();
	}

//	@Override
//	@Transactional(readOnly = true)
//	public Page<Product> findAll(Pageable pageable) {
//		return repository.findAll();
//	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Product save(Product entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}
