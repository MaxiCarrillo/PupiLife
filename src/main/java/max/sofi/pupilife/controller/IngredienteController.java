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

import max.sofi.pupilife.entity.Ingrediente;
import max.sofi.pupilife.service.IngredienteService;
import max.sofi.pupilife.service.UsuarioService;

@Controller
public class IngredienteController {

	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/ingredientes")
	public String getIngredientes(Model model) {
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("ingredientes", ingredienteService.obtenerIngredientes());
			return "ingredientes";
		}
	}
	
	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/registrarIngrediente")
	public String getRegistrarIngrediente(Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "registrar_ingrediente";
	}
	
	/**
	 * @param ingrediente
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/registrarIngrediente")
	public ModelAndView postRegistrarIngrediente(@Validated @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("registrar_ingrediente");
			model.addObject("ingrediente", ingrediente);
			return model;
		}
		ingredienteService.agregarIngrediente(ingrediente);
		ModelAndView model = new ModelAndView("redirect:/ingredientes");
		return model;
	}
	
	@GetMapping("/editarIngrediente/{id}")
	public String getEditarIngrediente(Ingrediente ingrediente, Model model){
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			ingrediente = ingredienteService.buscarIngredienteById(ingrediente.getId());
			model.addAttribute("ingrediente", ingrediente);
			return "registrar_ingrediente";
		}
	}
	
	@GetMapping("/eliminarIngrediente/{id}")
	public String getEliminarUsuario(@PathVariable(value="id")Long id, Model model) {
		ingredienteService.eliminarIngrediente(id);
		return "redirect:/ingredientes";
	}
}
