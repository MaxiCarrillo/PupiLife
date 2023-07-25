package max.sofi.pupilife.service;

import max.sofi.pupilife.entity.Receta;

public interface RecetaService {
	public void agregarReceta(Receta receta);
	public void eliminarReceta(Long id);
	public void modificarReceta(Receta receta);
	public void buscarRecetaById(Long id);

}
