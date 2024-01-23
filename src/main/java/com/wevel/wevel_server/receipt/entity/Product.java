package com.wevel.wevel_server.receipt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long productId;

    @Column
    private String productName;

    @Column
    private double price;

    @Column
    private int quantity;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    // 생성자 수정
    public Product(String productName, double price, int quantity, Receipt receipt) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.receipt = receipt;
    }
}
