package com.danilo.project.paymentmanagementservice.repositories;

import com.danilo.project.paymentmanagementservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
