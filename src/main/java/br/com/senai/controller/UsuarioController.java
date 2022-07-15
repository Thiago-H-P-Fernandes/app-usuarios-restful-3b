package br.com.senai.controller;

import br.com.senai.id.UsuarioAndLocadoraID;
import br.com.senai.model.Usuario;
import br.com.senai.service.usuarioservice.UsuarioServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
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

    @GetMapping("/read")
    public ResponseEntity<List<Usuario>> usuarioList(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PutMapping("/update={updateUsuarioId}")
    public ResponseEntity<String> updateUsuario(@PathVariable Long updateUsuarioId,
                                             @RequestBody Usuario updateUsuario){
        Usuario updatedUsuario = usuarioService.updateUsuario(updateUsuarioId, updateUsuario);
        return ResponseEntity.ok("Usuario "+ updatedUsuario.getUsername() + " Usuário atualizado!");
    }

    // @PutMapping("/update={updateUsuarioId}")
    // public String updateUsuario(@PathVariable Long updateUsuarioId){
    //     try{
    //         usuarioService.update(id, usuario);
    //         return "Usuário atualizado!";
    //     }
    //     catch (Exception e){
    //         throw new IllegalArgumentException("Erro", e);
    //     }
    // }

    @DeleteMapping("/delete{id}")
    public String  deleteUser(@PathVariable Long id){
        try{
            usuarioService.deleteUsuario(id);
            return "Usuário excluido!";
        }
        catch (Exception e){
            throw new IllegalArgumentException("Erro");
        }

    }

    @PutMapping("/addUsuarioIdLocadora")
    public ResponseEntity<String>
    addUsuarioInLocadora(@RequestBody UsuarioAndLocadoraID usuarioAndLocadoraID){

        usuarioService.saveUsuarioInLocadora(
                usuarioAndLocadoraID.getUsuario_id(),
                usuarioAndLocadoraID.getLocadora_id()
        );

        return ResponseEntity.ok("Sucesso!");

    }


}
