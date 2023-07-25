package max.sofi.pupilife.service;

import max.sofi.pupilife.entity.Ingrediente;

public interface IngredienteService {
	public void agregarIngrediente(Ingrediente ingrediente);
	public void eliminarIngrediente(Long id);
	public Ingrediente buscarIngredienteById(Long id);
}
