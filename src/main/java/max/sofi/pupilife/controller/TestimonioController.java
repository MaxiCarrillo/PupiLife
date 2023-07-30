package max.sofi.pupilife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import max.sofi.pupilife.entity.Testimonio;
import max.sofi.pupilife.service.TestimonioService;
import max.sofi.pupilife.service.UsuarioService;

@Controller
public class TestimonioController {
	
	@Autowired
	TestimonioService testimonioService;
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/gestion-testimonio")
	public String getTestimonio(Model model) {
		model.addAttribute("testimonio", testimonioService.obtenerTestimonios());
		return "gestion_testimonio";
	}
	
	@GetMapping("/nuevo_testimonio")
	public String getNuevoTestimonio(Model model) {
		model.addAttribute("testimonio", new Testimonio());
		return "nuevo_testimonio";
	}
	
	@PostMapping("/nuevo_testimonio")
	public ModelAndView postNuevoTestamento(@Validated @ModelAttribute("testimonio") Testimonio testimonio,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("nuevo_testimonio");
			model.addObject("testimonio", testimonio);
			return model;
		}
		testimonioService.agregarTestimonio(testimonio);
		ModelAndView model = new ModelAndView("redirect:/gestion-testimonio");
		return model;
	}
	
	@GetMapping("/testimonios")
	public String getTest(Model model) {
		model.addAttribute("testimonio", testimonioService.obtenerTestimonios());
		return "testimonio";
	}
	
	@GetMapping("/eliminarTestimonio/{id}")
	public String getEliminarTestimonio(@PathVariable(value="id")Long id, Model model) {
		testimonioService.eliminarTestimonio(id);
		return "redirect:/gestion-testimonio";
	}
	
	/**
	 * Peticion GET, permite obtener el formulario para editar un usuario en especifico.
	 * @param usuario
	 * @param model
	 * @return
	 */
	@GetMapping("/editarTestimonio/{id}")
	public String getEditarUsuario(Testimonio testimonio, Model model){
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			testimonio = testimonioService.buscarTestimonioById(testimonio.getId());
			model.addAttribute("testimonio", testimonio);
			return "nuevo_testimonio";
		}
		
	}
	
}
