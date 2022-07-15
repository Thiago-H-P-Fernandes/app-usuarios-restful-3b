package br.com.senai.service.locadoraservice;

import br.com.senai.model.Locadora;
import br.com.senai.repository.LocadoraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocadoraServiceImpl implements LocadoraService {

    @Autowired
    LocadoraRepository locadoraRepository;


    @Override
    public List<Locadora> listaDeLocadoras() {
        return locadoraRepository.findAll();
    }

    @Override
    public Locadora createLocadora(Locadora newLocadora) {
        try {
            return locadoraRepository.save(newLocadora);
        }catch (Exception e){
            throw new IllegalArgumentException("Ocorreu um erro. Tente novamente!");
        }
    }

    @Override
    public void deleteLocadora(Long id) {
        Optional<Locadora> locadora_data = locadoraRepository.findById(id);
        if (locadora_data.isEmpty()){
            throw new IllegalArgumentException
                    ("Esta locadora não existe em nosso banco de dados.");
        }
        locadoraRepository.delete(locadora_data.get());
    }

    @Override
    public Locadora updateLocadora(Long id) {
        Optional<Locadora> locadora_data = locadoraRepository.findById(id);
        if (locadora_data.isEmpty()){
            throw new IllegalArgumentException
                    ("Esta locadora não existe em nosso banco de dados.");
        }
       return locadoraRepository.save(locadora_data.get());
    }
}