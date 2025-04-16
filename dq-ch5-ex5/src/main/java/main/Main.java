package main;

import main.config.ProjectConfig;
import main.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = c.getBean("CommentService", CommentService.class);
        var cs2 = c.getBean("CommentService", CommentService.class);

        boolean b1 = cs1 == cs2;

        //return false
        System.out.println(b1);

        //This proves that the two instances received when calling the getBean() method are different
    }
}