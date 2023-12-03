package com.s171.spring1start.controller;

import com.s171.spring1start.dto.AnimalResponse;
import com.s171.spring1start.entity.Animal;
import com.s171.spring1start.validation.AnimalValidation;
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
    public AnimalResponse find(@PathVariable int id){
        if(!AnimalValidation.isAnimalIdValid(id)){
            return new AnimalResponse(null,"Animal id is not valid: " + id,400);
        }
        if(!AnimalValidation.isAnimalIdExist(animals,id)){
            return new AnimalResponse(null,"Animal with given id is not exist: " + id,400);
        }
        return new AnimalResponse(animals.get(id).getName(),"Success", 200);
    }

   @PostMapping("/")
   public AnimalResponse save(@RequestBody Animal animal){

       if(!AnimalValidation.isAnimalValuesFullEntered(animal)){
           return new AnimalResponse(null,"Animal Credentials are not valid: ", 400);
       }
       animals.put(animal.getId(),animal);
       return new AnimalResponse(animals.get(animal.getId()).getName(), "success",200);
   }

   @PutMapping("/{id}")
    public AnimalResponse edit(@PathVariable int id, @RequestBody Animal animal){

        animal.setId(id);

       if(!AnimalValidation.isAnimalIdValid(id)){
           return new AnimalResponse(null,"Animal Id is not valid", 400);
       }
       if(!AnimalValidation.isAnimalIdExist(animals,id)){
           return new AnimalResponse(null,"Animal with given id is not exist",400);
       }
       if(!AnimalValidation.isAnimalValuesFullEntered(animal)){
           return new AnimalResponse(null,"All of the Animal credential must given",400);
       }
       animals.put(id, new Animal(animal.getId(), animal.getName(), animal.getWeight()));

       return new AnimalResponse(animals.get(id).getName(), "success!",200);
   }

   @DeleteMapping("/{id}")
    public Animal delete(@PathVariable int id){

       System.out.println(animals.get(id).getName() + " silindi!");
        return animals.remove(id);

   }

}
