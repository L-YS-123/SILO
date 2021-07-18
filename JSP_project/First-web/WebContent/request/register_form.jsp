<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	src = "http://code.jquery.com/jquery-3.5.1.js"
	integrity = "sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin = "anonymous" >
</script>

<div>
	<input type="button" id="userResister" value="회원가입"
		onclick="register_onClick();">
</div>

<form>
	<div id="popUp" style="display: none">
		<table>
			<tr>
				<td name="table_Id">아이디</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td name="table_Pw">비밀번호</td>
				<td><input type="password"></td>
			</tr>
			<tr>
				<td name="table_rePw">비밀번호 확인</td>
				<td><input type="password"></td>
			</tr>
			<tr>
				<td name="table_name">이름</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td><input type="submit" value="가입하기"></td>
				<td><input type="button" value="닫기" id="register_close"
						onclick="register_onClick2();"></td>
			</tr>
		</table>
	</div>
</form>
<script>
	//$("#popUp").hide();

	function register_onClick() {
		alert("제이쿼리 팝업 안되는 이유 나중에 질문하기")
		// 온클릭시 회원가입 창이 뜨도록
		//$('#popUp').show();
		popUp.style.display = "block";
		//userResister.style.display = "none"; //이건 또 왜 안돼;
	}
	
	function register_onClick2() {
		popUp.style.display = "none";
	}
</script>


