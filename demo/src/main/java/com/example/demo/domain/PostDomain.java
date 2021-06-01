package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class PostDomain {

    @Id @GeneratedValue
    @Column(name = "POST_ID")
    private Long id;

    @Column(length = 50)
    private String title;

    @Lob
    private String content;


}
