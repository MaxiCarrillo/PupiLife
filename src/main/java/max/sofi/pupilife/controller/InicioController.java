package max.sofi.pupilife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	
	/**
	 * GET - Peticion GET, permite obtener la vista de inicio.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/inicio")
	public String getInicio(){
		return "index";
	}
}
