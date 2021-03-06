package br.com.senai.service.usuarioservice;

import br.com.senai.model.Locadora;
import br.com.senai.model.Usuario;
import br.com.senai.repository.LocadoraRepository;
import br.com.senai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;
    LocadoraRepository locadoraRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        try{
            Usuario usuario_data = usuarioRepository.findByUsername(usuario.getUsername());
            if (usuario_data != null){
                throw new IllegalArgumentException("Este nome de usuário já está sendo utilizado!");
            }
            return usuarioRepository.save(usuario);
        }catch (Exception e){
            throw new IllegalArgumentException
                    ("Ocorreu um erro durante o cadastro do usuário. Tente novamente!");
        }
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario updateUsuario) {
        Optional<Usuario> usuario_data = usuarioRepository.findById(id);
        if (usuario_data.isEmpty()){
            throw new IllegalArgumentException("Este usuário não está cadastrado!");
        }

        usuario_data.get().setUsername(updateUsuario.getUsername());
        usuario_data.get().setNome(updateUsuario.getNome());
        usuario_data.get().setEmail(updateUsuario.getEmail());
        usuario_data.get().setSenha(updateUsuario.getSenha());
        usuario_data.get().setLocadora(updateUsuario.getLocadora());


        return usuarioRepository.save(usuario_data.get());
    }

    @Override
    public String deleteUsuario(Long id) {
        Optional<Usuario> usuario_data = usuarioRepository.findById(id);
        if (usuario_data.isEmpty()){
            throw new IllegalArgumentException("Este usuário não está cadastrado!");
        }
        usuarioRepository.delete(usuario_data.get());
        return usuario_data.get().getUsername();
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

    @Override
    public void saveUsuarioInLocadora(Long usuario_id, Long locadora_id) {
        Optional<Usuario> usuario_data = usuarioRepository.findById(usuario_id);
        Optional<Locadora> locadora_data = locadoraRepository.findById(locadora_id);

        if (usuario_data.isEmpty() || locadora_data.isEmpty()){
            throw new IllegalArgumentException("Usuário ou Locadora não encontrados!");
        }

        usuario_data.get().setLocadora(locadora_data.get());
        usuarioRepository.save(usuario_data.get());
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
