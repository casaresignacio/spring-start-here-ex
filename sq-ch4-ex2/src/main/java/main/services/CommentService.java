package main.services;

import main.model.Comment;
import main.proxies.CommentNotificationProxy;
import main.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    //defining two dependencies as attributes of the class

    private final CommentRepository commentRepository;

    private final CommentNotificationProxy commentNotificationProxy;

    //provide the dependencies when the object is built through the parameters of the constructor
    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    //implementation the use case that delegates the 'store comment' and 'send the notification' responsibilities to the dependencies
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
