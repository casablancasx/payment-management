package com.danilo.project.paymentmanagementservice.repositories;

import com.danilo.project.paymentmanagementservice.entities.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work,Long> {
}
