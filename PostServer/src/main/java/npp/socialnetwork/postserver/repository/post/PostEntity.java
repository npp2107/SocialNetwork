package npp.socialnetwork.postserver.repository.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import npp.socialnetwork.postserver.repository.comment.CommentEntity;

import npp.socialnetwork.postserver.utils.TimeAuditable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Document(value = "post")
public class PostEntity extends TimeAuditable implements Serializable {
    @Id
    private String id;
    private String content;
    private Long likesCount;

    private Long authorId;
    private Set<CommentEntity> comments;
}
