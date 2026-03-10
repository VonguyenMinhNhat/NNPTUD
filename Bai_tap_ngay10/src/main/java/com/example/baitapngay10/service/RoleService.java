package com.example.baitapngay10.service;

import com.example.baitapngay10.model.Role;
import com.example.baitapngay10.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findByDeletedFalse();
    }

    public Role getRoleById(String id) {
        return roleRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found"));
    }

    public Role softDeleteRole(String id) {
        Role role = getRoleById(id);
        role.setDeleted(true);
        return roleRepository.save(role);
    }
}
