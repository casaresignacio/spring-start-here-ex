package service;

import model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment) {
        logger.info("Publishing comment:" + comment.getText());
    }

    //We use custom annotation for the methods we want the aspect to intercept
    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment:" + comment.getText());
    }

    public void editComment (Comment comment) {
        logger.info("Editing comment:" + comment.getText());
    }
}
