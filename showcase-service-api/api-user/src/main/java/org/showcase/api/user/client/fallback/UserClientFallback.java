package org.showcase.api.user.client.fallback;

import lombok.extern.slf4j.Slf4j;
import org.showcase.api.user.client.UserClient;
import org.showcase.api.user.vo.UserVo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserClientFallback implements UserClient {

    @Override
    public UserVo getUserById(Long userId) {
        log.info("UserClientFallback");
        return null;
    }
}
