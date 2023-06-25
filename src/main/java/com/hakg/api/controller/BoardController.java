package com.hakg.api.controller;

import com.hakg.api.domain.Board;
import com.hakg.api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {
    private final BoardService boardService;

    private static final String BOARD = "board";
    private static final String REDIRECT_BOARD = "redirect:/board";

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("boardList", boardService.getAllBoards());
        model.addAttribute(BOARD, new Board());
        return BOARD;
    }
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("boardList", boardService.getAllBoards());
        model.addAttribute(BOARD, new Board());
        return BOARD;
    }

    @PostMapping("/board/add")
    public String addBoard(@ModelAttribute("board") Board board) {
        boardService.addBoard(board);
        return REDIRECT_BOARD;
    }

    @GetMapping("/board/edit/{id}")
    public String editBoard(@PathVariable("id") Long id, Model model) {
        Board board = boardService.getBoardById(id);
        model.addAttribute(BOARD, board);
        return "board-edit";
    }

    @PostMapping("/board/update")
    public String updateBoard(@ModelAttribute("board") Board board) {
        boardService.updateBoard(board);
        return REDIRECT_BOARD;
    }

    @GetMapping("/board/delete/{id}")
    public String deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return REDIRECT_BOARD;
    }
}
