package br.com.senai.service.usuarioservice;

import br.com.senai.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    //Pesquisar todos usuários
    public List<Usuario> findAll();
    //Pesquisar o usuário pelo ID
    public Optional<Usuario> findById(long id);

    //Novo usuário
    public Usuario createUsuario(Usuario usuario);
    //Editar usuário
    public Usuario updateUsuario(Long id, Usuario updateUsuario);
    //Deletar usuário
    public String deleteUsuario(Long id);

    public Optional<Usuario> read(long id);

    public Usuario save(Usuario usuario);

    public void saveUsuarioInLocadora(Long usuario_id, Long locadora_id);
}
