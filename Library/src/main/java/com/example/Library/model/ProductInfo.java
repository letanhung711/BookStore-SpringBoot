package com.example.Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nxb;
    private String ngayxb;
    private String nhaphathanh;
    private String size;
    private String numberPage;
    private String weight;
    private String paragraph;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
