package com.example.test.dto;

import com.example.test.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private Long id;

    private String credit;

    private String name;

    private String address;

    private String tel;

    public static MemberDto doDto(Member member) {
        return new MemberDto(member.getId(),member.getCredit(),member.getName(),member.getAddress(),member.getTel());
    }

    public static Member doDomain(MemberDto dto) {
        return new Member(dto.getId(),dto.getCredit(),dto.getName(),dto.getAddress(),dto.getTel());
    }
}
