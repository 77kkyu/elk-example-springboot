package com.example.elkexamplespringboot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Setter
@Getter
@ToString
@Document(indexName = "board")
public class Board {

	@Id
	private String id;

	private String title;

	private String content;

}
