package max.sofi.pupilife.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import max.sofi.pupilife.entity.Testimonio;
import max.sofi.pupilife.repository.TestimonioRepository;
import max.sofi.pupilife.service.TestimonioService;

@Service
public class TestimonioServiceImp implements TestimonioService {

	@Autowired
	TestimonioRepository testimonioRepository;
	
	@Override
	public void agregarTestimonio(Testimonio testimonio) {
		// TODO Auto-generated method stub
		testimonioRepository.save(testimonio);
	}

	@Override
	public void eliminarTestimonio(Long id) {
		// TODO Auto-generated method stub
		testimonioRepository.deleteById(id);
	}

	@Override
	public void modificarTestimonio(Testimonio testimonio) {
		// TODO Auto-generated method stub
		testimonioRepository.save(testimonio);
	}

	@Override
	public Testimonio buscarTestimonioById(Long id) {
		// TODO Auto-generated method stub
		Optional<Testimonio> testimonio = testimonioRepository.findById(id);
		return testimonio.orElse(null);
	}
	
	
}
