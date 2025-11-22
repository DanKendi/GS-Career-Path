package br.com.fiap.CareerPath.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "t_cp_profissional")
public class Profissional {

    @Id
    @Column(name = "id_profissional")
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, name = "profissao_atual")
    private String profissaoAtual;

    @Column(nullable = false)
    @Email
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
