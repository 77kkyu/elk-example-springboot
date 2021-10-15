package com.example.elkexamplespringboot;

import com.example.elkexamplespringboot.model.Board;
import com.example.elkexamplespringboot.repository.BoardEsRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Log4j2
@SpringBootTest
class ElkExampleSpringbootApplicationTests {

	@Resource
	BoardEsRepository boardEsRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void saveTest() {
		Board board = new Board();
		board.setId("1");
		board.setTitle("제목입니다용");
		board.setContent("내용입니다용");
		boardEsRepository.save(board);
	}

	@Test
	void findTest() {
		boardEsRepository.findAll();
		boardEsRepository.findById("1");
		System.out.println("findAll = " + boardEsRepository.findAll().iterator().hasNext());
		System.out.println("findById = " + boardEsRepository.findById("1").get());
	}

}
