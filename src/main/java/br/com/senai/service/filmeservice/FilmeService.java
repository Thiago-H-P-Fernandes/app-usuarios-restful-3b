package br.com.senai.service.filmeservice;

import java.util.List;

import br.com.senai.model.Filme;

public interface FilmeService {
    
    public List<Filme> filmesList();

    public Filme createFilme(Filme newFilme);

    public void deleteFilme(Long id);

    public Filme updateFilme(Long id, Filme updateFilme);

    public void saveFilmeInLocadora(Long filme_id, Long locadora_id);

}
