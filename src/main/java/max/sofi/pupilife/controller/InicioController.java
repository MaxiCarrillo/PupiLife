package max.sofi.pupilife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import max.sofi.pupilife.entity.Usuario;
import max.sofi.pupilife.service.UsuarioService;

@Controller
public class InicioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	/**
	 * Peticion GET, permite obtener la vista de inicio.
	 * @param model
	 * @return
	 */
	@GetMapping({"/inicio","/"})
	public String getInicio(Model model){
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			model.addAttribute("login", false);
		}else {
			model.addAttribute("login", true);
		}
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
	
	@GetMapping("/iniciarSesion")
	public String getIniciarSesion() {
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			return "iniciar_sesion";
		}else {
			System.out.println("Ya ha iniciado sesion");
			return "redirect:/inicio";
		}
	}
	
	@PostMapping("/iniciarSesion")
	public ModelAndView postIniciarSesion(@RequestParam String idUser) {
		ModelAndView modelview;
		if(idUser.equals(null) || idUser==""){
			modelview = new ModelAndView("iniciar_sesion");
			modelview.addObject("error", "Ingrese un ID valido.");
	    }else {
	    	Usuario usuario = usuarioService.buscarUsuarioById(Long.parseLong(idUser));
	    	if(usuario!=null){
	    		modelview = new ModelAndView("redirect:/inicio");
	    		usuarioService.iniciarSesion(usuario);
	    	}else {
	    		modelview = new ModelAndView("iniciar_sesion");
	    		modelview.addObject("error", "No existe usuario registrado con tal ID.");
	    	}
	    	
	    }
		return modelview;
	}
	
	@GetMapping("/cerrarSesion")
	public String getCerrarSesion() {
		this.usuarioService.iniciarSesion(new Usuario());
		return "redirect:/inicio";
	}
}
