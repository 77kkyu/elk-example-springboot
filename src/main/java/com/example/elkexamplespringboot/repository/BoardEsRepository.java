package com.example.elkexamplespringboot.repository;

import com.example.elkexamplespringboot.model.Board;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardEsRepository extends ElasticsearchRepository<Board, String> {
}
