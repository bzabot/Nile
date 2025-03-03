package com.example.backend.repositories;


import com.example.backend.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findUserById(UUID userId);

}
