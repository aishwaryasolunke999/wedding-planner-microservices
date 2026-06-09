package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Couple {

    @Id
    @GeneratedValue
    private Long id;

    private String brideName;
    private String groomName;
    private String weddingDate;
    private Double totalBudget;
    private Double usedBudget;

    // ✅ GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public String getBrideName() {
        return brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    public String getGroomName() {
        return groomName;
    }

    public void setGroomName(String groomName) {
        this.groomName = groomName;
    }

    public String getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(String weddingDate) {
        this.weddingDate = weddingDate;
    }

    public Double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(Double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public Double getUsedBudget() {
        return usedBudget;
    }

    public void setUsedBudget(Double usedBudget) {
        this.usedBudget = usedBudget;
    }
}