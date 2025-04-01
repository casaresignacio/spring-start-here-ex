package main;

import main.config.ProjectConfiguration;
import main.model.Comment;
import main.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var comment = new Comment();
        comment.setAuthor("Ignacio");
        comment.setText("Demo Comment");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

    }
}