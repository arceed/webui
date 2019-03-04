package com.grokonez.spring.restapi.mysql.controller;

import com.grokonez.spring.restapi.mysql.model.*;
import com.grokonez.spring.restapi.mysql.repo.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RuleController {

    @Autowired
    RuleRepository repository;

    @GetMapping("/rules")
    public List<RuleTree> getAllRules() {
        System.out.println("Get all rules...");

        List<RuleTree> rules = new ArrayList<>();
        repository.findAll().forEach(rules::add);

        rules.forEach(e -> System.out.println(e));

        return rules;
    }


    //load name, one load will have 32 columns
    @GetMapping("rules/{name}")
    public List<RuleTree> findByAge(@PathVariable String name) {
        List<RuleTree> rules = repository.findByName(name);
        return rules;
    }


    @PostMapping("/rule")
    public RuleTree postRule(@RequestBody RuleTree rule) {

       // RuleTree _customer = repository.save(new RuleTree(rule.getName(), rule.getAge()));

        RuleTree _rule = new RuleTree();

        _rule.setName(rule.getName());
        _rule.setAlias(rule.getAlias());
        _rule.setColumn(rule.getColumn());

        RuleTree ruleTree = repository.save(_rule);

        return ruleTree;
    }

    @PutMapping("/rule/{id}")
    public ResponseEntity<RuleTree> updateRule(@PathVariable("id") long id, @RequestBody RuleTree rule) {
        System.out.println("Update RuleTree with ID = " + id + "...");

        //to update a rule
        Optional<RuleTree> ruleDate = repository.findById(id);

        if (ruleDate.isPresent()) {
            RuleTree _rule = ruleDate.get();

            _rule.setName(rule.getName());
            _rule.setAlias(rule.getAlias());
            _rule.setColumn(rule.getColumn());

            return new ResponseEntity<>(repository.save(_rule), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/rule/{id}")
    public ResponseEntity<String> deleteRule(@PathVariable("id") long id) {
        System.out.println("Delete RuleTree with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("RuleTree has been deleted!", HttpStatus.OK);
    }


}
