package dev.spring.crud.post;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostRestController { // 사용자에게 restAPI 제공
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostRestController(
            @Autowired PostService postService
    ){
        this.postService = postService;
    }

    // http://localhost:8080/post
    // POST /post
    // REQUST_BODY
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    // http://localhost:8080/post
    // GET /post

    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("in read all");
        return this.postService.readPostAll();
    }

    // GET /post/0
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id){
        logger.info("in read one");
        return this.postService.readPost(id);
    }

    // PUT /post/0
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(
            @RequestParam("id") int id,
            @RequestParam PostDto postDto
    ){
        logger.info("target id: " + id);
        logger.info("target content: " + postDto);
        this.postService.updatePost(id,postDto);
    }

    // DELETE /post/0
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id){
        this.postService.deletePost(id);
    }

}
