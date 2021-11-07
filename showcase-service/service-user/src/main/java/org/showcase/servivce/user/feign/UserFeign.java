package org.showcase.servivce.user.feign;

import lombok.extern.slf4j.Slf4j;
import org.showcase.api.user.client.UserClient;
import org.showcase.api.user.vo.UserVo;
import org.showcase.servivce.user.entity.User;
import org.showcase.servivce.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserFeign implements UserClient {

    @Autowired
    private UserService userService;

    @Override
    public UserVo getUserById(Long userId) {
        User user= userService.getByUserId(userId);
        if(user==null){
            return null;
        }
        UserVo userVo=new UserVo();
        BeanUtils.copyProperties(user,userVo);
        return userVo;
    }
}
