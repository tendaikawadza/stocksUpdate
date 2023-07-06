package com.jsc.www.Product.controller;

import com.jsc.www.Product.Service.ProductService;
import com.jsc.www.Product.entity.Product;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController  {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(ProductController.class);

    // Assume ProductService class handles product inventory
    @Autowired
    private ProductService productService;

    // Endpoint to check product availability
//    @GetMapping("/products/{productId}/availability")
//    public String getProductAvailability(@PathVariable long productId) {
//        boolean inStock = productService.isProductInStock(productId);
//        if (inStock) {
//            return "Product is in stock";
//        } else {
//            return "Product is out of stock";
//        }
//    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        LOGGER.info("Product add: {}", productId);
        Product product = productService.getProductBasedOnId(productId);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product createProduct =  productService.createProduct(product);
        return new ResponseEntity<>(createProduct, HttpStatus.OK);
    }


    @GetMapping("/code/{productCode}/total" )
    public ResponseEntity<Integer> getProductTotalByProductCode(@PathVariable String productCode) {
        int totalQuantity = productService.getProductTotalByProductCode(productCode);
        if (totalQuantity > 0) {
            return ResponseEntity.ok(totalQuantity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct( product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}






