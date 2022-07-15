package br.com.senai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity (name = "usuario")
public class  Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    private String nome;

    @Size(max = 80)
    @NotNull
    private String username;

    @Size(max = 100)
    @NotNull
    private String email;

    @Size(max = 50)
    @NotNull
    private String senha;

    @ManyToOne
    @JoinColumn(name = "locadora_id", nullable = true)
    @JsonBackReference
    private Locadora locadora;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Locadora getLocadora() {
        return locadora;
    }
    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    @Override
    public String toString() {
        return "Usuário: " +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nUsername: " + username +
                "\nEmail:" + email +
                "\nSenha: " + senha ;
    }

}
