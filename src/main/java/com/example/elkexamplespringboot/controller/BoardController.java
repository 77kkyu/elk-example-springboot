package com.example.elkexamplespringboot.controller;

import com.example.elkexamplespringboot.model.Board;
import com.example.elkexamplespringboot.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@RestController
public class BoardController {

	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@PostMapping(value = "/creativeIndex")
	public boolean creativeIndex(HttpServletRequest request, HttpServletResponse response, @RequestBody Board board) {
		log.info("creativeIndex Adapter");
		log.info("creativeIndex Value = " + board.toString());
		return boardService.creativeIndex(board);
	}

	@GetMapping(value = "/boardTitleSearch" ,produces = "application/json; charset=UTF-8" )
	public String boardTitleSearch(HttpServletRequest request, HttpServletResponse response, String title) {
		log.info("boardTitleSearch Adapter");
		log.info("boardTitleSearch title = " + title);
		return boardService.boardTitleSearch(title);
	}

}
