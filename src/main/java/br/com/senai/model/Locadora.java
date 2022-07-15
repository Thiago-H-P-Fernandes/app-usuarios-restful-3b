package br.com.senai.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity (name = "locadora")
public class Locadora {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    private String nome;

    @Size(max = 200)
    @NotNull
    private String local;

    
    @OneToMany(mappedBy = "locadora")
    @JsonManagedReference
    private Set<Usuario> usuarios_list;

    @OneToMany(mappedBy = "locadora")
    @JsonManagedReference
    private Set<Filme> filmes_list;


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

    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    public Set<Usuario> getUsuarios_list() {
        return usuarios_list;
    }
    public void setUsuarios_list(Set<Usuario> usuarios_list) {
        this.usuarios_list = usuarios_list;
    }

    public Set<Filme> getFilmes_list() {
        return filmes_list;
    }
    public void setFilmes_list(Set<Filme> filmes_list) {
        this.filmes_list = filmes_list;
    }

    @Override
    public String toString() {
        return "Locadora: " +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nLocal: " + local ;
    }
}
