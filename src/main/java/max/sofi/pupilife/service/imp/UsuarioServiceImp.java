package max.sofi.pupilife.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import max.sofi.pupilife.entity.Usuario;
import max.sofi.pupilife.repository.UsuarioRepository;
import java.util.List;
import max.sofi.pupilife.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	Usuario usuarioSesion;
	
	@Override
	public void agregarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscarUsuarioById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}

	@Override
	public List<Usuario> obtenerUsuarios(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	@Override
	public Usuario obtenerSesionUsuario() {
		return this.usuarioSesion;
	}
	
	@Override
	public void iniciarSesion(Usuario usuario) {
		this.usuarioSesion = usuario;
	}
}
