package com.ggozlo.score.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERTBL")
public class User {

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Order> order;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String address;

    @Column(length = 20)
    private String tel;

}
