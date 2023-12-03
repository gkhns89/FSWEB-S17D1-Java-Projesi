package com.s171.spring1start.validation;

import com.s171.spring1start.entity.Animal;

import java.util.Map;

public class AnimalValidation {

    public static boolean isAnimalIdValid(int id){

        return !(id<0);

    }
    public static boolean isAnimalIdExist(Map<Integer, Animal>animalMap, int id){

        return animalMap.containsKey(id);

    }
    public static boolean isAnimalValuesFullEntered (Animal animal){
        return !(animal.getId() <= 0||
                animal.getName() == null||
                animal.getName().isEmpty()||
                animal.getWeight() <= 0 );
    }

}
