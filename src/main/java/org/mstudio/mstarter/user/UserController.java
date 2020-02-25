package org.mstudio.mstarter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
        User user = new User();
        user.setName("Macrow");
        user.setTest(new Date());
        userRepository.save(user);
    }
}
