package br.com.fiap.CareerPath.controller.dto;

public class ProfissionalResponseDTO {

    private Integer id;
    private String nome;
    private String profissaoAtual;
    private String email;

    public ProfissionalResponseDTO() {
    }

    public ProfissionalResponseDTO(Integer id, String nome, String profissaoAtual, String email) {
        this.id = id;
        this.nome = nome;
        this.profissaoAtual = profissaoAtual;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissaoAtual() {
        return profissaoAtual;
    }

    public void setProfissaoAtual(String profissaoAtual) {
        this.profissaoAtual = profissaoAtual;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
