package com.ggozlo.crud.dto;

import com.ggozlo.crud.Entity.School;
import lombok.*;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {

    private Long id;
    private String name;
    private String tel;

    public static School toDomain( SchoolDto dto) {
        return new School(dto.getId(), dto.getName(), dto.getTel());
    }

    public static SchoolDto toDto(School school) {
        return new SchoolDto( school.getId(), school.getName(), school.getTel());
    }
}
