package com.lcgm.ms.app.products;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lcgm.ms.app.products.controllers.ProductController;

@SpringBootTest
class DemoMsProductsApplicationTests {

	@Autowired
	private ProductController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
