package com.stock.Service.implementation;

import com.stock.Model.Employee;
import com.stock.Model.ProductRequest;
import com.stock.Repository.EmployeeRepository;

import com.stock.Repository.ProductRequestRepository;
import com.stock.Service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

import static org.apache.commons.lang3.RandomStringUtils.*;
import static org.springframework.data.domain.PageRequest.of;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j

public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;
  private final ProductRequestRepository productRequestRepository;
  private final NamedParameterJdbcTemplate jdbc;
  @Override
  public Employee createEmployee(Employee employee) {
    employee.getCreatedAt();
    return employeeRepository.save(employee);
  }

  @Override
  public Employee updateEmployee(Employee employee) {



    return employeeRepository.save(employee);
  }

  @Override
  public Page<Employee> getCustomer(int page, int size) {
    return employeeRepository.findAll(of(page, size));
  }

  @Override
  public Iterable<Employee> getEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee getEmployee(Long id) {
    return employeeRepository.findById(id).get();
  }

  @Override
  public Page<Employee> searchEmployees(String name, int page, int size) {
    return employeeRepository.findByNameContaining(name,of(page,size));
  }

  @Override
  public ProductRequest createProductRequast(ProductRequest productRequest) {

    return null;
  }


  @Override
  public Page<ProductRequest> getProductRequest(int page, int size) {



    return productRequestRepository.findAll(of(page,size));
  }
  @Override
  public void addProductRequestToEmployee(Long id, Long  PurchaserequestID) {
    Employee employee=employeeRepository.findById(id).get();
    ProductRequest productRequest=productRequestRepository.findById(PurchaserequestID).get();
    productRequest.setEmployee(employee);
    productRequestRepository.save(productRequest);


  }
}
