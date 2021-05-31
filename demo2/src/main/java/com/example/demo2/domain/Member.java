package com.example.demo2.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private String name;

    private String tel;

    private int kor, eng, mat;

    public int getTot() {
        return kor + eng +mat;
    }
}
