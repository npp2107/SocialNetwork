package npp.socialnetwork.postserver.service.post;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import npp.socialnetwork.postserver.dto.post.PostDto;
import npp.socialnetwork.postserver.dto.post.PostId;
import npp.socialnetwork.postserver.dto.post.PostMapper;
import npp.socialnetwork.postserver.dto.post.PostQuery;
import npp.socialnetwork.postserver.exception.MyResourceNotFoundException;
import npp.socialnetwork.postserver.repository.post.PostEntity;
import npp.socialnetwork.postserver.repository.post.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostQueryService {
    @NonNull
    private final PostRepository postRepository;
    @NonNull
    private final PostMapper postMapper;

    public PostDto findById(PostId id) {
        PostEntity postEntity = postRepository.findById(id.id())
                .orElseThrow(MyResourceNotFoundException::new);
        return postMapper.toDto(postEntity);
    }

    public Page<PostDto> findAll(PostQuery postQuery, PageRequest pageRequest) {
        var postEntities = postRepository.findAllByContentContaining(postQuery.search(), pageRequest);
        return postEntities.map(postMapper::toDto);
    }
}
