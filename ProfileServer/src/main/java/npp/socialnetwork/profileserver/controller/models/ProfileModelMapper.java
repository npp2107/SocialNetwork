package npp.socialnetwork.profileserver.controller.models;

import npp.socialnetwork.profileserver.DTO.profile.ProfileDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileModelMapper {
    ProfileResponse toModel(ProfileDto ProfileDto);
    ProfileDto toDto(ProfileRequest ProfileDto);
}
