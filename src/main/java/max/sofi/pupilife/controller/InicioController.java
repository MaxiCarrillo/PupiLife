package max.sofi.pupilife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	
	
	/**
	 * Peticion GET, permite obtener la vista de inicio.
	 * @param model
	 * @return
	 */
	@GetMapping({"/inicio","/"})
	public String getInicio(){
		return "index";
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
