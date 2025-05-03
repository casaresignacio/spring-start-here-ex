package main.services;

import main.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    //To log a message in the app's console every time someone calls the use case
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    //This method defines the use case for our demostration
    public void publishComment(Comment comment) {
        logger.info("Publishing comment:" + comment.getText());
    }
}
