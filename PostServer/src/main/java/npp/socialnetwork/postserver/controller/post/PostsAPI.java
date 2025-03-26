package npp.socialnetwork.postserver.controller.post;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import npp.socialnetwork.postserver.controller.post.models.PostRequest;
import npp.socialnetwork.postserver.controller.post.models.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/post")
public interface PostsAPI {
    @PostMapping
    void save(@RequestBody @Valid PostRequest postRequest);

    @GetMapping
    ResponseEntity<Page<PostResponse>> findAll(
            @RequestParam(required = false, value = "search", defaultValue = "") String search,
            @RequestParam(required = false, value = "sort", defaultValue = "") String sort,
            @RequestParam(required = false, value = "currentPage", defaultValue = "1") @Min(1) Integer currentPage,
            @RequestParam(required = false, value = "pageSize", defaultValue = "20") Integer pageSize
    );
}
