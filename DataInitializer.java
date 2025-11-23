package com.agencia.viagens.config;

import com.agencia.viagens.model.*;
import com.agencia.viagens.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(RoleRepository roleRepo, UserRepository userRepo,
                           DestinoRepository destinoRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            // cria roles se não existirem
            Role admin = roleRepo.findByName("ROLE_ADMIN").orElseGet(() -> roleRepo.save(new Role(null, "ROLE_ADMIN")));
            Role user = roleRepo.findByName("ROLE_USER").orElseGet(() -> roleRepo.save(new Role(null, "ROLE_USER")));

            if (userRepo.findByUsername("admin").isEmpty()) {
                UserEntity u = new UserEntity();
                u.setUsername("admin");
                u.setPassword(passwordEncoder.encode("admin123"));
                u.setEnabled(true);
                u.setRoles(Set.of(admin, user));
                userRepo.save(u);
            }

            if (userRepo.findByUsername("user").isEmpty()) {
                UserEntity u = new UserEntity();
                u.setUsername("user");
                u.setPassword(passwordEncoder.encode("password123"));
                u.setEnabled(true);
                u.setRoles(Set.of(user));
                userRepo.save(u);
            }

            // dados de exemplo
            if (destinoRepo.count() == 0) {
                destinoRepo.save(new Destino(null, "Rio de Janeiro", "Brasil", "Praias e cultura"));
                destinoRepo.save(new Destino(null, "Lisboa", "Portugal", "Cidade histórica com clima ameno"));
            }
        };
    }
}
