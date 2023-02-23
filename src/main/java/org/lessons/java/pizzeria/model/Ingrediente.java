package org.lessons.java.pizzeria.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInteger;

	@NotNull(message = "Nome ingrediente non può essere nullo")
	@NotEmpty(message = "Nome ingrediente non può essere vuoto")
	private String name;

	@ManyToMany(mappedBy = "ingredienti")
	private List<Pizza> pizze;

	public Integer getIdInteger() {
		return idInteger;
	}

	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pizza> getPizze() {
		return pizze;
	}

	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}

}
