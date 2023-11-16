package com.royalfantasy.backend.infrastructure.repository.jpa;

import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.infrastructure.repository.mapper.PlayerEntityMapper;
import com.royalfantasy.backend.infrastructure.repository.mapper.PlayerMapper;
import com.royalfantasy.backend.port.out.PlayerRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaPlayerRepositoryAdapter implements PlayerRepositoryPort {
    private final JpaPlayerRepository jpaPlayerRepository;

    public JpaPlayerRepositoryAdapter(JpaPlayerRepository jpaPlayerRepository) {
        this.jpaPlayerRepository = jpaPlayerRepository;
    }

    @Override
    public Player save(Player player) {
        return PlayerMapper.map(this.jpaPlayerRepository.save(PlayerEntityMapper.map(player)));
    }

    @Override
    public Optional<Player> findById(Long id) {
        return jpaPlayerRepository.findById(id).map(PlayerMapper::map);
    }

    @Override
    public List<Player> findAll() {
        return jpaPlayerRepository.findAll().stream()
                .map(PlayerMapper::map).
                collect(Collectors.toList());
    }

    @Override
    public Player update(Player player) {
        if(jpaPlayerRepository.existsById(player.getId())){
            return PlayerMapper.map(this.jpaPlayerRepository.save(PlayerEntityMapper.map(player)));
        } else{
            return null;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if(jpaPlayerRepository.existsById(id)){
            jpaPlayerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
