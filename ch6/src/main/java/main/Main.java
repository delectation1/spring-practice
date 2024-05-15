package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.Comment;
import services.CommentService;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment();
        comment.setAuthor("Test");
        comment.setText("This is a test");

        CommentService commentService = context.getBean(CommentService.class);
        String status = commentService.publishComment(comment);
        logger.info(status);
    }
}