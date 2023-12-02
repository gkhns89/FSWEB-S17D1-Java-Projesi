package com.s171.spring1start.controller;

import com.s171.spring1start.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private Map<Integer,Animal> animals;
    @PostConstruct
    public void init (){

        animals = new HashMap<>();

        System.out.println("Blabla1");
    }

    public AnimalController(){

        System.out.println("Blablaa2");

    }
    @GetMapping("/")
    public List<Animal> findAll(){

        System.out.println("Get animals!");

        return animals.values().stream().toList();

    }

    @GetMapping("/{id}")
    public Animal find(@PathVariable int id){
        return animals.get(id);
    }

   @PostMapping("/")
   public Animal save(@RequestBody Animal animal){

        animals.put(animal.getId(),animal);
        return animals.get(animal.getId());

   }

   @PutMapping("/{id}")
    public Animal edit(@PathVariable int id, @RequestBody Animal animal){

        animals.put(id, animal);
        return animals.get(id);

   }

   @DeleteMapping("/{id}")
    public Animal delete(@PathVariable int id){
       System.out.println(animals.get(id).getName() + " silindi!");
        return animals.remove(id);

   }

}
