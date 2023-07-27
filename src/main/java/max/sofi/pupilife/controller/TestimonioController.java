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

import max.sofi.pupilife.entity.Testimonio;
import max.sofi.pupilife.service.TestimonioService;

@Controller
public class TestimonioController {
	
	@Autowired
	TestimonioService testimonioService;
	
	@GetMapping("/testimonio")
	public String getTestimonio() {
		return "testimonio";
	}
	
	@GetMapping("/nuevo_testimonio")
	public String getNuevoTestimonio(Model model) {
		model.addAttribute("testimonio", new Testimonio());
		return "nuevo_testimonio";
	}
	
	@PostMapping("/nuevo_testimonio")
	public ModelAndView postNuevoTestamento(@Validated @ModelAttribute("testimonio") Testimonio testimonio,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("nuevo_testimonio");
			model.addObject("testimonio", testimonio);
			return model;
		}
		testimonioService.agregarTestimonio(testimonio);
		ModelAndView model = new ModelAndView("redirect:/testimonio");
		return model;
	}
	
	/*@GetMapping("/testimonio")
	public String getTest(Model model) {
		model.addAttribute("testimonio", testimonioService.obtenerTestimonios());
		return "testimonio";
	}*/
	
	
}
