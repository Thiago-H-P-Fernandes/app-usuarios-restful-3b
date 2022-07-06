package br.com.senai.service;

import br.com.senai.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    //Pesquisar todos usuários
    public List<Usuario> findAll();
    //Pesquisar o usuário pelo ID
    public Optional<Usuario> findById(long id);

    //Novo usuário
    public Usuario create(Usuario usuario);
    //Editar usuário
    public Usuario update(long id, Usuario usuario);
    //Deletar usuário
    public void delete(long id);

    public Optional<Usuario> read(long id);

    public Usuario save(Usuario usuario);
}
