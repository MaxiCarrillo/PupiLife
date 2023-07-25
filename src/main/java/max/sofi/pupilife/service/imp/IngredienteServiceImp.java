package max.sofi.pupilife.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import max.sofi.pupilife.entity.Ingrediente;
import max.sofi.pupilife.repository.IngredienteRepository;
import max.sofi.pupilife.service.IngredienteService;

public class IngredienteServiceImp implements IngredienteService {
	
	@Autowired
	IngredienteRepository ingredienteRepository;

	@Override
	public void agregarIngrediente(Ingrediente ingrediente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarIngrediente(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ingrediente buscarIngredienteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
