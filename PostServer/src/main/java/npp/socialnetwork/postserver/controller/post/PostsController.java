package npp.socialnetwork.postserver.controller.post;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import npp.socialnetwork.postserver.dto.post.PostDto;
import npp.socialnetwork.postserver.dto.post.PostQuery;
import npp.socialnetwork.postserver.controller.post.models.PostModelMapper;
import npp.socialnetwork.postserver.controller.post.models.PostRequest;
import npp.socialnetwork.postserver.controller.post.models.PostResponse;
import npp.socialnetwork.postserver.service.post.PostUseCaseService;
import npp.socialnetwork.postserver.utils.MySortHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsController implements PostsAPI {
    @NonNull
    final PostUseCaseService postUseCaseService;
    @NonNull
    final PostModelMapper postModelMapper;

    @Override
    public void save(PostRequest postRequest) {
        PostDto postDto = postModelMapper.toDto(postRequest);
        postUseCaseService.save(postDto);

    }

    @Override
    public ResponseEntity<Page<PostResponse>> findAll(String search, String sort, Integer currentPage, Integer pageSize) {
        PostQuery postQuery = PostQuery.builder()
                .search(search)
                .build();
        PageRequest pageRequest = PageRequest.of(currentPage - 1, pageSize, MySortHandler.of(sort));

        Page<PostDto> postDtoPage = postUseCaseService.findAll(postQuery, pageRequest);

        Page<PostResponse> finalPosts = postDtoPage.map(postModelMapper::toModel);
        return new ResponseEntity<>(finalPosts, HttpStatus.OK);
    }
}