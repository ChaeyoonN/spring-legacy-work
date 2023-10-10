package com.spring.basic.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.basic.board.dto.BoardListResponseDTO;
import com.spring.basic.board.dto.BoardModifyRequestDTO;
import com.spring.basic.board.entity.Board;
import com.spring.basic.board.repository.IBoardMapper;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class BoardService {

	private final IBoardMapper mapper;
	

	public void insertArticle(String writer, String title, String content) {
		Board board = new Board();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		mapper.insertArticle(board);//->보드메퍼.xml의 해당메서드 실행됌
		
	}

	public List<BoardListResponseDTO> getArticles() {
		List<BoardListResponseDTO> dtoList = new ArrayList<>();
		
		List<Board> boardList = mapper.getArticles();
		
		for(Board b : boardList) {
			BoardListResponseDTO dto = new BoardListResponseDTO(b);
			dtoList.add(dto);
		}
		return dtoList;
		
	}

	public Board retrieve(int boardNo) {
		return mapper.getArticle(boardNo); //원래는 DTO로 주는 게 맞음
		
	}
	
	public void updateArticle(int boardNo, String writer, String title, String content) {
		Board board = mapper.getArticle(boardNo);
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		mapper.updateArticle(board);//->보드메퍼.xml의 해당메서드 실행됌
		
	}

	public void modify(BoardModifyRequestDTO dto) {
//		Board board = mapper.getArticle(dto.getBoardNo());
//		board.setWriter(dto.getWriter());
//		board.setTitle(dto.getTitle());
//		board.setContent(dto.getContent());
//		mapper.updateArticle(board);//->보드메퍼.xml의 해당메서드 실행됌
		
		Board board = Board.builder()
						.boardNo(dto.getBoardNo())
						.writer(dto.getWriter())
						.title(dto.getTitle())
						.content(dto.getContent())
						.build();
		mapper.updateArticle(board);
		
	}

	public void deleteArticle(int boardNo) {
		mapper.deleteArticle(boardNo);
		
	}
	
}
