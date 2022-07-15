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

import br.com.senai.id.FilmeAndLocadoraID;
import br.com.senai.model.Filme;
import br.com.senai.service.filmeservice.FilmeServiceImpl;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    FilmeServiceImpl filmeService;

    @PostMapping("/create")
    public ResponseEntity<Filme> createFilme(@RequestBody Filme newFilme){
        try {
            return ResponseEntity.ok(filmeService.createFilme(newFilme));
        }
        catch (Exception e){
            throw new IllegalArgumentException("Ocorreu algum erro!");
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Filme>> locadorasList(){
        return ResponseEntity.ok(filmeService.filmesList());
    }

    @PutMapping("/update={updateFilmeId}")
    public ResponseEntity<String> updateFilme(@PathVariable Long updateFilmeId,
                                                       @RequestBody Filme updateFilme){

        filmeService.updateFilme(updateFilmeId, updateFilme);
        return ResponseEntity.ok("Filme "+ updateFilme.getTitulo()+ " atualizado!");
    }

    @DeleteMapping("/delete={deleteFilmeId}")
    public ResponseEntity<String> deleteFilme(@PathVariable Long deleteFilmeId){

        filmeService.deleteFilme(deleteFilmeId);
        return ResponseEntity.ok("Filme excluído!");
    }

    @PutMapping("/addFilmeInLocadora")
    public ResponseEntity<String>
    filmeInLocadora(@RequestBody FilmeAndLocadoraID filmeAndLocadoraID){

        filmeService.saveFilmeInLocadora(
                filmeAndLocadoraID.getFilme_id(),
                filmeAndLocadoraID.getLocadora_id()
        );

        return ResponseEntity.ok("Sucesso!");

    }




}
