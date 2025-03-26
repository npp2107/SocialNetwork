package npp.socialnetwork.postserver.controller.post.models;

import npp.socialnetwork.postserver.dto.post.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostModelMapper {
    PostResponse toModel(PostDto postDto);
    PostDto toDto(PostRequest postRequest);
}
