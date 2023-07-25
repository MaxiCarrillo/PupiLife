package max.sofi.pupilife.service;

import org.springframework.stereotype.Service;

import max.sofi.pupilife.entity.Ingrediente;

@Service
public interface IngredienteService {
	public void agregarIngrediente(Ingrediente ingrediente);
	public void eliminarIngrediente(Long id);
	public Ingrediente buscarIngredienteById(Long id);
}
