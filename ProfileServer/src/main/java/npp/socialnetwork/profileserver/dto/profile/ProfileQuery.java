package npp.socialnetwork.profileserver.dto.profile;

import lombok.Builder;

@Builder
public record ProfileQuery(
        String search
) {
}
