package dev.spring.mybatis.mapper;

import dev.spring.mybatis.dto.PostDto;
import java.util.List;

public interface PostMapper {
    int createPost(PostDto dto); // roww가 돌아옴
    int createPostAll(List<PostDto> dtoList);
    PostDto readPost(int id);
    List<PostDto> readPostAll();
    PostDto readPostQuery(PostDto dto);
    int updatePost(PostDto dto);
    int deletePost(int id);
}
