package br.com.senai.service;

import br.com.senai.model.Usuario;
import br.com.senai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(long id, Usuario usuario) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new IllegalArgumentException("Erro");
        }
        usuarioRepository.delete(usuario.get());
    }

    @Override
    public Optional<Usuario> read(long id) {
        return Optional.empty();
    }

    @Override
    public Usuario save(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Erro", e);
        }

    }


//    a
//    @Override
//    public Usuario create(Usuario usuario) {
//        return usuarioRepository.save(usuario);
//    }
//
//    @Override
//    public Usuario update(Long id, Usuario usuario){
//        Optional<Usuario> updatedUsuario = usuarioRepository.findById(id);
//        if (! updatedUsuario.isEmpty() ) {
//            updatedUsuario.get().setNome(usuario.getNome());
//            updatedUsuario.get().setUsername(usuario.getUsername());
//            return usuarioRepository.save(updatedUsuario.get());
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public Optional<Usuario> read(Long id){
//        return usuarioRepository.findById(id);
//    }
//
//    @Override
//    public List<Usuario> findAll(){
//        return usuarioRepository.findAll();
//    }
//
//    @Override
//    public List<Usuario>search(String q, double minPrice, double maxPrice){
//
//        if (!q.equals("")){
//            if (minPrice == 0 && maxPrice == 0){
//                return usuarioRepository.findByNomeContaining(q);
//            } else if (minPrice != 0 && maxPrice != 0){
//                return usuarioRepository.findByUsernameContaining(q);
//            } else {
//                if (minPrice != 0) {
//                    return usuarioRepository.findByNomeContainingOrUsernameContaining(q, q);
//                }
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(Long id) {
//        try {
//            usuarioRepository.deleteById(id);
//            return usuarioRepository.findById(id).isEmpty();
//        } catch (Exception e){
//            return false;
//        }
//    }
}
