package npp.socialnetwork.profileserver.controller.models;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class ProfileRequest {
    @NotNull
    public String name;
    @NotNull
    public String email;
    public String avatarUrl;
    public Set<ProfileRequest> teammates;
    public ProfileRequest boss;
}
