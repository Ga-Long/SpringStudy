package dev.spring.crud.post;

import java.util.List;

public interface PostService { // 권한 체크, 검증
    void createPost(PostDto dto);
    List<PostDto> readPostAll();
    PostDto readPost(int id);
    void updatePost(int id, PostDto dto);
    void deletePost(int id);
}
