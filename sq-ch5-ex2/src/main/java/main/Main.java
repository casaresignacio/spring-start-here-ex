package main;

import main.config.ProjectConfig;
import main.services.CommentService;
import main.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //gets the references of the two service beans in the Spring context
        var s1 = c.getBean(CommentService.class);
        var s2 = c.getBean(UserService.class);

        //compares the references for the repository dependency injected by Spring
        boolean b = s1.getCommentRepository() == s2.getCommentRepository();

        System.out.println(b);
    }
}