package com.example.baitapngay10.repository;

import com.example.baitapngay10.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByDeletedFalse();

    List<User> findByDeletedFalseAndUsernameContainingIgnoreCase(String username);

    Optional<User> findByIdAndDeletedFalse(String id);

    List<User> findByRoleIdAndDeletedFalse(String roleId);

    Optional<User> findByEmailAndUsernameAndDeletedFalse(String email, String username);
}
