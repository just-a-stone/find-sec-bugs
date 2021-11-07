package testcode.mybatis.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import testcode.mybatis.entity.User;
import testcode.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void test() {
        Integer count = userMapper.selectCount(Wrappers.<User>lambdaQuery()
                .eq(User::getName, getVal())
                .eq(User::getId, "12345")
        );
    }

    private String getVal() {
        return "a";
    }

}
