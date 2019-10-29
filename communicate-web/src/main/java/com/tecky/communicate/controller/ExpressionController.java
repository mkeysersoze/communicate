package com.tecky.communicate.controller;

import com.tecky.communicate.entity.Expression;
import com.tecky.communicate.repository.ExpressionRepository;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Expression API"})
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "${rest-resources.resource.expressions}")
public class ExpressionController {

    private final static Logger logger = LoggerFactory.getLogger(ExpressionController.class);
    @Autowired
    private ExpressionRepository expressionRepository;

    @GetMapping
    public List<Expression> findAll() {
        return expressionRepository.findAll();
    }

    @PostMapping
    void addUser(@RequestBody Expression expression) {
        expressionRepository.save(expression);
    }
}