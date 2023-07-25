package max.sofi.pupilife.service;

import org.springframework.stereotype.Service;

import max.sofi.pupilife.entity.IndiceMasaCorporal;

@Service
public interface ImcService {
	void agregarImc(IndiceMasaCorporal indiceMasaCorporal);
	void eliminarImc(Long id);
}
