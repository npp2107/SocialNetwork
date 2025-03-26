package npp.socialnetwork.postserver.dto.post;

import npp.socialnetwork.postserver.repository.post.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDto toDto(PostEntity postEntity);
    PostEntity toEntity(PostDto postDto);

    @Mapping(source = "id", target = "id", ignore = true)
//    @Mapping(source = "createdAt", target = "createdAt", ignore = true)
    void updateExist(PostDto postDto, @MappingTarget PostEntity foundEntity);
}
