package com.ghfelipe.formulario.model;

import jakarta.persistence.*;

@Entity(name = "aluno")
public class AlunoEntity {

    @Id
    @Column(name = "ID_aluno")
    private int id;

    @Column(name = "tx_nome")
    private String nome;

    @Column(name = "tx_materia")
    private String materia;

    @Column(name = "tx_cpf", unique = true, length = 11)
    private String cpf;

    @Column(name = "tx_cargahoraria")
    private int cargaHoraria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
