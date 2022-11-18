package com.example.recommendationMicroservice.repositories;

import com.example.recommendationMicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


     List<User> findAll() ;
}
