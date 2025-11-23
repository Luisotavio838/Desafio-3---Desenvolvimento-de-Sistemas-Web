package com.agencia.viagens.controller;

import com.agencia.viagens.model.Destino;
import com.agencia.viagens.repository.DestinoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    private final DestinoRepository repo;
    public DestinoController(DestinoRepository repo) { this.repo = repo; }

    // qualquer usuário autenticado pode ver destinos
    @GetMapping
    public List<Destino> listar() { return repo.findAll(); }

    // somente ADMIN pode criar
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Destino> criar(@RequestBody Destino d) {
        Destino salvo = repo.save(d);
        return ResponseEntity.ok(salvo);
    }
}
