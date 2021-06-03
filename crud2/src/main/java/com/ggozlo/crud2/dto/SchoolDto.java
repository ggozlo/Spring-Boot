package com.ggozlo.crud2.dto;

import com.ggozlo.crud2.domain.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDto {

    @Positive(message = "음수는 안됩니다!")
    @NotNull(message = "반드시 입력하세요!!")
    private Long id;

    @NotEmpty(message = "이름은 반드시 입력해야 합니다")
    private String name;

    private String tel;


    public static SchoolDto toDto(School school) {
        return new SchoolDto(school.getId(), school.getName(), school.getTel());
    }

    public static School toDomain(SchoolDto dto) {
        return new School(dto.getId(), dto.getName(), dto.getTel());
    }
}
