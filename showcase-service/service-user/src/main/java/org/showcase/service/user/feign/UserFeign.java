package org.showcase.service.user.feign;

import lombok.extern.slf4j.Slf4j;
import org.showcase.api.user.client.UserClient;
import org.showcase.api.user.vo.UserVo;
import org.showcase.service.user.entity.User;
import org.showcase.service.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class UserFeign implements UserClient {

    @Autowired
    private UserService userService;

    @Override
    public UserVo getUserById(Long userId)  {
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user= userService.getByUserId(userId);
        if(user==null){
            return null;
        }
        UserVo userVo=new UserVo();
        BeanUtils.copyProperties(user,userVo);
        return userVo;
    }
}
