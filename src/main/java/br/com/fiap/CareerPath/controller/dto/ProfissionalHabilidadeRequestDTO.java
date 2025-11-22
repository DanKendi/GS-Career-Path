package br.com.fiap.CareerPath.controller.dto;

import jakarta.validation.constraints.NotNull;

public class ProfissionalHabilidadeRequestDTO {
    @NotNull
    private Integer profissionalId;

    @NotNull
    private Integer habilidadeId;

    @NotNull
    private Integer nivelAtual;

    public Integer getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Integer profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Integer getHabilidadeId() {
        return habilidadeId;
    }

    public void setHabilidadeId(Integer habilidadeId) {
        this.habilidadeId = habilidadeId;
    }

    public Integer getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(Integer nivelAtual) {
        this.nivelAtual = nivelAtual;
    }
}
