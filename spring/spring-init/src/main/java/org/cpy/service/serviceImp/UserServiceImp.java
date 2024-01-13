package org.cpy.service.serviceImp;

import org.cpy.dao.UserDAO;
import org.cpy.entiey.User;
import org.cpy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImp implements UserService {
    @Resource
    UserDAO userDAO;

    @Transactional
    @Override
    public boolean addUser(User user) {
        boolean b = userDAO.addUser(user);
//        int a= 10/0;
        return b;
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        User user = userDAO.queryUser(id);
        return user;
    }
}
