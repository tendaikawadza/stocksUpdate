package com.jsc.www.Product.Repository;


import com.jsc.www.Product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT SUM(p.Quantity) FROM Product p WHERE p.productCode = :productCode")
    int getTotalQuantityByProductCode(@Param("productCode") String productCode);
}
