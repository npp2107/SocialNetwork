package npp.socialnetwork.postserver.service.post;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import npp.socialnetwork.postserver.dto.post.PostDto;
import npp.socialnetwork.postserver.dto.post.PostId;
import npp.socialnetwork.postserver.dto.post.PostMapper;
import npp.socialnetwork.postserver.exception.MyResourceNotFoundException;
import npp.socialnetwork.postserver.repository.post.PostEntity;
import npp.socialnetwork.postserver.repository.post.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCommandService {
    @NonNull
    final PostRepository postRepository;
    @NonNull
    final PostMapper postMapper;

    public PostDto save(PostDto postDto) {
        PostEntity postEntity = postMapper.toEntity(postDto);
        postRepository.save(postEntity);
        return postMapper.toDto(postEntity);
    }

    public void delete(PostId id) {
        postRepository.deleteById(id.id());
    }

    public void update(PostId postId, PostDto postDto) {
        PostEntity foundEntity = postRepository.findById(postId.id()).orElseThrow(MyResourceNotFoundException::new);
        postMapper.updateExist(postDto, foundEntity);
        postRepository.save(foundEntity);
    }
//    public void updateIsDeleted(PostId postId, Boolean isDeleted) {
//        PostEntity foundEntity = postRepository.findById(postId.id()).orElseThrow(MyResourceNotFoundException::new);
//        foundEntity.setIsDeleted(isDeleted);
//        foundEntity.setIsActive(isActive);
//        postRepository.save(foundEntity);
//    }

}
