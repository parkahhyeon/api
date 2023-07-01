package com.hakg.api.mapper;

import com.hakg.api.domain.Board;
import com.hakg.api.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getAllBoards();

    Board getBoardById(Long id);

    void addBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Long id);
}
