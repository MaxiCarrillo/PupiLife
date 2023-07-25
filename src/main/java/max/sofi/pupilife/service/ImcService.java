package max.sofi.pupilife.service;

import max.sofi.pupilife.entity.IndiceMasaCorporal;

public interface ImcService {
	void agregarImc(IndiceMasaCorporal indiceMasaCorporal);
	void eliminarImc(Long id);
}
