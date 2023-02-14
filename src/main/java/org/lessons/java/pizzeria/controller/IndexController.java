package org.lessons.java.pizzeria.controller;

import java.util.List;

import org.lessons.java.pizzeria.model.Pizza;
import org.lessons.java.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizze")

public class IndexController {

	@Autowired
	private PizzaRepository pizze;

	@GetMapping
	public String index(Model model) {
		List<Pizza> result = pizze.findAll();
		model.addAttribute("result", result);
		return "index";
	}
}
