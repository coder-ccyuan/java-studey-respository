package org.example.config;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置Ribbon的负载均衡算法
 */
@Configuration
public class RibbonConfig {
    /**
     * 配置Ribbon 负载均衡算法 RandomRule,替换了默认的轮询算法，改为随机算法
     * @return
     */
//    @Bean
//    public IRule getRandomRule() {
//        return new RandomRule();
//    }

    /**
     * 配置Ribbon 负载均衡算法 RandomRule,替换了默认的轮询算法，改为NacosRule:优先选择在同一集群的服务，使用随机选择实例
     * @return
     */
    @Bean
    public IRule getNacosRule(){
        return new NacosRule();
    }
}
