package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.User;
@Mapper
public interface UserMapper {
    User getUserById(@Param("id")Long id);
}
