package npp.socialnetwork.profileserver.service.profile;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import npp.socialnetwork.profileserver.DTO.profile.ProfileDto;
import npp.socialnetwork.profileserver.DTO.profile.ProfileId;
import npp.socialnetwork.profileserver.DTO.profile.ProfileMapper;
import npp.socialnetwork.profileserver.repository.ProfileEntity;
import npp.socialnetwork.profileserver.repository.ProfileRepository;
import npp.socialnetwork.profileserver.exception.MyResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileCommandService {
    @NonNull
    final ProfileRepository profileRepository;
    @NonNull
    final ProfileMapper profileMapper;

    public ProfileDto save(ProfileDto profileDto) {
        ProfileEntity profileEntity = profileMapper.toEntity(profileDto);
        profileRepository.save(profileEntity);
        return profileMapper.toDto(profileEntity);
    }

    public void delete(ProfileId id) {
        profileRepository.deleteById(id.id());
    }

    public void update(ProfileId profileId, ProfileDto profileDto) {
        ProfileEntity foundEntity = profileRepository.findById(profileId.id()).orElseThrow(MyResourceNotFoundException::new);
        profileMapper.updateExist(profileDto, foundEntity);
        profileRepository.save(foundEntity);
    }
//    public void updateIsDeleted(ProfileId profileId, Boolean isDeleted) {
//        ProfileEntity foundEntity = profileRepository.findById(profileId.id()).orElseThrow(MyResourceNotFoundException::new);
//        foundEntity.setIsDeleted(isDeleted);
//        foundEntity.setIsActive(isActive);
//        profileRepository.save(foundEntity);
//    }

}
