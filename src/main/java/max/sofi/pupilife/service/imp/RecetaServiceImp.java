package max.sofi.pupilife.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import max.sofi.pupilife.entity.Receta;
import max.sofi.pupilife.repository.RecetaRepository;
import max.sofi.pupilife.service.RecetaService;

public class RecetaServiceImp implements RecetaService {
	
	@Autowired
	RecetaRepository recetaRepository;

	@Override
	public void agregarReceta(Receta receta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarReceta(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarReceta(Receta receta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void buscarRecetaById(Long id) {
		// TODO Auto-generated method stub

	}

}
