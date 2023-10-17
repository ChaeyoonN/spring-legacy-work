package com.spring.myweb.user.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.myweb.user.entity.User;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/db-config.xml")
public class UserMapperTest {
	
	@Autowired
	private IUserMapper mapper;
	
	
	@Test
    @DisplayName("회원 가입을 진행했을 때 회원가입이 성공해야 한다.")
    void registTest() {
        mapper.join(User.builder()
        				.userId("ddd")
        				.userPw("ee1111!")
        				.userName("사람")
//        				.userPhone1("010")
//        				.userPhone2("1234-5678")
        				.userEmail1("abnn")
        				.userEmail2("naver.com")
        				.addrBasic("서울 서대문구 가재울로 42")
//        				.addrDetail("102-206")
//        				.addrZipNum("03849")
        				.build()
        		);
        
    }
    
    @Test
    @DisplayName("존재하는 회원 아이디를 조회했을 시 1이 리턴되어야 한다.")
    void checkIdTest() {
    	String id = "abc1234";
        int chk = mapper.idCheck(id);
       
        System.out.println(chk);
        assertEquals(1, chk);
     
    }
    
    @Test
    @DisplayName("존재하는 회원 아이디를 입력 했을 시 그 회원의 비밀번호가 리턴되어야 한다.")
    void loginTest() {
    	String id = "abc1234";
        String pw = mapper.login(id);
        
        assertEquals("aaa1111!", pw);
        assertNotNull(pw);
        
    }
    
    @Test
    @DisplayName("존재하지 않는 회원의 아이디를 전달하면 null이 올 것이다.")
    void getInfoTest() {
    	String id = "dkej";
        User user = mapper.getInfo(id);
        
        assertEquals(null, user);
        assertNull(user);
    }
    
    @Test
    @DisplayName("id를 제외한 회원의 정보를 수정할 수 있어야 한다.")
    void updateTest() {
    	User user = User.builder()
    			.userId("cewf")
    			.userPw("li984!")
    			.userName("리디")
    			.userEmail1("lidy01")
    			.userEmail2("gmail.com")
    			.addrBasic("서울특별시 강동구")
    			.addrDetail("121-196")
    			.addrZipNum("03719")
    			.build();
    
        mapper.updateUser(user);
        
       
        System.out.println(user.toString());
        assertEquals(user.getUserEmail1(), mapper.getInfo(user.getUserId()).getUserEmail1());
    }
	
	
}
