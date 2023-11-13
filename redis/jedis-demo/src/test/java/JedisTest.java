import com.sun.tracing.dtrace.ArgsAttributes;
import org.cpy.JedisConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    private Jedis jedis;
    @Before
    public void setUp(){
         jedis = new Jedis("localhost", 6379);
         jedis.auth("123456");
         jedis.select(0);
    }
    @Test
    public void testString(){
        jedis.set("name","zs");
        String name = jedis.get("name");
        System.out.println(name);
    }
    @Test
    public void testHash(){
        jedis.hset("user","id","1");
        Map<String, String> user = jedis.hgetAll("user");
        for (String s : user.keySet()) {
            System.out.println(s+":"+user.get(s));
        }
    }
    @After
    public void after(){
        if (jedis!=null){
            jedis.close();
        }
    }
    @Test
    public void testJedisPool(){
        Jedis jedis1 = JedisConnectionFactory.getJedis();
        String name = jedis.get("name");
        System.out.println(name);
    }

}
