package dev.spring.crud.post;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
//@RequestMapping("post")
public class PostController { // 사용자에게 view 제공
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(
            @Autowired PostService postService
    ) {
        this.postService = postService;
    }

    @PostMapping("create")
    public void createPost(@RequestBody PostDto postDto) {
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    @GetMapping("read-all")
    public List<PostDto> readPostAll() {
        logger.info("in read all");
        return this.postService.readPostAll();
    }

    @GetMapping("read-one")
    public PostDto readPostONe(@RequestParam("id") int id) {
        logger.info("in read one");
        return this.postService.readPost(id);
    }

    @PostMapping("update")
    public void updatePost(
            @RequestParam("id") int id,
            @RequestParam PostDto postDto
    ) {
        logger.info("target id: " + id);
        logger.info("target content: " + postDto);
        this.postService.updatePost(id,postDto);
    }

    @DeleteMapping("delete")
    public void deletePost(@RequestParam("id") int id) {
        this.postService.deletePost(id);
    }
}
