package com.ecommerce.authservice.repository;


import com.ecommerce.authservice.entity.SecurityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityLogRepository extends JpaRepository<SecurityLog, Long> {

}
