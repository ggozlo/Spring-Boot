package com.example.crud3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {

    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true, length = 20)
    private String tel;
}
