package com.ghfelipe.formulario.service;

import com.ghfelipe.formulario.model.AlunoEntity;
import com.ghfelipe.formulario.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<AlunoEntity> findAll() {
        return repository.findAll();
    }

    public void save(AlunoEntity alunoEntity) {
        repository.save(alunoEntity);
    }
}
