package max.sofi.pupilife.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import max.sofi.pupilife.entity.Receta;
import max.sofi.pupilife.repository.RecetaRepository;
import max.sofi.pupilife.service.RecetaService;

@Service
public class RecetaServiceImp implements RecetaService {
	
	@Autowired
	RecetaRepository recetaRepository;

	@Override
	public void agregarReceta(Receta receta) {
		recetaRepository.save(receta);
	}

	@Override
	public void eliminarReceta(Long id) {
		recetaRepository.deleteById(id);

	}

	@Override
	public void modificarReceta(Receta receta) {
		recetaRepository.save(receta);
	}

	@Override
	public void buscarRecetaById(Long id) {
		// TODO Auto-generated method stub

	}

}
