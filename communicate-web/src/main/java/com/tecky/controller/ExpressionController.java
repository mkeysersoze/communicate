package com.tecky.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tecky.communicate.entity.Expression;
import com.tecky.communicate.entity.Meaning;
import com.tecky.communicate.repository.ExpressionRepository;

@Controller
@RequestMapping("/expressions")
public class ExpressionController {

	@Inject
	private ExpressionRepository expressionRepository;

	private final static Logger logger = LoggerFactory.getLogger(ExpressionController.class);

	@GetMapping(path = "/form")
	public String showForm(Model model) {
		Expression newExpression = new Expression();
		Meaning meaning = new Meaning();

		model.addAttribute("expression", newExpression);
		model.addAttribute("meaning", meaning);

		return "expressionForm";
	}

	@PostMapping(path = "/processForm")
	public String expressionSubmit(@ModelAttribute Expression expression, @ModelAttribute Meaning meaning) {
		List<Meaning> meanings = new ArrayList<Meaning>();
		meanings.add(meaning);
		expression.setMeanings(meanings);
		expressionRepository.save(expression);
		return "redirect:/expressions";
	}

	@GetMapping
	public String getAllExpressions(Model model) {
		List<Expression> expressionsList = expressionRepository.findAll();
		if (expressionsList != null) {
			model.addAttribute("expressions", expressionsList);
		}
		return "expressionsList";
	}

}
