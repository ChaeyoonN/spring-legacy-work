package com.spring.myweb.snsboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.myweb.snsboard.service.SnsBoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/snsboard")
@RequiredArgsConstructor
public class SnsBoardController {
	
	private final SnsBoardService serivce;
	
	@GetMapping("/snsList")
	public ModelAndView snsList() {
		ModelAndView mv = new ModelAndView();
//		mv.addObject("name", "value"); //담아서 응답과 함께 보내려면
		mv.setViewName("snsboard/snsList");
		return mv; //뷰 name으로 응답
		
	}
	
	
	
	
}
