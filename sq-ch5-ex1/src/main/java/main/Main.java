package main;

import main.config.ProjectConfig;
import main.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = c.getBean("commentService", CommentService.class);
        var cs2 = c.getBean("commentService", CommentService.class);

        //Because the two variables hold the same reference, the result is true!
        boolean b1 = cs1 == cs2;

        System.out.println(b1);
    }
}