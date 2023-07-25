package max.sofi.pupilife.service;

import max.sofi.pupilife.entity.Usuario;

public interface UsuarioService {

	public void agregarUsuario(Usuario usuario);
	public void eliminarUsuario(Long id);
	public void modificarUsuario(Usuario usuario);
	public Usuario buscarUsuarioById(Long id);
}
