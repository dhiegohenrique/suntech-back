package br.com.suntech.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/", method=RequestMethod.GET)
@CrossOrigin(origins = {"http://localhost:3001", "https://suntech-front.herokuapp.com"})
public class IndexController {

	public void users() {
		System.err.println("entrou aqui");
	}
}