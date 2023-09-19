package com.spring.basic.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserVO {
	//input태그 name값과 동일하게 해줘야 한다.
	private String userId;
	private String userPw;
	private String userName;
	private List<String> hobby;
	
	
	
	
	
}
