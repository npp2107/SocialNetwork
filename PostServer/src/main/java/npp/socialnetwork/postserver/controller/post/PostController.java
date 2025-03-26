package npp.socialnetwork.postserver.controller.post;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import npp.socialnetwork.postserver.dto.post.PostDto;
import npp.socialnetwork.postserver.dto.post.PostId;
import npp.socialnetwork.postserver.dto.post.PostQuery;
import npp.socialnetwork.postserver.controller.post.models.PostModelMapper;
import npp.socialnetwork.postserver.controller.post.models.PostRequest;
import npp.socialnetwork.postserver.controller.post.models.PostResponse;
import npp.socialnetwork.postserver.service.post.PostUseCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController implements PostAPI {
    @NonNull final PostUseCaseService postUseCaseService;
    @NonNull final PostModelMapper postModelMapper;

    @Override
    public ResponseEntity<PostResponse> findById(String id) {
        PostDto postDto = postUseCaseService.findById(new PostId(id));
        return new ResponseEntity<>(postModelMapper.toModel(postDto), HttpStatus.OK);
    }

    @Override
    public void delete(String id) {
        postUseCaseService.delete(new PostId(id));
    }

    @Override
    public void update(String id, PostRequest PostRequest) {
        PostDto postDto = postModelMapper.toDto(PostRequest);
        postUseCaseService.update(new PostId(id), postDto);
    }
}