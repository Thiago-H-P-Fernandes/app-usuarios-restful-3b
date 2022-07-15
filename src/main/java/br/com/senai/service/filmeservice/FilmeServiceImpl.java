package br.com.senai.service.filmeservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senai.model.Filme;
import br.com.senai.model.Locadora;
import br.com.senai.repository.FilmeRepository;
import br.com.senai.repository.LocadoraRepository;

public class FilmeServiceImpl implements FilmeService {

    @Autowired
    FilmeRepository filmeRepository;
    LocadoraRepository locadoraRepository;

    @Override
    public List<Filme> filmesList() {
        return filmeRepository.findAll();
    }

    @Override
    public Filme createFilme(Filme newFilme) {
        try {
            return filmeRepository.save(newFilme);
        }
        catch (Exception e){
            throw  new IllegalArgumentException("Ocorreu um erro ao salvar o filme!");
        }
    }

    @Override
    public void deleteFilme(Long id) {
        Optional<Filme> filme_data = filmeRepository.findById(id);
        if (filme_data.isEmpty()){
            throw new IllegalArgumentException("Este filme não existe em nosso banco de dados.");
        }
        filmeRepository.delete(filme_data.get());
    }

    @Override
    public Filme updateFilme(Long id, Filme updateFilme) {
        Optional<Filme> filme_data = filmeRepository.findById(id);
        if(filme_data.isEmpty()){
            throw new IllegalArgumentException("Este filme não existe em nosso banco de dados.");
        }
        filme_data.get().setTitulo(updateFilme.getTitulo());
        filme_data.get().setAno(updateFilme.getAno());
        filme_data.get().setGenero(updateFilme.getGenero());
        filme_data.get().setPreco(updateFilme.getPreco());
        return filmeRepository.save(filme_data.get());
    }

    @Override
    public void saveFilmeInLocadora(Long filme_id, Long locadora_id) {
        Optional<Filme> filme_data = filmeRepository.findById(filme_id);
        Optional<Locadora> locadora_data = locadoraRepository.findById(locadora_id);

        if (filme_data.isEmpty() || locadora_data.isEmpty()){
            throw new IllegalArgumentException("Filme ou Locadora não encotrados!");
        }

        filme_data.get().setLocadora(locadora_data.get());
        filmeRepository.save(filme_data.get());
    }

}