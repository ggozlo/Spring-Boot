package com.example.mybatis.repository;

import com.example.mybatis.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberRepository {

    public void saveMember(Member member);

    public Member findOne(Long id);

    public List<Member> memberList();

    public List<Member> memberNameSearch(String name);

    public void deleteMember(Long id);

    public void modifyMember(Member member);
}
