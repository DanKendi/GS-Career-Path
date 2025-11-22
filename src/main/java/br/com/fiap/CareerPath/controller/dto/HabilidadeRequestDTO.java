package br.com.fiap.CareerPath.controller.dto;

import jakarta.validation.constraints.NotNull;

public class HabilidadeRequestDTO {

    @NotNull
    private String nome;

    private Integer nivelNecessario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivelNecessario() {
        return nivelNecessario;
    }

    public void setNivelNecessario(Integer nivelNecessario) {
        this.nivelNecessario = nivelNecessario;
    }
}
