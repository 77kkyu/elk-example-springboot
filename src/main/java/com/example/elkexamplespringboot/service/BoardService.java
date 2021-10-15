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
		RestTemplate rt = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		//MultiValueMap<String, String> parames = new LinkedMultiValueMap<>();
		//parames.add("jsonData", jsonData);
		HttpEntity<String> request = new HttpEntity<>(headers);

		//ResponseEntity response = rt.exchange("http://localhost:8081/test", HttpMethod.GET, request, String.class);
		String response = rt.postForObject(elasticSearchUrl, request, String.class);
		ObjectMapper objectMapper = new ObjectMapper();

		System.out.println(response);
		return response;
	}

}
