package com.example.Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;
    private String name;
    private String author;
    private Double price;
    private Integer quantity;
    private String note;
    private String imageUrl;
    private Timestamp create_time;
    private Timestamp update_time;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductInfo productInfo;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", note='" + note + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", productInfo=" + (productInfo == null ? "null" : "{productInfo.id=" + productInfo.getId() + "}") +
                '}';
    }
}
