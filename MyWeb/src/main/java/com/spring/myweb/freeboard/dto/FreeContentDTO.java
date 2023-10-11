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
	private String regDate;
	private String updateDate;
	
	//생성자
	public FreeContentDTO(FreeBoard board) {
		super();
		this.bno = board.getBno();
		this.title = board.getTitle();
		this.writer = board.getWriter();
		this.content = board.getContent();
		this.regDate = makePrettierDateString(board.getRegDate());
		this.updateDate = board.getUpdateDate()==null? 
				makePrettierDateString(board.getRegDate()) : 
				makePrettierDateString(board.getUpdateDate())+"(수정됨)";
		
	}

	//메서드
	private String makePrettierDateString(LocalDateTime date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
		return dtf.format(date);
	}
	
	
	
	
}
