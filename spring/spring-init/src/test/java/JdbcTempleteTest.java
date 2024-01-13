import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class JdbcTempleteTest {
    @Test

    public void jdbc(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql="insert into user value(?,?,?)";
        int jack = jdbcTemplate.update(sql, 2, "jack", 23);
        System.out.println(jack);
    }

}
