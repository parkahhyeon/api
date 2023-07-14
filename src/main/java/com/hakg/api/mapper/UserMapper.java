package com.hakg.api.mapper;

import com.hakg.api.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public void signUp(User user);
}
