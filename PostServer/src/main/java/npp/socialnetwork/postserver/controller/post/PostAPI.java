package npp.socialnetwork.postserver.controller.post;

import jakarta.validation.Valid;;
import npp.socialnetwork.postserver.controller.post.models.PostRequest;
import npp.socialnetwork.postserver.controller.post.models.PostResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/post/{id}")
public interface PostAPI {
    @GetMapping
    ResponseEntity<PostResponse> findById(@PathVariable String id);

    @DeleteMapping
    void delete(@PathVariable String id);

    @PutMapping
    void update(@PathVariable String id, @RequestBody @Valid PostRequest postRequest);
}
