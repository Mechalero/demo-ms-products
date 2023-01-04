package com.lcgm.ms.app.products.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.lcgm.ms.app.products.models.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
