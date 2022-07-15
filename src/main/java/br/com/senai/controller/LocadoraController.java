package br.com.senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.model.Locadora;
import br.com.senai.service.locadoraservice.LocadoraServiceImpl;

@RestController
@RequestMapping("/locadora")
public class LocadoraController {

    @Autowired
    LocadoraServiceImpl locadoraService;

    @PostMapping("/create")
    public ResponseEntity<Locadora> createLocadora(@RequestBody Locadora newLocadora){
        try {
            return ResponseEntity.ok(locadoraService.createLocadora(newLocadora));
        }
        catch (Exception e){
            throw new IllegalArgumentException("Erro");
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Locadora>> locadorasList(){
        return ResponseEntity.ok(locadoraService.listaDeLocadoras());
    }

    @PutMapping("/update={updateLocadoraId}")
    public ResponseEntity<String> updateLocadora(@PathVariable Long updateLocadoraId,
                                                       @RequestBody Locadora updateLocadora){

        return ResponseEntity.ok("Locadora "+ updateLocadora.getNome() + " atualizada!");
    }

    @DeleteMapping("/delete={deleteLocadoraId}")
    public ResponseEntity<String> deleteLocadora(@PathVariable Long deleteLocadoraId){

        locadoraService.deleteLocadora(deleteLocadoraId);
        return ResponseEntity.ok("Locadora excluída!");
    }

}
