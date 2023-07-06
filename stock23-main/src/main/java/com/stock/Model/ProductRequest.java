package com.stock.Model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Stock Request")
public class ProductRequest implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long productId;
    private String senderDepartment;
    private  String receiverDepartment;
    private Long senderId;
    private Long receiverId;
    private String productName;

    /*@Temporal(TemporalType.TIMESTAMP)*/
    private Date date;
    private String productCode;
    private int Quantity;
    private String status;

    private  Long PurchaserequestID;
    @ManyToOne
    @JoinColumn(name="employee_id",nullable = false)
    @JsonIgnore
   private Employee employee;



}
