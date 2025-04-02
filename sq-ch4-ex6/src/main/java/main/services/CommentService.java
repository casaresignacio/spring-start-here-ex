package main.services;

import main.model.Comment;
import main.proxies.CommentNotificationProxy;
import main.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //define this object as a component with service responsibility
public class CommentService {

    //defining two dependencies as attributes of the class
    private final CommentRepository commentRepository;

    private final CommentNotificationProxy commentNotificationProxy;

    //provide the dependencies when the object is built through the parameters of the constructor
    //using in parameter the Qualifier what we want
    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    //implementation the use case that delegates the 'store comment' and 'send the notification' responsibilities to the dependencies
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
