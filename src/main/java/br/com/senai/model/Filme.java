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

@Entity (name = "filme")
public class Filme {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Size (max = 100)
    @NotNull
    private String titulo;

    @NotNull
    private Integer ano;

    @Size (max = 50)
    @NotNull
    private String genero;

    @NotNull
    private double preco;


    @ManyToOne
    @JoinColumn(name = "locadora_id")
    @JsonBackReference
    private Locadora locadora;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
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
                "\nTítulo: " + titulo +
                "\nAno: " + ano +
                "\nGênero:" + genero +
                "\nPreço: " + preco ;
    }
}
