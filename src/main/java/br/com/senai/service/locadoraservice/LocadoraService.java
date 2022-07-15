package br.com.senai.service.locadoraservice;

import java.util.List;

import br.com.senai.model.Locadora;

public interface LocadoraService {
    
    public List<Locadora> listaDeLocadoras();

    public Locadora createLocadora(Locadora newLocadora);

    public void deleteLocadora(Long id);

    public Locadora updateLocadora(Long id);

}
