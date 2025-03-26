package npp.socialnetwork.profileserver.controller.profile;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import npp.socialnetwork.profileserver.dto.profile.ProfileDto;
import npp.socialnetwork.profileserver.dto.profile.ProfileQuery;
import npp.socialnetwork.profileserver.controller.profile.models.ProfileModelMapper;
import npp.socialnetwork.profileserver.controller.profile.models.ProfileRequest;
import npp.socialnetwork.profileserver.controller.profile.models.ProfileResponse;
import npp.socialnetwork.profileserver.service.profile.ProfileUseCaseService;
import npp.socialnetwork.profileserver.utils.MySortHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProfilesController implements ProfilesAPI {
    @NonNull
    final ProfileUseCaseService profileUseCaseService;
    @NonNull
    final ProfileModelMapper profileModelMapper;

    @Override
    public void save(ProfileRequest profileRequest) {
        ProfileDto profileDto = profileModelMapper.toDto(profileRequest);
        profileUseCaseService.save(profileDto);

    }

    @Override
    public ResponseEntity<Page<ProfileResponse>> findAll(String search, String sort, Integer currentPage, Integer pageSize) {
        ProfileQuery profileQuery = ProfileQuery.builder()
                .search(search)
                .build();
        PageRequest pageRequest = PageRequest.of(currentPage - 1, pageSize, MySortHandler.of(sort));

        Page<ProfileDto> profileDtoPage = profileUseCaseService.findAll(profileQuery, pageRequest);

        Page<ProfileResponse> finalProfiles = profileDtoPage.map(profileModelMapper::toModel);
        return new ResponseEntity<>(finalProfiles, HttpStatus.OK);
    }
}