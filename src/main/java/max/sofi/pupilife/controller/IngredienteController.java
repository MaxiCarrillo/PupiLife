package max.sofi.pupilife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import max.sofi.pupilife.entity.Ingrediente;

@Controller
public class IngredienteController {

	@GetMapping("/ingredientes")
	public String getIngredientes(Model model) {
		return "ingredientes";
	}
	
	@GetMapping("/registrarIngrediente")
	public String getRegistrarIngrediente(Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "registrar_ingrediente";
	}
	
	@PostMapping("/registrarIngrediente")
	public ModelAndView postRegistrarIngrediente(@Validated @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("registrar_ingrediente");
			model.addObject("ingrediente", ingrediente);
			return model;
		}
		
		ModelAndView model = new ModelAndView("redirect:/ingredientes");
		return model;
	}
	
}
