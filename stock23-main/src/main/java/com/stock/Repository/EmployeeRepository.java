package com.stock.Repository;

import com.stock.Model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long>, ListCrudRepository<Employee,Long> {
  Page<Employee> findByNameContaining(String name, Pageable pageable);

}
