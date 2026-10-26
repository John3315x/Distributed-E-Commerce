package com.ecommerce.authservice.repository;

import com.ecommerce.authservice.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Session findByTokenId(String tokenId);

    int countByUserIdAndRevokedFalse(Long userId);
}
