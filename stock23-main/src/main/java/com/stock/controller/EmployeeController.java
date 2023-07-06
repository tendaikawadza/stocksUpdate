package com.stock.controller;


import com.stock.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping(path="/employee")
@AllArgsConstructor
public class EmployeeController {
  private  final EmployeeService employeeService;

//
//  @GetMapping("/list")
//  public ResponceEntity<HttpResponse>


}
