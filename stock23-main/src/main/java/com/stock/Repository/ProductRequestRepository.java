package com.stock.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.Model.ProductRequest;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRequestRepository extends PagingAndSortingRepository<ProductRequest, Long>, ListCrudRepository<ProductRequest,Long> {
List<ProductRequest> findByReceiverId(Long receivableId);



}
