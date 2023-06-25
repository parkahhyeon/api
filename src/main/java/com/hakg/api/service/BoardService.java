package com.hakg.api.service;

import com.hakg.api.domain.Board;
import com.hakg.api.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public List<Board> getAllBoards() {
        return boardMapper.getAllBoards();
    }

    public Board getBoardById(Long id) {
        return boardMapper.getBoardById(id);
    }

    public void addBoard(Board board) {
        boardMapper.addBoard(board);
    }

    public void updateBoard(Board board) {
        boardMapper.updateBoard(board);
    }

    public void deleteBoard(Long id) {
        boardMapper.deleteBoard(id);
    }
}
