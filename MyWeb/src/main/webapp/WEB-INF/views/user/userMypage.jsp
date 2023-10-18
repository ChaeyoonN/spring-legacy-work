<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <%@ include file="../include/header.jsp" %>
    
	<section>
        <!--Toggleable / Dynamic Tabs긁어옴-->
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-10 col-lg-9 myInfo">
                    <div class="titlebox">
                        MEMBER INFO                    
                    </div>
                    
                    <ul class="nav nav-tabs tabs-style">
                        <li class="active"><a data-toggle="tab" href="#info">내정보</a></li>
                        <li><a data-toggle="tab" href="#myBoard">내글</a></li>
                        <li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="info" class="tab-pane fade in active">
 
                            <p>*표시는 필수 입력 표시입니다</p>
                            <form method="post" name="myPageForm">
                            <table class="table">
                                <tbody class="m-control">
                                    <tr>
                                        <td class="m-title">*ID</td>
                                        <td><input class="form-control input-sm" name="userId" value="${login}" readonly></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*이름</td>
                                        <td><input class="form-control input-sm" name="userName" value="${userInfo.userName}"></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*비밀번호</td>
                                        <td><input class="form-control input-sm" name="userPw"></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*비밀번호확인</td>
                                        <td><input class="form-control input-sm" name="userPwChk"></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*E-mail</td>
                                        <td>
                                            <input class="form-control input-sm"id="userEmail1" name="userEmail1" value="${userInfo.userEmail1}">
                                            <select class="form-control input-sm sel" id="userEmail2" name="userEmail2">
                                                <option ${userInfo.userEmail2 == '@naver.com' ? 'selected' : ''}>@naver.com</option>
                                                <option ${userInfo.userEmail2 == '@daum.net' ? 'selected' : ''}>@daum.net</option>
                                                <option ${userInfo.userEmail2 == '@gmail.com' ? 'selected' : ''}>@gmail.com</option>
                                            </select>
                                            <button type="button" class="btn btn-primary" id="mail-check-btn">이메일인증</button>
                                            <div class="mail-check-box">
                                                <input type="text" class="form-control mail-check-input" placeholder="인증번호 6자리를 입력하세요."
                                                    maxlength="6" disabled="disabled">
                                                <span id="mail-check-warn"></span>
                                            </div>
                                        </td>
                                            
                                    </tr>
                                    <tr>
                                        <td class="m-title">*휴대폰</td>
                                        <td>
                                            <select class="form-control input-sm sel" name="userPhone1">
                                                <option ${userInfo.userPhone1 == '010' ? 'selected' : ''}>010</option>
                                                <option ${userInfo.userPhone1 == '011' ? 'selected' : ''}>011</option>
                                                <option ${userInfo.userPhone1 == '017' ? 'selected' : ''}>017</option>
                                                <option ${userInfo.userPhone1 == '018' ? 'selected' : ''}>018</option>
                                            </select>
                                            <input class="form-control input-sm" name="userPhone2" value="${userInfo.userPhone2}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*우편번호</td>
                                        <td><input class="form-control input-sm" id="addrZipNum" name="addrZipNum" value="${userInfo.addrZipNum}" readonly>
                                        	<button type="button" class="btn btn-primary" id="addBtn" onclick="searchAddress()">주소찾기</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*주소</td>
                                        <td><input class="form-control input-sm add" id="addrBasic" name="addrbasic" value="${userInfo.addrBasic}" ></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*상세주소</td>
                                        <td><input class="form-control input-sm add" id="addrDetail" name="addrDetail" value="${userInfo.addrDetail}" ></td>
                                    </tr>
                                </tbody>
                            </table>
                            </form>

                            <div class="titlefoot">
                                <button class="btn">수정</button>
                                <button class="btn">목록</button>
                            </div>
                        </div>
                        <!-- 첫번째 토글 끝 -->
                        
                        <!-- 두번째 토글 메뉴의 시작 -->
                        <div id="myBoard" class="tab-pane fade">
                            <p>*내 게시글 관리</p>
                            <form>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td>번호</td>
                                        <td>제목</td>
                                        <td>작성일</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="b" items="${userInfo.userBoardList}">
                                	<tr>
                                		<td>${b.bno}</td>
                                		<td><a href="##">${b.title}</a></td>
                                		<td>${b.date}</td>
                                	</tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            </form>
                        </div>
                        <!-- 두번째 토글 끝 -->
                        <div id="menu2" class="tab-pane fade">
                            <h3>Menu 2</h3>
                            <p>Some content in menu 2.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    
    <%@ include file="../include/footer.jsp" %>

    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        let code ='';

        //다음 주소 api 사용해보기 (script src 추가해야 합니다.)
        function searchAddress() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수
                    var extraAddr = ''; // 참고항목 변수

                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }

                    

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('addrZipNum').value = data.zonecode;
                    document.getElementById("addrBasic").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("addrDetail").focus();
                }
            }).open();
        } // 주소찾기 api 끝.

        //인증번호 이메일 전송
        document.getElementById('mail-check-btn').onclick = function () {
            if(document.getElementById('userEmail1').value === ''){
                alert('이메일을 입력한 후에 인증하세요.');
                return;
            } 
            const email = document.getElementById('userEmail1').value 
                        + document.getElementById('userEmail2').value;
            console.log('완성된 email: ',email);
            
            fetch('${pageContext.request.contextPath}/user/email', {
                method: 'post',
                headers: {
                    'Content-Type': 'text/plain' //json이면 'application/json'
                },
                body: email
            })
            .then(res => res.text())
            .then(data => {
                console.log('인증번호: ', data);
                //비활성화된 인증번호 입력창을 활성화
                document.querySelector('.mail-check-input').disabled = false;
                code = data; //서버가 전달한 인증번호를 전역 변수에 저장.
                alert('인증번호가 전송되었습니다. 확인 후 입력란에 정확히 입력하세요.');
            })
            .catch(error => {
                console.log(error);
                alert('알 수 없는 문제가 발생했습니다. 관리자에게 문의하세요!');
            }); // 비동기 끝

        }; //이메일 인증 버튼 클릭 이벤트 끝
        
        //인증번호 검증
        //blur -> focus가 벗어나는 경우 발생.
        document.querySelector('.mail-check-input').onblur = function (e) {
            // console.log('blur 이벤트 발생 확인!');
            const inputCode = e.target.value; //사용자가 입력한 인증번호.
            const $resultMsg = document.getElementById('mail-check-warn'); //span태그
            console.log('사용자가 입력한 값: ', inputCode);

            if(inputCode === code){
                $resultMsg.textContent = '인증번호가 일치합니다.';
                $resultMsg.style.color = 'green';

                //이메일 인증을 더 이상 못하게 하는 버튼 비활성.
                document.getElementById('mail-check-btn').disabled = true;
                document.getElementById('userEmail1').setAttribute('readonly', true);
                document.getElementById('userEmail2').setAttribute('readonly', true);

                e.target.style.display = 'none'; //인증번호 입력창 숨기기

                //select 태그에서 초기값을 사용자가 선택한 값으로 무조건 설정하는 방법
                //(select에서 readonly 대용으로 사용)
                //항상 2개 같이 쓰셔야 합니다.
                const $email2 = document.getElementById('userEmail2');
                
                //사용자가 select의 옵션을 처음 선택했을 때의 값을 기억했다가
                //option 변경 시도를 할 때마다 초기값으로 강제로 변경해서
                //option이 마치 변하지 않는 것처럼 처리.
                $email2.setAttribute('onFocus', 'this.initialSelect = this.selectedIndex');
                $email2.setAttribute('onChange', 'this.selectedIndex = this.initialSelect');
            }else{
                $resultMsg.textContent = '인증번호를 다시 확인해 주세요.';
                $resultMsg.style.color ='red';
                e.target.focus();
            }
        } //인증번호 검증 끝.

        

    </script>
