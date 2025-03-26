package npp.socialnetwork.postserver.dto.post;

import lombok.Builder;

@Builder
public record PostQuery(
        String search
) {
}
