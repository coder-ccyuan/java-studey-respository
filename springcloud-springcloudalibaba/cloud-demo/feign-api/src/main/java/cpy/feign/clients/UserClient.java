package cpy.feign.clients;

import cpy.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-nacos")
public interface UserClient {
    @GetMapping("/user/get")
    public User getUse(@RequestParam("id") Long id);
}
