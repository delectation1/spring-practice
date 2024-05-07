package repositories;

import services.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
