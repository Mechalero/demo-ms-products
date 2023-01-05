package com.lcgm.ms.app.products;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcgm.ms.app.products.models.entity.Product;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestControllerIntegrationTest {
	

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void givenProduct_whenGetProduct_thenReturnJsonArray() throws Exception {
		this.mockMvc.perform(get("/3")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.*").isNotEmpty());
	}

	@Test
	public void givenProducts_whenGetProducts_thenReturnJsonArray() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.*").isArray());
	}

	@Test
	public void givenProduct_whenCreateProduct_thenReturnIsCreate() throws Exception {
		Product product = createProduct();
		this.mockMvc.perform(post("/")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(product)))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.*").isNotEmpty());
	}

	@Test
	public void givenProduct_whenDeleteProduct_thenReturnIsDelete() throws Exception {
		this.mockMvc.perform(delete("/4")).andDo(print())
				.andExpect(status().isNoContent())
				.andExpect(jsonPath("$.*").isNotEmpty());
	}

	private Product createProduct() {
		Product product = new Product();
		product.setCode(123);
		product.setName("test unit");
		product.setPrice(10000f);
		product.setDescription("example test unit");
		return product;
	}

}
