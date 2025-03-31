package main;

import main.model.Comment;
import main.proxies.EmailCommentNotificationProxy;
import main.repositories.DBCommentRepository;
import main.services.CommentService;

public class Main {
    public static void main(String[] args) {
        //Creates the instance for the dependencies
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();

        //Creates the instance of the service class and providing the dependencies
        var commentService = new CommentService(commentRepository, commentNotificationProxy);

        //Creates an instance of comment to send as a parameter to the publishing comment use case
        var comment = new Comment();
        comment.setAuthor("Ignacio");
        comment.setText("Demo comment");

        //Calls the publish comment use case
        commentService.publishComment(comment);

    }
}