package max.sofi.pupilife.service;

import max.sofi.pupilife.entity.Testimonio;

public interface TestimonioService {
	public void agregarTestimonio(Testimonio testimonio);
	public void eliminarTestimonio(Long id);
	public void modificarTestimonio(Testimonio testimonio);
	public Testimonio buscarTestimonioById(Long id);
}
