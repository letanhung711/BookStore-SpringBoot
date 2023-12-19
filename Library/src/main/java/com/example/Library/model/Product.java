package com.example.Library.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String name;
    private String author;
    private Double price;
    private Integer quantity;
    private String note;
    private String imageUrl;
    private Timestamp create_time;
    private Timestamp update_time;

    @OneToMany(mappedBy = "products")
    @JsonManagedReference
    private List<OrderDetail> orderDetails;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductInfo productInfo;
}
