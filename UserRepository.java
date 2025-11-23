package com.agencia.viagens.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.agencia.viagens.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
