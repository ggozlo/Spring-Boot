package com.example.crud3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "USERS")
@SequenceGenerator(name = "userSeq", sequenceName = "userSeq", allocationSize = 5)
public class User {

    @Id
    @GeneratedValue(generator = "userSeq")
    private Long id;

    private String name;

    //@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Collection<Phone> phones = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void addPhone(Phone phone) {
        this.getPhones().add(phone);
        phone.getUsers().add(this);
    }
}