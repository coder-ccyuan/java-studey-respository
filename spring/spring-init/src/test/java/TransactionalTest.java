import org.cpy.dao.UserDAO;
import org.cpy.entiey.User;
import org.cpy.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class TransactionalTest {
    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = ioc.getBean(UserService.class);
//        transactionalTest(userService);
        User user = new User();
        user.setAge(23);
        user.setId(432);
        user.setName("trhyrthh");
        userService.addUser(user);
    }
    @Transactional
    public void transactionalTest(UserService userService){
        User user = new User();
        user.setAge(23);
        user.setId(432);
        user.setName("trhyrthh");
        userService.addUser(user);
        int a=10/0;

    }
}
