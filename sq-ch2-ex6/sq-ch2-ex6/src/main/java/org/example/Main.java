package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);

        // getting the representation of the isntance taken from Spring Context
        System.out.println(p);
        // Prints null because it doesn't has a value
        System.out.println(p.getName());


    }
}