package npp.socialnetwork.postserver.service.post;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import npp.socialnetwork.postserver.dto.post.PostDto;
import npp.socialnetwork.postserver.dto.post.PostId;
import npp.socialnetwork.postserver.dto.post.PostQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PostUseCaseService {

    @NonNull
    private final PostQueryService postQueryService;
    @NonNull
    private final PostCommandService postCommandService;

    @Transactional
    public void update(PostId id, PostDto postDto) {
        postCommandService.update(id, postDto);
    }

    @Transactional
    public void delete(PostId postId) {
        postCommandService.delete(postId);
    }

    @Transactional
    public void save(PostDto postDto) {
        postCommandService.save(postDto);
    }

    public PostDto findById(PostId id) {
        return postQueryService.findById(id);
    }

    public Page<PostDto> findAll(PostQuery postQuery, PageRequest pageRequest) {
        return postQueryService.findAll(postQuery, pageRequest);
    }
}
