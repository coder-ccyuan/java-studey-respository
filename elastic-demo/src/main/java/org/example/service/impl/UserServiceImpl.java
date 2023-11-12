package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.User;
import org.example.service.UserService;
import org.example.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 成希德
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-11-12 20:03:22
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




