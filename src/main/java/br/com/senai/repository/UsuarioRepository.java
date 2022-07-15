package br.com.senai.repository;

import br.com.senai.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findById(long id);

    public Usuario findByUsername(String username);

    public List<Usuario> findByNomeContaining(String qNome);
    public List<Usuario> findByUsernameContaining(String qUsername);
    public List<Usuario> findByNomeContainingOrUsernameContaining(String qNome, String qUsername);

}
