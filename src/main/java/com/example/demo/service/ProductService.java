package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRespository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<ProductRespository, Product> {

    // ProductService() {
    //     super(Product.class);
    // }

    // public ResponseEntity<List<Product>> getData() {
	// 	return new ResponseEntity<List<Product>>(this.repository.findAll(), HttpStatus.OK);
	// }

}
