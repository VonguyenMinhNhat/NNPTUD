package com.example.baitapngay10.service;

import com.example.baitapngay10.model.User;
import com.example.baitapngay10.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private static final String USER_NOT_FOUND = "User not found";

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(String usernameFilter) {
        if (usernameFilter != null && !usernameFilter.isBlank()) {
            return userRepository.findByDeletedFalseAndUsernameContainingIgnoreCase(usernameFilter.trim());
        }
        return userRepository.findByDeletedFalse();
    }

    public User getUserById(String id) {
        return userRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND));
    }

    public User softDeleteUser(String id) {
        User user = getUserById(id);
        user.setDeleted(true);
        return userRepository.save(user);
    }

    public User updateStatus(String email, String username, boolean status) {
        User user = userRepository.findByEmailAndUsernameAndDeletedFalse(email, username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND));
        user.setStatus(status);
        return userRepository.save(user);
    }

    public List<User> getUsersByRoleId(String roleId) {
        return userRepository.findByRoleIdAndDeletedFalse(roleId);
    }
}
