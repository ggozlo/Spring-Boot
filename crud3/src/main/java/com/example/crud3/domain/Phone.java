package com.example.crud3.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "seq", sequenceName = "seq", allocationSize = 10)
public class Phone {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String tel;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "phone_ID"))
    private List<User> users =  new ArrayList<>();


    public Phone(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "tel='" + tel + '\'' +
                '}';
    }
}
