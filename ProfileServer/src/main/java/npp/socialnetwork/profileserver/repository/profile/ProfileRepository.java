package npp.socialnetwork.profileserver.repository.profile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends Neo4jRepository<ProfileEntity, Long> {
    Page<ProfileEntity> findAllByNameOrEmailContaining(String name, String email, Pageable pageable);
   }