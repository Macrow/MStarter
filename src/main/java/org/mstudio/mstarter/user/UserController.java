package org.mstudio.mstarter.user;

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
        Iterable<User> users = userRepository.findAll();
        return Result.success(users);
    }

    @GetMapping("/ok2")
    public Result ok2() {
        Test test = new Test("Test");
        return Result.success(test);
    }

    @GetMapping("/ok3")
    public Result ok3() {
        return Result.success("OK");
    }

    @GetMapping("/fail")
    public Result fail() {
        return Result.failed();
    }
}
