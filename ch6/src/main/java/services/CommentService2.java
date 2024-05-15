package services;

import interfaces.ToLog;
import org.springframework.stereotype.Service;
import services.Comment;

import java.util.logging.Logger;

@Service
public class CommentService2 {
    private Logger logger = Logger.getLogger(CommentService2.class.getName());

    public void publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
    }

    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment:" + comment.getText());
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment" + comment.getText());
    }
}