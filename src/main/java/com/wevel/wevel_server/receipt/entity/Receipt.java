package com.wevel.wevel_server.receipt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wevel.wevel_server.memo.entity.Memo;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long receiptId;

    @Column
    private Long userId;

    @Column
    private String tripName;

    @Column
    private String title;

    @JsonManagedReference
    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    @JsonBackReference
    @OneToOne(mappedBy = "receipt", cascade = CascadeType.ALL)
    private Memo memo;

    @Column
    private int tax;

    @Column
    private Date date;
}

