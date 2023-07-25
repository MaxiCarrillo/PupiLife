package max.sofi.pupilife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import max.sofi.pupilife.entity.Receta;
import max.sofi.pupilife.service.RecetaService;

@Controller
public class RecetaController {
	@Autowired
	private RecetaService recetaService;
	
	/**
	 * Método para manejar la solicitud GET en la ruta "/receta".
	 *
	 * @return El nombre de la vista "receta".
	 * @GetMapping Indica que este método maneja solicitudes HTTP GET en la ruta especificada.
	 */
	@GetMapping("/receta")
	public String getReceta() {
		return "receta";
	}
	
	@GetMapping("/receta_nueva")
	public String recetaNueva(Model model) {
		model.addAttribute("receta", new Receta());
		return "receta_nueva";
	}
	
	@PostMapping("/receta_nueva")
	public ModelAndView postRecetaNueva(@Validated @ModelAttribute("receta") Receta receta, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("receta_nueva");
			model.addObject("receta", receta);
			return model;
		}
		recetaService.agregarReceta(receta);
		ModelAndView model = new ModelAndView("redirect:/inicio");
		return model;
	}
	
	
	
}
