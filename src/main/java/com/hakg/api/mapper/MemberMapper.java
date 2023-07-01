package com.hakg.api.mapper;

import com.hakg.api.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    Member getAccountById(String mem_id);

    void createAccount(Member member);

    void updateAccount(Member member);

    void deleteAccount(String mem_id);
}
