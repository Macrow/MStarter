package org.mstudio.mstarter.user;

import cn.hutool.core.util.RandomUtil;
import org.mstudio.mstarter.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

/**
 * @author Macrow
 * @date 2020/2/26
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public void create() {
        IntStream.range(0, 100).forEach(i -> {
            User user = new User();
            user.setName("User - " + i);
            userRepository.save(user);
        });
    }

    @GetMapping("/ok")
    public Result ok() {
        User user = userRepository.findById(1232875288069804032L).orElseThrow(RuntimeException::new);
        user.setName(String.valueOf(RandomUtil.randomNumber()));
        User user2 = userRepository.save(user);
        return Result.success(user2);
    }

    @GetMapping("/ok2")
    public Result ok2() {
        User user = new User();
        user.setId(1232875288069804032L);
        user.setName(String.valueOf(RandomUtil.randomNumber()));
        User user2 = userRepository.save(user);
        return Result.success(user2);
    }

    @GetMapping("/ok3")
    public Result ok3() {
        User user = new User();
        user.setId(1232875288069804062L);
        user.setName(String.valueOf(RandomUtil.randomNumber()));
        User user2 = userRepository.save(user);
        return Result.success(user2);
    }

    @GetMapping("/ok4")
    public Result ok4() {
        userRepository.updateNameById(1232875288069801254L, String.valueOf(RandomUtil.randomNumber()));
        return Result.success();
    }

    @GetMapping("/ok5")
    public Result ok5() {
        throw new IllegalArgumentException("自定义消息");
    }
}
