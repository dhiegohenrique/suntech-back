package br.com.suntech.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@CrossOrigin(origins = {"http://localhost:3001", "https://suntech-front.herokuapp.com"})
@ApiIgnore
public class IndexController {

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("redirect:swagger-ui.html");
	}
}