package org.cpy.service;

import org.cpy.entiey.User;

public interface UserService {
    public boolean addUser(User user);
    public User getUserById(int id);
}
