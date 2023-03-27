<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/js/regEx.js"></script>

<script type="text/javascript">
$(function() {
	$("#cancelBtn").click(function() {
		window.close();
	});
	
	$("#tel_2").on("keyup", function() {
		if(this.value.length == 4) {
			$("#tel_3").focus();
		}
	});
});
</script>

<style type="text/css">
h2{
	color: #4B89DC;
	font-weight: bold;
	text-align: center;
}
div{
	margin: 10px auto;
}
#tel_2, #tel_3{
	width: 100px;
}
#tel_1{
	width: 70px;
}
</style>

</head>

<body>
<div class="container">
	<div style="width: 50%; margin: 0 auto;">
		<h2>비밀번호 찾기</h2>
		<br>
		<form action="findPw.sub" method="post" id="joinForm">
			<div style="border-style: inset;">
				<div class="form-inline">
					&nbsp;&nbsp;
					<label for="id">아이디:</label>
					<input class="form-control" name="id" id="id">
				</div>
				<div class="form-inline">
					&nbsp;&nbsp;
					<label for="name">이름:</label>
					<input class="form-control" name="name" id="name">
				</div>
				<div class="form-inline">
					&nbsp;&nbsp;
					<label for="tel_1">연락처:</label>
					<select class="form-control" name="tel_1" id="tel_1">
						<option>010</option>
						<option>011</option>
						<option>012</option>
						<option>013</option>
						<option>014</option>
						<option>015</option>
						<option>016</option>
						<option>017</option>
						<option>018</option>
						<option>019</option>
					</select>
					<input class="form-control" name="tel_2" id="tel_2">
					<input class="form-control" name="tel_3" id="tel_3">
				</div>
				<div class="form-inline pull-right">
					<button class="btn">비밀번호 찾기</button>
					<button class="btn" type="button" id="cancelBtn">취소</button>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>