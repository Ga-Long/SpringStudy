package dev.spring.mybatis.dao;

import dev.spring.mybatis.dto.BoardDto;
import dev.spring.mybatis.mapper.BoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardDao {
    private final SqlSessionFactory sessionFactory;

    public BoardDao(@Autowired SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int createBoard(BoardDto dto) {
        try (SqlSession session = sessionFactory.openSession()) {
            BoardMapper mapper = session.getMapper(BoardMapper.class);
            return mapper.createBoard(dto);
        }
    }
}
