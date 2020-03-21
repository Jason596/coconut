package ccc.springboot.coconut.controller;

import ccc.springboot.coconut.model.entity.User;
import ccc.springboot.coconut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        this.userService.addUser(user);
    }

    @GetMapping("/userList")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable @Valid  Integer id) {
        this.userService.deleteUser(id);
    }
}
