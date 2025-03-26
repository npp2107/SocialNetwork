package npp.socialnetwork.profileserver.controller.profile;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import npp.socialnetwork.profileserver.dto.profile.ProfileDto;
import npp.socialnetwork.profileserver.dto.profile.ProfileId;
import npp.socialnetwork.profileserver.controller.profile.models.ProfileModelMapper;
import npp.socialnetwork.profileserver.controller.profile.models.ProfileRequest;
import npp.socialnetwork.profileserver.controller.profile.models.ProfileResponse;
import npp.socialnetwork.profileserver.service.profile.ProfileUseCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController implements ProfileAPI {
    @NonNull final ProfileUseCaseService profileUseCaseService;
    @NonNull final ProfileModelMapper profileModelMapper;

    @Override
    public ResponseEntity<ProfileResponse> findById(Long id) {
        ProfileDto profileDto = profileUseCaseService.findById(new ProfileId(id));
        return new ResponseEntity<>(profileModelMapper.toModel(profileDto), HttpStatus.OK);
    }

    @Override
    public void delete(Long id) {
        profileUseCaseService.delete(new ProfileId(id));
    }

    @Override
    public void update(Long id, ProfileRequest ProfileRequest) {
        ProfileDto profileDto = profileModelMapper.toDto(ProfileRequest);
        profileUseCaseService.update(new ProfileId(id), profileDto);
    }
}