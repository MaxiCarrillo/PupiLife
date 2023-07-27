package max.sofi.pupilife.service;

import java.util.List;

import max.sofi.pupilife.entity.Testimonio;

public interface TestimonioService {
	public void agregarTestimonio(Testimonio testimonio);
	public void eliminarTestimonio(Long id);
	public void modificarTestimonio(Testimonio testimonio);
	public Testimonio buscarTestimonioById(Long id);
	public List<Testimonio> obtenerTestimonios();
}
