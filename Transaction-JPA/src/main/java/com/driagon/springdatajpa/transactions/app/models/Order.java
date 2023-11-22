package com.driagon.springdatajpa.transactions.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ORDER_TRACKING_NUMBER")
    private String orderTrackingNumber;

    @Column(name = "TOTAL_QUANTITY")
    private int totalQuantity;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    @Column(name = "STATUS")
    private String status;

    @CreationTimestamp
    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "LAST_UPDATED")
    private LocalDateTime lastUpdated;

    @Column(name = "SHOPPING_CART_ID")
    private Long shoppingCartId;
}
