package com.spring.myweb.freeboard.service;
// ctrl+shift+o : 패키지 일괄 import
import java.util.List;

import com.spring.myweb.freeboard.dto.page.Page;
import com.spring.myweb.freeboard.dto.request.FreeModifyRequestDTO;
import com.spring.myweb.freeboard.dto.request.FreeRegistRequestDTO;
import com.spring.myweb.freeboard.dto.response.FreeContentResponseDTO;
import com.spring.myweb.freeboard.dto.response.FreeListResponseDTO;

public interface IFreeBoardService {
	
	//글 등록
	void regist(FreeRegistRequestDTO dto);
	
	//글 목록
	List<FreeListResponseDTO> getList(Page page);
	
	//총 게시물 개수
	int getTotal(Page page);
	
	//상세보기
	FreeContentResponseDTO getContent(int bno);
	
	//수정
	void update(FreeModifyRequestDTO dto);
	
	//삭제
	void delete(int bno);
		
}
