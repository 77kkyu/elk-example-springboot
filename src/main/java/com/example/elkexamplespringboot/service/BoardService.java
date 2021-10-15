package com.example.elkexamplespringboot.service;

import com.example.elkexamplespringboot.model.Board;
import com.example.elkexamplespringboot.repository.BoardEsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
public class BoardService {

	private final BoardEsRepository boardEsRepository;

	public BoardService(BoardEsRepository boardEsRepository) {
		this.boardEsRepository = boardEsRepository;
	}

	public boolean creativeIndex(Board board) {
		log.info("creativeIndex Service");
		boardEsRepository.save(board);
		return boardEsRepository.existsById(board.getId());
	}

	public String boardTitleSearch(String keyword) {
		log.info("boardTitleSearch Service");
		String elasticSearchUrl = "http://localhost:9200/board/_search?q=title:*" + keyword + "*&pretty";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(headers);
		String response = restTemplate.postForObject(elasticSearchUrl, request, String.class);
		System.out.println(response);
		return response;
	}

}
