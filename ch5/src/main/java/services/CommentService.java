package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import processors.CommentProcessor;
import proxies.*;
import repositories.*;

@Service
@Lazy
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    public CommentService(
            CommentRepository commentRepository,
            @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;

        System.out.println("Comment Service instance created");
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }

    public void sendComment(Comment comment) {
        CommentProcessor processor = new CommentProcessor();

        // as the processor instance changes -> needs to  be mutable , prototype

        processor.setComment(comment);
        processor.processComment(comment);
        processor.validateComment(comment);
        comment = processor.getComment();

    }
}