package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        //create an instance of the Spring context
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //Gets a reference to the Person bean from the Spring context
        Person person = context.getBean(Person.class);

        //Gets a reference to the Parrot bean from the Spring context
        Parrot parrot = context.getBean(Parrot.class);

        //Prints the person's name to prove that the Person bean is in the context
        System.out.println("Person's name: " + person.getName());

        //Prints the parrot's name to prove that the Parrot bean is in the context
        System.out.println("Parrot's name: " + parrot.getName());

        //Prints the person's parrot to prove that there's not yet a relationship between the instances
        System.out.println("Person's parrot: " + person.getParrot());
    }
}