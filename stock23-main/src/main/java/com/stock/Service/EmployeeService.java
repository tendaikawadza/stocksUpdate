package com.stock.Service;

import com.stock.Model.Employee;
import com.stock.Model.ProductRequest;
import org.springframework.data.domain.Page;

public interface EmployeeService {
  Employee createEmployee(Employee employee);
  Employee updateEmployee(Employee employee);
  Page<Employee>getCustomer(int page,int size);
  Iterable<Employee>getEmployees();
  Employee getEmployee(Long id);
  Page<Employee>searchEmployees(String name,int page,int size );
  ProductRequest createProductRequast(ProductRequest productRequest);
  Page<ProductRequest>getProductRequest(int page, int size);
  void addProductRequestToEmployee(Long id,Long  productRequestID);





}
