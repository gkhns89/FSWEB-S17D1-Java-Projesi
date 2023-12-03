package com.s171.spring1start.entity;

import java.util.Objects;

public class Animal {

    private int id;
    private String name;

    private double weight;

    public Animal(int id) {
        this.id = id;
    }

    public Animal(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public boolean equals(Object o, Object object) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;
        return getId() == animal.getId() && Double.compare(getWeight(), animal.getWeight()) == 0 && Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
