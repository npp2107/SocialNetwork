package npp.socialnetwork.profileserver.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends Neo4jRepository<ProfileEntity, Long> {
    Page<ProfileEntity> findAllByNameOrEmailContaining(String name, String email, Pageable pageable);
   }