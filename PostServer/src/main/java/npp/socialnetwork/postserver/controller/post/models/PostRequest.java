package npp.socialnetwork.postserver.controller.post.models;

import jakarta.validation.constraints.NotNull;
import npp.socialnetwork.postserver.controller.comment.models.CommentRequest;
import java.util.Set;

public class PostRequest {
    @NotNull
    public String content;
    public Long likesCount;

    public Long authorId;
    public Set<CommentRequest> comments;
}
