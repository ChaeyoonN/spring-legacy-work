package com.spring.myweb.reply.dto;

import com.spring.myweb.reply.entity.Reply;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRequestDTO {
		
	private int bno;
	private String replyText;
	private String replyId;
	private String replyPw; //js 요청과 함께 전달한 body객체 데이터명과 같게
	
	
	public Reply toEntity(ReplyRequestDTO dto) {
		return Reply.builder()
		.bno(dto.getBno()) //컨트롤러에서 이미 넣어줬으므로 dto.getBno() 대신 this.bno라 해도 됌
		.replyText(dto.getReplyText())
		.replyWriter(dto.getReplyId())
		.replyPw(dto.getReplyPw())
		.build();
	}
	
	
}
