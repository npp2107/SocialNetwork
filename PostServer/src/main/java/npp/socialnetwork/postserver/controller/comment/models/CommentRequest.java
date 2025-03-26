package npp.socialnetwork.postserver.controller.comment.models;

import jakarta.validation.constraints.NotNull;

public class CommentRequest {
    @NotNull
    public String content;
    @NotNull
    public Long authorId;
    public Long likesCount;
}
