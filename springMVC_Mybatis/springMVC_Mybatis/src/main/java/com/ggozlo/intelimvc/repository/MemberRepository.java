package com.ggozlo.intelimvc.repository;


import com.ggozlo.intelimvc.dto.Member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberRepository {

    public void saveMember(Member member);

    public Member findOne(Long id);

    public List<Member> memberList();

    public List<Member> memberNameSearch(String name);

    public void deleteMember(Long id);

    public void modifyMember(Member member);
}
