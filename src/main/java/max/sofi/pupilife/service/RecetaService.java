package max.sofi.pupilife.service;

import org.springframework.stereotype.Service;

import max.sofi.pupilife.entity.Receta;

@Service
public interface RecetaService {
	public void agregarReceta(Receta receta);
	public void eliminarReceta(Long id);
	public void modificarReceta(Receta receta);
	public void buscarRecetaById(Long id);

}
