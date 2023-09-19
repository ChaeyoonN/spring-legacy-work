package com.spring.basic.score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.basic.score.dto.ScoreRequestDTO;
import com.spring.basic.score.service.ScoreService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/score")
@RequiredArgsConstructor //:final 필드가 존재한다면 그것만을 초기화해주는 생성자.
public class ScoreController {
	
	private final ScoreService service;
	
	//만약에 클래스의 생성자가 단 1개라면
	//자동으로 @Autowired를 작성해 줌.
	
//	@Autowired 
	//등록된 빈들 중 ScoreService타입을 생성자 매개변수에 주입
//	public ScoreController(ScoreService scoreService) {
//		service = scoreService;
		//위에 선언한 서비스객체 = 매개변수로받은객체;
//	}
	

	//1. 성적 등록 화면 띄우기 + 정보 목록 조회
	@GetMapping("/list")
	public String list() {
		return "score/score-list";
	}
	
	//2. 성적 정보 등록 처리 요청.
	@PostMapping("/register")
	public String register(ScoreRequestDTO dto) {
		//객체로받자-->용도에 따라 각각 클래스 만들자
		//단순 입력 데이터 읽기
		System.out.println("/score/register: POST! - " + dto);
		
		//서비스한테 일 시켜야지
		service.insertScore(dto);
		
		return null;
	}
	
}
