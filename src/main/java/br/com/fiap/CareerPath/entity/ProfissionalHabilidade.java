package br.com.fiap.CareerPath.entity;

import jakarta.persistence.*;

@Entity
public class ProfissionalHabilidade {

    @Id
    @Column(name = "id_profissional_habilidade")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;


    @ManyToOne(optional = false)
    @JoinColumn(name = "habilidade_id")
    private Habilidade habilidade;

    @Column(nullable = false, name = "nivel_atual")
    private Integer nivelAtual;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(Integer nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }
}
