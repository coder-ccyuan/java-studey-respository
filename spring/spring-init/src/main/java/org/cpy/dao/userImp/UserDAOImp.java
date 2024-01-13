package org.cpy.dao.userImp;

import org.cpy.dao.UserDAO;
import org.cpy.entiey.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    @Resource
    JdbcTemplate jdbcTemplate;
    @Override
    public boolean addUser(User user) {
        int add = jdbcTemplate.update("insert into user values (?,?,?)", user.getId(), user.getName(), user.getAge());
        if (add>0)return true;
        return false;
    }

    @Override
    public User queryUser(int id) {
        RowMapper<User> userRowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> query = jdbcTemplate.query("select * from user where id=?", userRowMapper, id);
        if (query.size()==1)return query.get(0);
        return null;

    }
}
