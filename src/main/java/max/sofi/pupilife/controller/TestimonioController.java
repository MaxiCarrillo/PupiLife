package max.sofi.pupilife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestimonioController {
	@GetMapping("/testimonio")
	public String getTestimonio() {
		return "testimonio";
	}
}
