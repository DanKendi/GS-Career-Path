package br.com.fiap.CareerPath.controller.dto;

public class ProfissionalHabilidadeResponseDTO {
    private Integer id;
    private ProfissionalResponseDTO profissional;
    private HabilidadeResponseDTO habilidade;
    private Integer nivelAtual;

    public ProfissionalHabilidadeResponseDTO() {
    }

    public ProfissionalHabilidadeResponseDTO(Integer id, ProfissionalResponseDTO profissional, HabilidadeResponseDTO habilidade, Integer nivelAtual) {
        this.id = id;
        this.profissional = profissional;
        this.habilidade = habilidade;
        this.nivelAtual = nivelAtual;
    }

    public Integer getId() {
        return id;
    }

    public ProfissionalResponseDTO getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalResponseDTO profissional) {
        this.profissional = profissional;
    }

    public HabilidadeResponseDTO getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(HabilidadeResponseDTO habilidade) {
        this.habilidade = habilidade;
    }

    public Integer getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(Integer nivelAtual) {
        this.nivelAtual = nivelAtual;
    }
}
