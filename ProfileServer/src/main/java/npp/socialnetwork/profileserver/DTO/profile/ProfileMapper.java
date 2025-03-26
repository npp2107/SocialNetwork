package npp.socialnetwork.profileserver.DTO.profile;

import npp.socialnetwork.profileserver.repository.ProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileDto toDto(ProfileEntity profileEntity);
    ProfileEntity toEntity(ProfileDto profileDto);

    @Mapping(source = "id", target = "id", ignore = true)
//    @Mapping(source = "createdAt", target = "createdAt", ignore = true)
    void updateExist(ProfileDto profileDto, @MappingTarget ProfileEntity foundEntity);
}
