package com.ggozlo.score.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Score {

    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "class", nullable = false)
    private int num;
    @Column(nullable = false)
    private int kor;
    @Column(nullable = false)
    private int eng;
    @Column(nullable = false)
    private int mat;

    public Score(String name, int num, int kor, int eng, int mat) {
        this.name = name;
        this.num = num;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }
}
