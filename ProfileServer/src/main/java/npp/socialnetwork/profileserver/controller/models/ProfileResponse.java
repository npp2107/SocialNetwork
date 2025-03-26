package npp.socialnetwork.profileserver.controller.models;

import java.util.Set;

public class ProfileResponse {
    public Long id;
    public String name;
    public String email;
    public String avatarUrl;
    public Set<ProfileResponse> teammates;
    public ProfileResponse boss;
}
