package npp.socialnetwork.postserver.controller.post.models;

import npp.socialnetwork.postserver.controller.comment.models.CommentResponse;
import java.util.Set;

public class PostResponse {
    public String id;
    public String content;
    public Long likesCount;

    public Long authorId;
    public Set<CommentResponse> comments;
}
