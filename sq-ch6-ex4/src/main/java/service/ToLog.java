package service;

//Enables the annotation to be intercepted at tuntime

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//enables the annotation to be intercepted at runtime
@Retention(RetentionPolicy.RUNTIME)
//Restricts this annotation to only be used with methods
@Target(ElementType.METHOD)
public @interface ToLog {
}
