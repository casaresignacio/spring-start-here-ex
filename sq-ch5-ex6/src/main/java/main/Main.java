package main;

import main.config.ProjectConfig;
import main.service.CommentService;
import main.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //Gets references from the context for the service beans
        var s1 = c.getBean(CommentService.class);
        var s2 = c.getBean(UserService.class);

        //Compares the references for the injected CommentRepository instances
        //CommentRepository is a prototype bean, the result will be false
        boolean b = s1.getCommentRepository() == s2.getCommentRepository();

        System.out.println(b);
    }
}