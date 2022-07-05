package br.com.senai.repository;

import br.com.senai.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    public List<Usuario> findById(id);

    public List<Usuario> findByNomeContaining(String qNome);
    public List<Usuario> findByUsernameContaining(String qUsername);
    public List<Usuario> findByNomeContainingOrUsernameContaining(String qNome, String qUsername);

}
