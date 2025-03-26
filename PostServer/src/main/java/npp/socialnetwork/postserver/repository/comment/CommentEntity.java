package npp.socialnetwork.postserver.repository.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import npp.socialnetwork.postserver.utils.TimeAuditable;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CommentEntity extends TimeAuditable implements Serializable {
    private String id;
    private String content;
    private Long authorId;
    private Long likesCount;
}
