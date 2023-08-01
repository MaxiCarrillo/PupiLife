package max.sofi.pupilife.service;

import java.util.List;

import max.sofi.pupilife.entity.IndiceMasaCorporal;
import max.sofi.pupilife.entity.Usuario;

public interface ImcService {
	void agregarImc(IndiceMasaCorporal indiceMasaCorporal);
	void eliminarImc(Long id);
	public List<IndiceMasaCorporal> obtenerImcByUsuario(Usuario usuario);
}
