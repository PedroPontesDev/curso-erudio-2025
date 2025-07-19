package com.curso_erudio.course.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/math")
public class MathController {

	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!isNumeric(numberOne, numberTwo))
			throw new Exception("Error você está iinserindo caracters");

		Double number1 = Double.parseDouble(numberOne);
		Double number2 = Double.parseDouble(numberTwo);

		return number1 + number2;
	}

	private boolean isNumeric(String numberOne, String numberTwo) {
		if (numberOne == null && numberTwo == null || numberOne.isEmpty() && numberTwo.isEmpty())
			return false;
		if (numberOne.matches("[-+]?[0-9]*\\.?[0-9]+") && numberTwo.matches("[-+]?[0-9]*\\.?[0-9]+")) {
			return true;
		}
		return false;

	}
}
