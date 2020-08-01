package com.br.ufal.salvar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PessoaController {
	
	 @Autowired
	 private PessoaService service;
	 
	 @GetMapping("/")
	 public ModelAndView findAll() {
		 ModelAndView mv = new ModelAndView("person");
			mv.addObject("persons", service.findAll());
			
			return mv;
	 }
	 @GetMapping("/save/{name}")
	 public Pessoa save(@PathVariable("name") String name) {
		 Pessoa pessoa = new Pessoa(name);
		 return service.save(pessoa);
	 }
	 

}