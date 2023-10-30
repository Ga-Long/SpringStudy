package dev.spring.mybatis.dao;

import dev.spring.mybatis.dto.PostDto;
import dev.spring.mybatis.mapper.PostMapper;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 데이터를 주고받기 위한 클래스
public class PostDao {
    private final SqlSessionFactory sessionFactory;

    public PostDao(
            @Autowired SqlSessionFactory sessionFactory
    ){
        this.sessionFactory = sessionFactory;
    }

    public int createPost(PostDto dto){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class); // db랑 통신
            return mapper.createPost(dto);
        } // session close 자동으로 됨
    }

    public PostDto readPost(int id){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class); // db랑 통신
            return mapper.readPost(id);
        } // session close 자동으로 됨
    }

    public List<PostDto> readPostAll(){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class); // db랑 통신
            return mapper.readPostAll();
        } // session close 자동으로 됨
    }

    public int updatePost(PostDto dto){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class); // db랑 통신
            return mapper.updatePost(dto);
        } // session close 자동으로 됨
    }

    public int deletePost(int id){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class); // db랑 통신
            return mapper.deletePost(id);
        } // session close 자동으로 됨
    }
}
