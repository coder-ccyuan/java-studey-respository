package org.cpy.dao;

import org.cpy.entiey.User;

public interface UserDAO {
    public boolean addUser(User user);
    public User queryUser(int id);
}
