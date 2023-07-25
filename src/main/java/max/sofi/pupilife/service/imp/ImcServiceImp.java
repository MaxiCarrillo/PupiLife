package max.sofi.pupilife.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import max.sofi.pupilife.entity.IndiceMasaCorporal;
import max.sofi.pupilife.repository.ImcRepository;
import max.sofi.pupilife.service.ImcService;

public class ImcServiceImp implements ImcService {
	
	@Autowired
	ImcRepository imcRepository;

	@Override
	public void agregarImc(IndiceMasaCorporal indiceMasaCorporal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarImc(Long id) {
		// TODO Auto-generated method stub

	}

}
