package com.agencia.viagens.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.agencia.viagens.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
