package com.example.crud3.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;

@Data
@NoArgsConstructor
public class Dto {
    private String name;

    private String [] tel;
}
