<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPage</title>
<link rel="stylesheet" href="/resources/css/myPage.css">
</head>
<body>
  <div id="container">
   <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
<!--             <header> -->
<!--                 <div id="welcome">친구 초대하면 친구도 나도 적립금 5천원!</div> -->
<!--                     <div id="logo"> -->
<!--                         <a href="../index.html"> -->
<!--                             <img id="logoImg" src="../resources/images/index/logo.png" alt="logo"> -->
<!--                         </a> -->
<!--                     </div> -->
<!--                     <section> -->
<!--                         <form action="https://search.naver.com/search.naver"> -->
<!--                             <div class="search"> -->
<!--                                 <input type="text" name="query" value="" placeholder="   검색어를 입력하세요."> -->
<!--                                 <button type="submit">검색</button> -->
<!--                             </div> -->
<!--                         </form> -->
<!--                     </section> -->
<!--                     <div> -->
<!--                         <p class="member1"><a href="../member/signup.html">회원가입</a></p> -->
<!--                         <p class="member1"><a href="../member/login.html">로그인</a></p> -->
<!--                         <p class="member1"><a href="../member/costomerCenter.html">고객센터</a></p> -->
<!--                     </div> -->
<!--                     <div id="headlayer"> -->
<!--                         <a href="../product/shipping.html"><img src="../resources/images/index/location.png" alt="location"></a>  -->
<!--                         <a href="../member/myPage.html"><img src="../resources/images/index/heart.png" alt="heart"></a> -->
<!--                         <a href="../product/cart.html"><img src="../resources/images/index/trolley.png" alt="trolley"></a> -->
<!--                     </div> -->
<!--                 <div> -->
<!--                     <nav> -->
<!--                         <ul id="topMenu"> -->
<!--                                 <li><a href="#"><img id="menuicon" src="../resources/images/index/MenuIcon.png" alt="MenuIcon">카테고리</a></li> -->
<!--                                 <li><a href="#">신상품</a></li> -->
<!--                                 <li><a href="#">베스트</a></li> -->
<!--                                 <li><a href="#">알뜰쇼핑</a></li> -->
<!--                                 <li><a href="#">특가/혜택</a></li> -->
<!--                         </ul> -->
<!--                     </nav> -->
<!--                 </div> -->
<!--             </header> -->
            <main class="contents">
            
			<form action="/customer/mypage.do">

                <h2>마이페이지</h2>
                <hr>
                <div id="mypage1">
                    <div id="left">
                        <div id="top">
                            <h2>일반회원 ${sessionScope.costomerName } 님</h2><br>
                            <p>~ 6월30일까지 9900원 이상 무료배송</p>
                        </div>
                        <div id="bottom">
                            <div id="bottom1">
                                <button><a href="#">전체등급</a></button>
                                <button><a href="#">다음달 예상등급</a></button>
                    
                            </div>
                            <div id="bottom2">
                                <button><a href="javascript:void(0)" onclick="checkDelete();">회원탈퇴</a></button>
                                <button><a href="/customer/update.do?customerId=${customerId }">회원정보수정</a></button>
                            </div>
                        </div>
                    </div>
                    <div id="right">
                            <div id="right1">
                                <a href="#">적립금</a>
                                <a href="#">쿠폰</a>
                            </div>
                            <div id="right2">
                                <a href="#">주문내역</a>
                                <a href="../product/cart.html">장바구니</a>
                            </div>
                            <div id="right3">
                                <a href="../member/inquire.html">1:1문의</a>
                                <a href="#">관심상품</a>
                            </div>
                        </div>
                </div>
                <div id="mypage2">
                    <div>
                        <img src="../resources/images/myPage/myPage_banner.png" alt="myPage_banner">
                    </div>
                </div> 
			</form>
			
			<script>
			function checkDelete() {
				const customerId = "${sessionScope.customerId}";
				if(confirm("탈퇴하시겠습니까?")) {
					location.href = "/customer/delete.do?customerId=" + customerId;
				}
			}
			</script>

            </main>
            <footer>
                <section id="bottomMenu">
                    <ul>
                        <li><a href="#">회사 소개</a></li>
                        <li><a href="#">개인정보처리방침</a></li>
                        <li><a href="#">이용약관</a></li>
                        <li><a href="#">이용안내</a></li>
                        <li><a href="#">인재채용</a></li>
                    </ul>
                    </section>
                    <section id="bottomMenu2">
                        <ul>
                            <li>사업자등록번호 : 276-18-29854</li>
                            <li>주소 : 서울시 종로구 가나다라마바사 207-64</li>
                            <li>법인명(상호) : 주식회사 마이마켓</li>
                            <li>대표이사 : 박선우</li>
                            <li>제휴문의 : abc@naver.com</li>
                        </ul>  
                    </section>
            </footer>
        </div>
</body>
</html>