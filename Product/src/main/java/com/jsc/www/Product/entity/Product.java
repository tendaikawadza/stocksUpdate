package com.jsc.www.Product.entity;


import jakarta.persistence.*;


import java.util.Date;


@Entity

public class Product {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(nullable = false,updatable = false)
    private Long productId;

    private String productName;

    /*@Temporal(TemporalType.TIMESTAMP)*/
    private Date date;
    private String productCode;


    private int Quantity;


  public Product() {
  }

  public Product(Long productId, String productName, Date date, String productCode, int quantity) {
    this.productId = productId;
    this.productName = productName;
    this.date = date;
    this.productCode = productCode;
    Quantity = quantity;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public int getQuantity() {
    return Quantity;
  }

  public void setQuantity(int quantity) {
    Quantity = quantity;
  }

  @Override
  public String toString() {
    return "Product{" +
      "productId=" + productId +
      ", productName='" + productName + '\'' +
      ", date=" + date +
      ", productCode='" + productCode + '\'' +
      ", Quantity=" + Quantity +
      '}';
  }
}
