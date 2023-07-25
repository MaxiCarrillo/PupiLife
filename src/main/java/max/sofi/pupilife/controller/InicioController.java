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

import max.sofi.pupilife.entity.Usuario;
import max.sofi.pupilife.service.UsuarioService;

@Controller
public class InicioController {
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Peticion GET, permite obtener la vista de inicio.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping({"/inicio","/"})
	public String getInicio(){
		return "index";
	}
	
	/**
	 * Peticion GET, permite obtener el formulario para el registro de un usuario.
	 * @param model
	 * @return
	 */
	@GetMapping("/registrarUsuario")
	public String getRegistrarUsuario(Model model){
		model.addAttribute("usuario", new Usuario());
		return "registrar_usuario";
	}
	
	@PostMapping("/registrarUsuario")
	public ModelAndView postRegistrarUsuario(@Validated @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("registrar_usuario");
			model.addObject("usuario", usuario);
			return model;
		}
		usuarioService.agregarUsuario(usuario);
		ModelAndView model = new ModelAndView("redirect:/inicio");
		return model;
	}
	
	/**
	 * Peticion GET, devuelve la pagina "not_found" en caso de que la URL no 'exista'.
	 * @return
	 */
	@GetMapping("/*")
	public String getNotFound(){
		return "not_found";
	}
}
