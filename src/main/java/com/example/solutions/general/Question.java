package com.example.solutions.general;

import java.util.Arrays;
//Parent class
class Animal {
 void eat() {
     System.out.println("Animal is eating");
 }
}

//Child class inheriting from Animal
class Dog extends Animal {
 void bark() {
     System.out.println("Dog is barking");
 }
}

public class Question {
 public static void main(String[] args) {
     // Creating an object of Dog class
     Dog dog = new Dog();
     
     // Calling methods from both parent and child class
     dog.eat();  // This method is inherited from the Animal class
     dog.bark(); // This method is specific to the Dog class
 }
}
