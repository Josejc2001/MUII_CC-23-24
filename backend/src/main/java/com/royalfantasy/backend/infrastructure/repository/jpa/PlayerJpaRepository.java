package com.royalfantasy.backend.infrastructure.repository.jpa;

import com.royalfantasy.backend.infrastructure.repository.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Long> {
}
