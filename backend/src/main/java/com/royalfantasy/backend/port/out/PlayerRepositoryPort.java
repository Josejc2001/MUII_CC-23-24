package com.royalfantasy.backend.port.out;

import com.royalfantasy.backend.domain.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepositoryPort {
    Player save(final Player player);
    Optional<Player> findById(final Long id);
    List<Player> findAll();
    Player update(final Player player);
    boolean deleteById(final Long id);
}
