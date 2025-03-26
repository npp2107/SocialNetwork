package npp.socialnetwork.profileserver.DTO.profile;

import lombok.Builder;

@Builder
public record ProfileQuery(
        String search
) {
}
