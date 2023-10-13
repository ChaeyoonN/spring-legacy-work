package com.spring.myweb.freeboard.dto.response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.spring.myweb.freeboard.entity.FreeBoard;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

//클라이언트 측으로 게시글 목록을 줄 때의 스펙 정의.
@Getter @ToString @EqualsAndHashCode
public class FreeListResponseDTO {
	//필드
	private int bno;
	private String title;
	private String writer;
	private String date;
	
	//생성자
	public FreeListResponseDTO(FreeBoard board) {
		super();
		this.bno = board.getBno();
		this.title = board.getTitle();
		this.writer = board.getWriter();
		this.date = makePrettierDateString(board.getRegDate());
	}
	
	//메서드 (같은 패키지에서 열 수 있도록 default, 객체 없이 호출할 수 있도록 static)
	static String makePrettierDateString(LocalDateTime regDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
		return dtf.format(regDate);
	}




	
	
}
