package br.com.fiap.CareerPath.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_CP_HABILIDADE")
public class Habilidade {

    @Id
    @Column(name = "id_habilidade")
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "nivel_necessario")
    private Integer nivelNecessario;

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
