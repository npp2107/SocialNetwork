package npp.socialnetwork.profileserver.dto.profile;

import java.util.Set;

public class ProfileDto {
    public Long id;
    public String name;
    public String email;
    public String avatarUrl;
    public Set<ProfileDto> teammates;
    public ProfileDto boss;

}
