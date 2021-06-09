package com.ggozlo.intelimvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class Member {

    private Long id;

    private String name;

    private String tel;
}
