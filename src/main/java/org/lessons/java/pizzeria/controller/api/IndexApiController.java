package org.lessons.java.pizzeria.controller.api;

import java.util.List;
import java.util.Optional;

import org.lessons.java.pizzeria.model.Pizza;
import org.lessons.java.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/pizze")
public class IndexApiController {

	@Autowired
	PizzaRepository pizzaRepo;

	@GetMapping()
	public List<Pizza> pizze() {
		return pizzaRepo.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Pizza> show(@PathVariable("id") Integer id) {
		Optional<Pizza> pizza = pizzaRepo.findById(id);
		if (pizza.isPresent()) {
			return new ResponseEntity<Pizza>(pizza.get(), HttpStatus.OK);
		} else
			return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/create")
	public Pizza create(@RequestBody Pizza pizza) {
		return pizzaRepo.save(pizza);
	}

	@PutMapping("{id}")
	public Pizza update(@RequestBody Pizza pizza, @PathVariable("id") Integer id) {
		Pizza pizzaSelected = pizzaRepo.getReferenceById(id);
		return pizzaRepo.save(pizza);
	}
}