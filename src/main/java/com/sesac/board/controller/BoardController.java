package com.sesac.board.controller;

import com.sesac.board.entity.Board;
import com.sesac.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //localhost:8080/board/write
    public String boardWriteForm() {
        return "boardwrite";
    }

    @PostMapping("/board/writepro") //localhost:8080/board/write
    public String boardWritePro(Board board) {

        boardService.write(board);

        return "";
    }

    @GetMapping("/")
    @ResponseBody
    public String main(){

        return "Hello World";
    }

}
