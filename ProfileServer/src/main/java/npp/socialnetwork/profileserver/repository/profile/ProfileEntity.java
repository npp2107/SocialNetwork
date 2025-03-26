package npp.socialnetwork.profileserver.repository.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import npp.socialnetwork.profileserver.utils.TimeAuditable;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Node(labels = "Profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEntity extends TimeAuditable implements Serializable {
    @Id
    @GeneratedValue
    private Long id;


    private String name;
    private String email;
    private String avatarUrl;

    @Relationship(type = "TEAMMATE")
    private Set<ProfileEntity> teammates = new HashSet<>();

    @Relationship(type = "BOSS", direction = Relationship.Direction.OUTGOING)
    @Nullable
    private ProfileEntity boss;
}

