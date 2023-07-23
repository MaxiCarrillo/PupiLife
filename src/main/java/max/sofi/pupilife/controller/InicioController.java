package max.sofi.pupilife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import max.sofi.pupilife.entity.Usuario;

@Controller
public class InicioController {
	
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
	
	/**
	 * Peticion GET, devuelve la pagina "not_found" en caso de que la URL no 'exista'.
	 * @return
	 */
	@GetMapping("/*")
	public String getNotFound(){
		return "not_found";
	}
}
