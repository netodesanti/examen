package com.examen.Examen1.web;

import com.examen.Examen1.domain.User;
import com.examen.Examen1.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createTask(@RequestBody User user) {
        userService.createUser(user);

        return "User created";
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/find-by-nickname")
    public User findByNickname(@RequestParam String nickname) {
        User userFound = userService.findAllByNickname(nickname);

        if (userFound != null && userFound.getStatus().equals("A")) {
            return userFound;
        } else {
            return null;
        }

    }

}
