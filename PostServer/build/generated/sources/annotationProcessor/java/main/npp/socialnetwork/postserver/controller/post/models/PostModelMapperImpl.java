package npp.socialnetwork.postserver.controller.post.models;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import npp.socialnetwork.postserver.controller.comment.models.CommentRequest;
import npp.socialnetwork.postserver.controller.comment.models.CommentResponse;
import npp.socialnetwork.postserver.dto.comment.CommentDto;
import npp.socialnetwork.postserver.dto.post.PostDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-26T13:23:06+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class PostModelMapperImpl implements PostModelMapper {

    @Override
    public PostResponse toModel(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        PostResponse postResponse = new PostResponse();

        postResponse.id = postDto.id;
        postResponse.content = postDto.content;
        postResponse.likesCount = postDto.likesCount;
        postResponse.authorId = postDto.authorId;
        postResponse.comments = commentDtoSetToCommentResponseSet( postDto.comments );

        return postResponse;
    }

    @Override
    public PostDto toDto(PostRequest postRequest) {
        if ( postRequest == null ) {
            return null;
        }

        PostDto.PostDtoBuilder postDto = PostDto.builder();

        postDto.content( postRequest.content );
        postDto.likesCount( postRequest.likesCount );
        postDto.authorId( postRequest.authorId );
        postDto.comments( commentRequestSetToCommentDtoSet( postRequest.comments ) );

        return postDto.build();
    }

    protected CommentResponse commentDtoToCommentResponse(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        CommentResponse commentResponse = new CommentResponse();

        commentResponse.id = commentDto.id;
        commentResponse.content = commentDto.content;
        commentResponse.authorId = commentDto.authorId;
        commentResponse.likesCount = commentDto.likesCount;

        return commentResponse;
    }

    protected Set<CommentResponse> commentDtoSetToCommentResponseSet(Set<CommentDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<CommentResponse> set1 = new LinkedHashSet<CommentResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CommentDto commentDto : set ) {
            set1.add( commentDtoToCommentResponse( commentDto ) );
        }

        return set1;
    }

    protected CommentDto commentRequestToCommentDto(CommentRequest commentRequest) {
        if ( commentRequest == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.content = commentRequest.content;
        commentDto.authorId = commentRequest.authorId;
        commentDto.likesCount = commentRequest.likesCount;

        return commentDto;
    }

    protected Set<CommentDto> commentRequestSetToCommentDtoSet(Set<CommentRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<CommentDto> set1 = new LinkedHashSet<CommentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CommentRequest commentRequest : set ) {
            set1.add( commentRequestToCommentDto( commentRequest ) );
        }

        return set1;
    }
}
