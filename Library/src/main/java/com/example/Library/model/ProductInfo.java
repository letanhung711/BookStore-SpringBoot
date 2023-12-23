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
    @Column(columnDefinition = "LONGTEXT")
    private String paragraph;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", nxb='" + nxb + '\'' +
                ", ngayxb='" + ngayxb + '\'' +
                ", nhaphathanh='" + nhaphathanh + '\'' +
                ", size='" + size + '\'' +
                ", numberPage='" + numberPage + '\'' +
                ", weight='" + weight + '\'' +
                ", paragraph='" + paragraph + '\'' +
                ", product=" + (product == null ? "null" : "{product.id=" + product.getId() + "}") +
                '}';
    }
}
