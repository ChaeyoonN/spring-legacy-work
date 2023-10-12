package com.spring.myweb.freeboard.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.spring.myweb.freeboard.entity.FreeBoard;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter @ToString @EqualsAndHashCode

public class FreeContentDTO {
	
	//필드 
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String date;
	
	//생성자
	public FreeContentDTO(FreeBoard board) {
		super();
		this.bno = board.getBno();
		this.title = board.getTitle();
		this.writer = board.getWriter();
		this.content = board.getContent();
		
		this.date = board.getUpdateDate()==null? 
				FreeListResponseDTO.makePrettierDateString(board.getRegDate()) : 
				FreeListResponseDTO.makePrettierDateString(board.getUpdateDate())+"(수정됨)";
//		if(board.getUpdateDate() == null) {
//			this.date = FreeListResponseDTO.makePrettierDateString(board.getRegDate());
//		}else {
//			this.date = FreeListResponseDTO.makePrettierDateString(board.getUpdateDate())
//					+"(수정됨)";
//		}
		
	}

	
	
	
	
	
}
