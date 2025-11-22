package br.com.fiap.CareerPath.controller.dto;

public class HabilidadeResponseDTO {
    private Integer id;
    private String nome;
    private Integer nivelNecessario;

    public HabilidadeResponseDTO() {
    }

    public HabilidadeResponseDTO(Integer id, String nome, Integer nivelNecessario) {
        this.id = id;
        this.nome = nome;
        this.nivelNecessario = nivelNecessario;
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

    public Integer getNivelNecessario() {
        return nivelNecessario;
    }

    public void setNivelNecessario(Integer nivelNecessario) {
        this.nivelNecessario = nivelNecessario;
    }
}
