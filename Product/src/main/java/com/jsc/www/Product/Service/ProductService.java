package com.jsc.www.Product.Service;

import com.jsc.www.Product.Repository.ProductRepository;

import com.jsc.www.Product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    public boolean isProductInStock(Long productId) {
//        Optional<Product> optionalProduct = productRepository.findById(productId);
//        if (optionalProduct.isPresent()) {
//            Product product = optionalProduct.get();
//            if (product.getQuantity() > 0) {
//                return true;
//            }
//        }
//        return false;
//    }


    public Product createProduct(Product product)    {

        return productRepository.save(product);
    }


    public Product getProductBasedOnId(  Long productId) {
        return productRepository.findById(productId).get();
    }


//    public Product updateProduct(Long productId, Product updatedProduct) {
//        Product existingProduct = productRepository.findById(updatedProduct.getId())
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//
//    }
public int getProductTotalByProductCode(String productCode) {
    return productRepository.getTotalQuantityByProductCode(productCode);
}

    public Product updateProduct(Product productObject)
    {
        return productRepository.save(productObject);
    }




    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

//    public int getProductTotalByProductCode(String productCode) {
//        return productRepository.getTotalQuantityByProductCode(productCode);
//    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}
