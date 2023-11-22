package com.driagon.springdatajpa.transactions.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "CARD_NAME")
    private String cardName;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "EXPIRY_YEAR")
    private int expiryYear;

    @Column(name = "EXPIRY_MONTH")
    private int expiryMonth;

    @Column(name = "CVC")
    private int cvc;

    private Long orderId;
}
