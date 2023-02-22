package org.lessons.java.pizzeria.controller;

import org.lessons.java.pizzeria.model.Offerta;
import org.lessons.java.pizzeria.model.Pizza;
import org.lessons.java.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/offerte")
public class OffertaController {

	@Autowired
	PizzaRepository pizzaRepository;

	@GetMapping("/create")
	public String create(@RequestParam(name = "pizzaId", required = true) Integer pizzaId, Model model) {

		Offerta offerta = new Offerta();

		Pizza pizza = pizzaRepository.getReferenceById(pizzaId);
		offerta.setPizza(pizza);

		model.addAttribute("offerta", offerta);

		return ("offerte/createOfferte");
	}
}
