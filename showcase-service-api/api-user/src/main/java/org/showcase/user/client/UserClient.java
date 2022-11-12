package org.showcase.user.client;

import org.showcase.user.client.fallback.UserClientFallback;
import org.showcase.user.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-user",contextId = "user",fallback = UserClientFallback.class)
public interface UserClient {
    public final String CLIENT_PREFIX="client";

    @GetMapping(CLIENT_PREFIX+"/user/get")
    public UserVo getUserById(@RequestParam("userId") Long userId) ;
}
