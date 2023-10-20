package com.spring.myweb.snsboard.mapper;

import java.util.List;

import com.spring.myweb.freeboard.dto.page.Page;
import com.spring.myweb.snsboard.entity.Snsboard;

public interface ISnsBoardMapper {

	//등록
	void insert(Snsboard board);
	
	//목록
	List<Snsboard> getList(Page page);
	
	//상세
	Snsboard getDetail(int bno);
	
	//삭제
	void delete(int bno);
	
	
}
