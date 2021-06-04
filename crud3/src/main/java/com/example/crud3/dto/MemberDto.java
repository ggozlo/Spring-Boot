package com.example.crud3.dto;

import com.example.crud3.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    @Positive(message = "음수는 안됩니다!")
    @NotNull(message = "반드시 입력하세요!!")
    private Long id;

    @NotEmpty(message = "이름은 반드시 입력해야 합니다")
    private String name;

    private String tel;


    public static MemberDto toDto(Member school) {
        return new MemberDto(school.getId(), school.getName(), school.getTel());
    }

    public static Member toDomain(MemberDto dto) {
        return new Member(dto.getId(), dto.getName(), dto.getTel());
    }
}
