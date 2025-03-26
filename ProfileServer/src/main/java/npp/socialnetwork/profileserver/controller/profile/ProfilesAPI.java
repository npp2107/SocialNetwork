package npp.socialnetwork.profileserver.controller.profile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import npp.socialnetwork.profileserver.controller.profile.models.ProfileRequest;
import npp.socialnetwork.profileserver.controller.profile.models.ProfileResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/profile")
public interface ProfilesAPI {
    @PostMapping
    void save(@RequestBody @Valid ProfileRequest profileRequest);

    @GetMapping
    ResponseEntity<Page<ProfileResponse>> findAll(
            @RequestParam(required = false, value = "search", defaultValue = "") String search,
            @RequestParam(required = false, value = "sort", defaultValue = "") String sort,
            @RequestParam(required = false, value = "currentPage", defaultValue = "1") @Min(1) Integer currentPage,
            @RequestParam(required = false, value = "pageSize", defaultValue = "20") Integer pageSize
    );
}
