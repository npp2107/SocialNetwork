package npp.socialnetwork.profileserver.controller.profile.models;

import npp.socialnetwork.profileserver.dto.profile.ProfileDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileModelMapper {
    ProfileResponse toModel(ProfileDto ProfileDto);
    ProfileDto toDto(ProfileRequest ProfileDto);
}
