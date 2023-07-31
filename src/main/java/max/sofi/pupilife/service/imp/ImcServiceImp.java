package max.sofi.pupilife.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import max.sofi.pupilife.entity.IndiceMasaCorporal;
import max.sofi.pupilife.repository.ImcRepository;
import max.sofi.pupilife.service.ImcService;

@Service
public class ImcServiceImp implements ImcService {
	
	@Autowired
	ImcRepository imcRepository;

	@Override
	public void agregarImc(IndiceMasaCorporal indiceMasaCorporal) {
		imcRepository.save(indiceMasaCorporal);
	}

	@Override
	public void eliminarImc(Long id) {
		imcRepository.deleteById(id);
	}

}
