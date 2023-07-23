package max.sofi.pupilife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicioController {
	/**
	 * Método para manejar la solicitud GET en la ruta "/imc".
	 *
	 * @return El nombre de la vista "imc".
	 * @GetMapping Indica que este método maneja solicitudes HTTP GET en la ruta especificada.
	 */

	@GetMapping("/imc")
	public String getIMC() {
		return "imc";
	}
	
	/**
	 * Método para manejar la solicitud GET en la ruta "/peso-ideal".
	 *
	 * @return El nombre de la vista "peso_ideal".
	 * @GetMapping Indica que este método maneja solicitudes HTTP GET en la ruta especificada.
	 */
	@GetMapping("/peso-ideal")
	public String getPesoIdeal() {
		return "peso_ideal";
	}
}
