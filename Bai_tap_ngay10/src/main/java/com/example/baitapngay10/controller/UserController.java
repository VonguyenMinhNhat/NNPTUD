package com.example.baitapngay10.controller;

import com.example.baitapngay10.dto.EnableDisableRequest;
import com.example.baitapngay10.model.User;
import com.example.baitapngay10.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(@RequestParam(required = false) String username) {
        return userService.getAllUsers(username);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public User softDeleteUser(@PathVariable String id) {
        return userService.softDeleteUser(id);
    }

    @PostMapping("/enable")
    public User enableUser(@Valid @RequestBody EnableDisableRequest request) {
        return userService.updateStatus(request.getEmail(), request.getUsername(), true);
    }

    @PostMapping("/disable")
    public User disableUser(@Valid @RequestBody EnableDisableRequest request) {
        return userService.updateStatus(request.getEmail(), request.getUsername(), false);
    }
}
