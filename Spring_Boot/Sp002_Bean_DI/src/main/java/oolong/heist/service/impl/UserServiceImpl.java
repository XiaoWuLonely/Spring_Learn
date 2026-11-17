package oolong.heist.service.impl;

import oolong.heist.bean.User;
import oolong.heist.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        return new User("jackson","123456");
    }
}
