package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Couple;
import com.entity.Task;
import com.service.WeddingService;

@RestController
@RequestMapping("/wedding")
public class WeddingController {

    @Autowired
    private WeddingService service;

    @PostMapping("/create")
    public Couple create(@RequestBody Couple couple) {
        return service.createCouple(couple);
    }

    @PostMapping("/expense/{id}")
    public String addExpense(@PathVariable Long id,
                             @RequestParam Double amount) {
        service.addExpense(id, amount);
        return "Expense Added";
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @PutMapping("/task/{id}")
    public Task complete(@PathVariable Long id) {
        return service.completeTask(id);
    
    }
    
    @GetMapping("/budget-left/{id}")
    public Double budgetLeft(@PathVariable Long id) {
        return service.getBudgetLeft(id);
    }
    
    @GetMapping("/tasks/completed")
    public Long completedTasks() {
        return service.completedTasks();
    }
    
 

        @GetMapping("/dashboard/{coupleId}")
        public String dashboard(
                @PathVariable Long coupleId) {

            Double budget =
                    service.getBudgetLeft(coupleId);

            return "Budget Left : ₹" + budget;
        }
    }
