package main;

import main.config.ProjectConfig;
import main.model.Comment;
import main.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
        //gets the CommentService bean from the context
        var service = c.getBean(CommentService.class);

        //Creates a Comment instance to give as a parameter to the publishComment method
        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Natasha");

        //call the publishComment method
        service.publishComment(comment);

    }
}