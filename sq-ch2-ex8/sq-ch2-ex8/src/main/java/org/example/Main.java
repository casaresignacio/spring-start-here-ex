package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //creating an instance to add to Spring context
        Parrot x = new Parrot();

        //define Supplier to return this instance
        Supplier<Parrot> parrotSupplier = () -> x;

        //call the registerBean() method to add the instance to the Spring context
        context.registerBean("parrot1", Parrot.class, parrotSupplier);

        //verify the bean is now in the context
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
    }
}