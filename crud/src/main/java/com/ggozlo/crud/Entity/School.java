package com.ggozlo.crud.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class School {

    @Id
    @Column(name = "SCHOOL_ID")
    private Long id;

    private String name;

    private String tel;
}
