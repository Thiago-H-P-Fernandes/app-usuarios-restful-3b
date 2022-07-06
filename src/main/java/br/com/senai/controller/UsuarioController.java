package br.com.senai.controller;

import br.com.senai.model.Usuario;
import br.com.senai.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> findById(@PathVariable long id){
        return usuarioService.findById(id);
    }

    @PostMapping("/create")
    public String createUsuario(@RequestBody Usuario usuario){
        try{
            usuarioService.save(usuario);
            return "Usuário criado!";
        }
        catch (Exception e){
            throw new IllegalArgumentException("Erro", e);
        }
    }
}
