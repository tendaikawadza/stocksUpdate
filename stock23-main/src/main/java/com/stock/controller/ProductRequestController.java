package com.stock.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.Model.ProductRequest;
import com.stock.Service.ProductRequestService;

@RestController
@RequestMapping("/product")
public class ProductRequestController {
    @Autowired
    private ProductRequestService productrequestService;

    @PostMapping("/add")
    public ResponseEntity<ProductRequest> createProduct(@RequestBody ProductRequest productRequest){

        ProductRequest createProduct =  productrequestService.createProduct(productRequest);
        return new ResponseEntity<>(createProduct, HttpStatus.OK);
    }


    @GetMapping("/ping")
    public String ping(){
        return "test";
    }


    @PutMapping("/{productId}")
    public ResponseEntity<ProductRequest> updateProduct(@PathVariable Long productId, @RequestBody ProductRequest product) {
        ProductRequest updatedProduct = productrequestService.updateProduct( product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productrequestService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/browseNotifications/{userId}")
    public List<ProductRequest> getProductByReceiverId(@RequestBody ProductRequest productRequest) {
        return productrequestService.getProductByReceiverId(productRequest.getReceiverId());
    }


}




