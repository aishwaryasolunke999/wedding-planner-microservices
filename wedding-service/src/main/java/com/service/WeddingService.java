package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Couple;
import com.entity.Task;
import com.repository.CoupleRepository;
import com.repository.TaskRepository;

@Service
public class WeddingService {

    @Autowired
    private CoupleRepository coupleRepo;

    @Autowired
    private TaskRepository taskRepo;

    // Create couple
    public Couple createCouple(Couple couple) {
        couple.setUsedBudget(0.0);
        return coupleRepo.save(couple);
    }

    // Add expense
    public void addExpense(Long coupleId, Double amount) {
        Couple c = coupleRepo.findById(coupleId).orElseThrow();
        c.setUsedBudget(c.getUsedBudget() + amount);
        coupleRepo.save(c);
    }

    // Add task
    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    // Complete task
    public Task completeTask(Long id) {
        Task t = taskRepo.findById(id).orElseThrow();
        t.setCompleted(true);
        return taskRepo.save(t);
    }
    
    /*public Double getBudgetLeft(Long id) {

        Couple couple =
                coupleRepo.findById(id).orElseThrow();

        return couple.getTotalBudget()
                - couple.getUsedBudget();
    }
    */
    public Long completedTasks() {

        return taskRepo.countByCompleted(true);
    }
    
    public Double getBudgetLeft(Long id) {

        Couple couple =
                coupleRepo.findById(id).orElseThrow();

        return couple.getTotalBudget()
                - couple.getUsedBudget();
    }
}