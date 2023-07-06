package com.stock.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.Model.ProductRequest;
import com.stock.Repository.ProductRequestRepository;

@Service
public class ProductRequestService {
    @Autowired

    ProductRequestRepository productRepository;
    /* to create user */
    public ProductRequest createProduct(ProductRequest productRequest) {
        ProductRequest createdProduct = (ProductRequest) productRepository.save(productRequest);
        return createdProduct;
    }


    /* to get all the  Products */
    public List<ProductRequest> getAllProductss(){

        List  <ProductRequest> findAllProducts   =productRepository.findAll();
        return findAllProducts;

    }

    public ProductRequest getUserById(Long userId) {


        Optional<ProductRequest> optionalUser = productRepository.findById(userId);

        boolean isPresent = optionalUser.isPresent();

        if(isPresent) {

            ProductRequest product =optionalUser.get();
            return product;
        }

        return null;

    }

    /* delete user based on Id */
    public void deleteProduct(Long  productId) {
        productRepository.deleteById(productId);

    }


    /* updating the user */
    public ProductRequest updateProduct(ProductRequest product) {

        ProductRequest updatedProduct = (ProductRequest) productRepository.save(product);

        return updatedProduct;
    }

    /* notification module for receiver ID*/
    public List<ProductRequest> getProductByReceiverId(Long productRequest) {
        return productRepository.findByReceiverId(productRequest);
    }

}
