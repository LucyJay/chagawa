<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/regEx.js"></script>

<script type="text/javascript">
$(function() {
	$("#findId").click(function() {
		window.open("findId.sub", "findId", "width= 1000, height= 400, top= 200, left= 450");
	});
	
	$("#findPw").click(function() {
		window.open("findPw.sub", "findPw", "width= 1000, height= 400, top= 200, left= 450");
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
#findId, #findPw{
	margin: 0 5px 0 0;
}
</style>

</head>
<body>
	<div class="container" style="text-align: center;">
		<div style="width: 50%">
			<input id="wrong" type="hidden" value="${wrong}">
			<h2>로그인</h2>
			<br>
			<c:if test="${wrong==1}">
				<div class="alert alert-danger alert-dismissible">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					로그인 처리되지 않았습니다. 아이디나 비밀번호를 다시 확인해 주세요.
				</div>
			</c:if>
			<c:if test="${wrong==2}">
				<div class="alert alert-danger alert-dismissible">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>탈퇴</strong>한 회원은 로그인할 수 없습니다.
				</div>
			</c:if>
			<c:if test="${wrong==3}">
				<div class="alert alert-danger alert-dismissible">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>이용정지</strong>된 회원은 로그인할 수 없습니다.
				</div>
			</c:if>
			
			<form action="login.do" method="post" id="loginForm">
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-user"></i>
					</span>
					<input id="id" class="form-control" name="id" placeholder="아이디">
				</div>
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-lock"></i>
					</span>
					<input id="pw" type="password" class="form-control" name="pw" placeholder="비밀번호">
				</div>
				<div class="row">
					<div class="col-md-6">
						<button type="button" class="btn btn-info btn-sm pull-left" id="findId">아이디찾기</button>
						<button type="button" class="btn btn-info btn-sm pull-left" id="findPw">비밀번호찾기</button>
					</div>
					<div class="col-md-6">
						<button class="btn btn-default pull-right">로그인</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>