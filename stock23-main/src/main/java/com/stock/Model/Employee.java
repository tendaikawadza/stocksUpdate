package com.stock.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Employee Request")
public class Employee {
  private Long id;
  private String name ;
  private String email;

  private Date CreatedAt;
  private String phoneNumber;
  @OneToMany(mappedBy = "productRequest",fetch = FetchType.EAGER,cascade = CascadeType.ALL )
  private Collection<ProductRequest> productRequests;




}
