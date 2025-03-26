package npp.socialnetwork.profileserver.service.profile;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import npp.socialnetwork.profileserver.DTO.profile.ProfileDto;
import npp.socialnetwork.profileserver.DTO.profile.ProfileId;
import npp.socialnetwork.profileserver.DTO.profile.ProfileMapper;
import npp.socialnetwork.profileserver.DTO.profile.ProfileQuery;
import npp.socialnetwork.profileserver.exception.MyResourceNotFoundException;
import npp.socialnetwork.profileserver.repository.ProfileEntity;
import npp.socialnetwork.profileserver.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileQueryService {
    @NonNull
    private final ProfileRepository profileRepository;
    @NonNull
    private final ProfileMapper profileMapper;

    public ProfileDto findById(ProfileId id) {
        ProfileEntity profileEntity = profileRepository.findById(id.id())
                .orElseThrow(MyResourceNotFoundException::new);
        return profileMapper.toDto(profileEntity);
    }

    public Page<ProfileDto> findAll(ProfileQuery profileQuery, PageRequest pageRequest) {
        var profileEntities = profileRepository.findAllByNameOrEmailContaining(profileQuery.search(), profileQuery.search(), pageRequest);
        return profileEntities.map(profileMapper::toDto);
    }
}
