package com.ggozlo.score.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "ORDERTBL")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = LAZY)
    private User user;

    @Column(length = 20)
    private String name;

    @Column(length = 6)
    private int price;

    @Column(length = 3)
    private int amount;
}
