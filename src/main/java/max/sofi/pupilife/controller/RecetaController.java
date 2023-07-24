package max.sofi.pupilife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecetaController {
	
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
}
