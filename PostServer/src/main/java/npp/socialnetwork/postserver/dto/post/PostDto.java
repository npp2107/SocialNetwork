package npp.socialnetwork.postserver.dto.post;

import lombok.Builder;
import npp.socialnetwork.postserver.dto.comment.CommentDto;

import java.util.Set;

@Builder
public class PostDto {
    public String id;
    public String content;
    public Long likesCount;

    public Long authorId;
    public Set<CommentDto> comments;

}
