package com.example.baitapngay10.controller;

import com.example.baitapngay10.model.Role;
import com.example.baitapngay10.model.User;
import com.example.baitapngay10.service.RoleService;
import com.example.baitapngay10.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;
    private final UserService userService;

    public RoleController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable String id) {
        return roleService.getRoleById(id);
    }

    @DeleteMapping("/{id}")
    public Role softDeleteRole(@PathVariable String id) {
        return roleService.softDeleteRole(id);
    }

    @GetMapping("/{id}/users")
    public List<User> getUsersByRole(@PathVariable String id) {
        roleService.getRoleById(id);
        return userService.getUsersByRoleId(id);
    }
}
