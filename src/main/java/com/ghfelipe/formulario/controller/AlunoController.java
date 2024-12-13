package com.ghfelipe.formulario.controller;

import com.ghfelipe.formulario.model.AlunoEntity;
import com.ghfelipe.formulario.repositories.AlunoRepository;
import com.ghfelipe.formulario.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoService service;

    @GetMapping
    public List<AlunoEntity> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> post(@RequestBody AlunoEntity aluno) {
        String cpf = String.valueOf(aluno.getCpf());
        String nome = aluno.getNome();
        String materia = aluno.getMateria();
        String cargaHoraria = String.valueOf(aluno.getCargaHoraria());

        service.save(aluno);

        return ResponseEntity.ok().build();
    }

}
