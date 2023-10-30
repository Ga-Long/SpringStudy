package dev.spring.mybatis.mapper;

import dev.spring.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
