package npp.socialnetwork.profileserver.controller;

import jakarta.validation.Valid;;
import npp.socialnetwork.profileserver.controller.models.ProfileRequest;
import npp.socialnetwork.profileserver.controller.models.ProfileResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/profile/{id}")
public interface ProfileAPI {
    @GetMapping
    ResponseEntity<ProfileResponse> findById(@PathVariable Long id);

    @DeleteMapping
    void delete(@PathVariable Long id);

    @PutMapping
    void update(@PathVariable Long id, @RequestBody @Valid ProfileRequest profileRequest);
}
