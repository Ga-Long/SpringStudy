package dev.spring.crud.post;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceSimple implements PostService{
    private static final Logger logger = LoggerFactory.getLogger(PostServiceSimple.class);
    private final PostRepository postRepository;

    public PostServiceSimple(
            @Autowired PostRepository postRepository
    ){
        this.postRepository = postRepository;
    }
    @Override
    public void createPost(PostDto dto) {
        // TODO 게시판에 사용자가 작성할 권한이 있는지
        if(!this.postRepository.save(dto)){
            throw new RuntimeException("save failed");
        }
    }

    @Override
    public List<PostDto> readPostAll() {
        return this.postRepository.findAll();
    }

    @Override
    public PostDto readPost(int id) {
        return this.postRepository.findById(id);
    }

    @Override
    public void updatePost(int id, PostDto dto) {
        this.postRepository.update(id,dto);
    }

    @Override
    public void deletePost(int id) {
        this.postRepository.delete(id);
    }
}
