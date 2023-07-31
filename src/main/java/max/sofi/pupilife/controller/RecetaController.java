package max.sofi.pupilife.controller;

import java.util.List;

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
import max.sofi.pupilife.entity.Receta;
import max.sofi.pupilife.service.IngredienteService;
import max.sofi.pupilife.service.RecetaService;
import max.sofi.pupilife.service.UsuarioService;

@Controller
public class RecetaController {
	@Autowired
	private RecetaService recetaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	/**
	 * Método para manejar la solicitud GET en la ruta "/receta".
	 *
	 * @return El nombre de la vista "receta".
	 * @GetMapping Indica que este método maneja solicitudes HTTP GET en la ruta especificada.
	 */
	@GetMapping("/receta")
	public String getObtenerRecetas(Model model) {
		model.addAttribute("login", false);
		if(this.usuarioService.obtenerSesionUsuario().getId()!=null) {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
		}
		model.addAttribute("receta",recetaService.obtenerRecetas());
		return "receta";
	}
	
	@GetMapping("/receta_nueva")
	public String recetaNueva(Model model) {
		List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientes();
		model.addAttribute("ingredientes", ingredientes);
		model.addAttribute("receta", new Receta());
		return "receta_nueva";
	}
	
	@PostMapping("/receta_nueva")
	public ModelAndView postRecetaNueva(@Validated @ModelAttribute("receta") Receta receta, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("receta_nueva");
			List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientes();
			model.addObject("ingredientes", ingredientes);
			model.addObject("receta", receta);
			return model;
		}
		recetaService.agregarReceta(receta);
		ModelAndView model = new ModelAndView("redirect:/receta");
		return model;
	}
	
	@GetMapping("/gestion-receta")
	public String getReceta(Model model) {
		if(this.usuarioService.obtenerSesionUsuario().getAdmin()==false) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			model.addAttribute("recetas", recetaService.obtenerRecetas());
			return "gestion_receta";
		}
	}
	
	@GetMapping("/eliminarReceta/{id}")
	public String getEliminarReceta(@PathVariable(value="id")Long id, Model model) {
		recetaService.eliminarReceta(id);
		return "redirect:/gestion-receta";
	}
	
	/**
	 * Peticion GET, permite obtener el formulario para editar un testimonio en especifico.
	 * @param testimonio
	 * @param model
	 * @return
	 */
	@GetMapping("/editarReceta/{id}")
	public String getEditarUsuario(Receta receta, Model model){
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			receta = recetaService.buscarRecetaById(receta.getId());
			List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientes();
			model.addAttribute("ingredientes", ingredientes);
			model.addAttribute("receta", receta);
			return "receta_nueva";
		}
		
	}
}
