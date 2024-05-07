package proxies;

import services.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}