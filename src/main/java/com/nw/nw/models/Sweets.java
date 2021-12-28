package com.nw.nw.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sweets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameSweets;

    private int weightSweets;

    private int sugarSweets;

    public Sweets() {
    }

    public Sweets(String nameSweets, int weightSweets, int sugarSweets) {
        this.nameSweets = nameSweets;
        this.weightSweets = weightSweets;
        this.sugarSweets = sugarSweets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSweets() {
        return nameSweets;
    }

    public void setNameSweets(String nameSweets) {
        this.nameSweets = nameSweets;
    }

    public int getWeightSweets() {
        return weightSweets;
    }

    public void setWeightSweets(int weightSweets) {
        this.weightSweets = weightSweets;
    }

    public int getSugarSweets() {
        return sugarSweets;
    }

    public void setSugarSweets(int sugarSweets) {
        this.sugarSweets = sugarSweets;
    }
}
