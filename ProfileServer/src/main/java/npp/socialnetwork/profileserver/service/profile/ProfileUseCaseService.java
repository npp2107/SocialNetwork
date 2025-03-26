package npp.socialnetwork.profileserver.service.profile;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import npp.socialnetwork.profileserver.dto.profile.ProfileDto;
import npp.socialnetwork.profileserver.dto.profile.ProfileId;
import npp.socialnetwork.profileserver.dto.profile.ProfileQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ProfileUseCaseService {

    @NonNull
    private final ProfileQueryService profileQueryService;
    @NonNull
    private final ProfileCommandService profileCommandService;

    @Transactional
    public void update(ProfileId id, ProfileDto profileDto) {
        profileCommandService.update(id, profileDto);
    }

    @Transactional
    public void delete(ProfileId profileId) {
        profileCommandService.delete(profileId);
    }

    @Transactional
    public void save(ProfileDto profileDto) {
        profileCommandService.save(profileDto);
    }

    public ProfileDto findById(ProfileId id) {
        return profileQueryService.findById(id);
    }

    public Page<ProfileDto> findAll(ProfileQuery profileQuery, PageRequest pageRequest) {
        return profileQueryService.findAll(profileQuery, pageRequest);
    }
}
