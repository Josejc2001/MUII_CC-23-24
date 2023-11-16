package com.royalfantasy.backend.infrastructure.repository.jpa;

import com.royalfantasy.backend.infrastructure.repository.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
