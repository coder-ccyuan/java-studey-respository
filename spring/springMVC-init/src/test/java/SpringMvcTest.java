import org.example.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMvcTest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
        UserController bean = ioc.getBean(UserController.class);
        System.out.println(bean);
    }
}
