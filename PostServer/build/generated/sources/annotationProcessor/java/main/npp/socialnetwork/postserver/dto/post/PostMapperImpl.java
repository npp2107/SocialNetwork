package npp.socialnetwork.postserver.dto.post;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import npp.socialnetwork.postserver.dto.comment.CommentDto;
import npp.socialnetwork.postserver.repository.comment.CommentEntity;
import npp.socialnetwork.postserver.repository.post.PostEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-26T13:23:06+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDto toDto(PostEntity postEntity) {
        if ( postEntity == null ) {
            return null;
        }

        PostDto.PostDtoBuilder postDto = PostDto.builder();

        postDto.id( postEntity.getId() );
        postDto.content( postEntity.getContent() );
        postDto.likesCount( postEntity.getLikesCount() );
        postDto.authorId( postEntity.getAuthorId() );
        postDto.comments( commentEntitySetToCommentDtoSet( postEntity.getComments() ) );

        return postDto.build();
    }

    @Override
    public PostEntity toEntity(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        PostEntity postEntity = new PostEntity();

        postEntity.setId( postDto.id );
        postEntity.setContent( postDto.content );
        postEntity.setLikesCount( postDto.likesCount );
        postEntity.setAuthorId( postDto.authorId );
        postEntity.setComments( commentDtoSetToCommentEntitySet( postDto.comments ) );

        return postEntity;
    }

    @Override
    public void updateExist(PostDto postDto, PostEntity foundEntity) {
        if ( postDto == null ) {
            return;
        }

        foundEntity.setContent( postDto.content );
        foundEntity.setLikesCount( postDto.likesCount );
        foundEntity.setAuthorId( postDto.authorId );
        if ( foundEntity.getComments() != null ) {
            Set<CommentEntity> set = commentDtoSetToCommentEntitySet( postDto.comments );
            if ( set != null ) {
                foundEntity.getComments().clear();
                foundEntity.getComments().addAll( set );
            }
            else {
                foundEntity.setComments( null );
            }
        }
        else {
            Set<CommentEntity> set = commentDtoSetToCommentEntitySet( postDto.comments );
            if ( set != null ) {
                foundEntity.setComments( set );
            }
        }
    }

    protected CommentDto commentEntityToCommentDto(CommentEntity commentEntity) {
        if ( commentEntity == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.id = commentEntity.getId();
        commentDto.content = commentEntity.getContent();
        commentDto.authorId = commentEntity.getAuthorId();
        commentDto.likesCount = commentEntity.getLikesCount();

        return commentDto;
    }

    protected Set<CommentDto> commentEntitySetToCommentDtoSet(Set<CommentEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<CommentDto> set1 = new LinkedHashSet<CommentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CommentEntity commentEntity : set ) {
            set1.add( commentEntityToCommentDto( commentEntity ) );
        }

        return set1;
    }

    protected CommentEntity commentDtoToCommentEntity(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setId( commentDto.id );
        commentEntity.setContent( commentDto.content );
        commentEntity.setAuthorId( commentDto.authorId );
        commentEntity.setLikesCount( commentDto.likesCount );

        return commentEntity;
    }

    protected Set<CommentEntity> commentDtoSetToCommentEntitySet(Set<CommentDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<CommentEntity> set1 = new LinkedHashSet<CommentEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CommentDto commentDto : set ) {
            set1.add( commentDtoToCommentEntity( commentDto ) );
        }

        return set1;
    }
}
