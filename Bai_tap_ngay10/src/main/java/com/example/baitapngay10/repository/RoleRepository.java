package com.example.baitapngay10.repository;

import com.example.baitapngay10.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

    List<Role> findByDeletedFalse();

    Optional<Role> findByIdAndDeletedFalse(String id);
}
