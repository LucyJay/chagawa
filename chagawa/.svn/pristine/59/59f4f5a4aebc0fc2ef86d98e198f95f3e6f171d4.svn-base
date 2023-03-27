<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 완료</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/js/regEx.js"></script>

<script type="text/javascript">
$(function() {
	$("#noticeBtn").click(function() {
		opener.parent.location = "myPage.do?id="+$("#id").val();
		window.close();
	});
	$("#loginBtn").click(function() {
		opener.parent.location = "login.do";
		window.close();
	});
});
</script>

<style type="text/css">
.alert{
	margin: 30px auto;
	text-align: center;
	padding-top: 20px; 
}
</style>

</head>
<body>
<div class="container">
	<div style="width: 50%; margin: 0 auto;">
		<input name="id" id="id" type="hidden" value="${param.id}">
		<c:if test="${param.type==1}">
			<div class="alert alert-info">비밀번호 변경이 완료되었습니다.</div>
			<button class="btn btn-default pull-right" id="noticeBtn">[내정보보기]로 돌아가기</button>
		</c:if>
		<c:if test="${param.type==2}">
			<div class="alert alert-danger">비밀번호 변경에 실패했습니다.</div>
			<button class="btn btn-default pull-right" id="noticeBtn">[내정보보기]로 돌아가기</button>
		</c:if>
		<c:if test="${param.type==3}">
			<div class="alert alert-info">운전자 등급으로 변경되었습니다.</div>
			<button class="btn btn-default pull-right" id="noticeBtn">[내정보보기]로 돌아가기</button>
		</c:if>
		<c:if test="${param.type==4}">
			<div class="alert alert-info">비밀번호 변경이 완료되었습니다.</div>
			<div class="btn btn-default pull-right" id="loginBtn">[로그인페이지]로 돌아가기</div>
		</c:if>
	</div>
</div>
</body>
</html>