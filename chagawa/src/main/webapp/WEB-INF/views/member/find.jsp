<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/js/regEx.js"></script>

<script type="text/javascript">
$(function() {
	$("#form").submit(function() {
		if (!checkData(reg_pw, $("#pw"), reg_pw_error_msg, 0)) {
			$("#pw").val("");
			return false;
		}
		if (!checkData(reg_pw, $("#checkPw"), reg_pw_error_msg, 0)) {
			$("#checkPw").val("");
			return false;
		}
		if ($("#pw").val() != $("#checkPw").val()) {
			alert("비밀번호와 비밀번호 확인은 같아야 합니다.");
			$("#pw, #checkPw").val("");
			return false;
		}
	});
	
	$("#btn").click(function() {
		window.close();
	});
});
</script>

<style type="text/css">
span{
	color: #4B89DC;
	font-weight: bold;
	font-size: 2em;
}
.alert{
	margin: 50px auto;
	text-align: center;
	vertical-align: middle;
}
</style>

</head>
<body>
<div class="container">
	<div style="width: 60%; margin: 0 auto;">
		<c:if test="${type==1}">
			<div class="alert alert-info">아이디는 <span>&nbsp;${id}&nbsp;</span> 입니다.</div>
			<button id="btn" class="btn btn-default pull-right">확인</button>
		</c:if>
		
		<c:if test="${type==2}">
<%-- 			<div class="alert alert-info">비밀번호는 <span>&nbsp;${pw}&nbsp;</span> 입니다.</div> --%>
			<div class="alert alert-info" style="margin: 20px;">비밀번호 찾기에 성공했습니다.<br>변경할 비밀번호를 입력해주세요.</div>
			<form action="find.sub" method="post" id="form" class="form-group">
				<input name="id" id="id" type="hidden" value="${param.id}">
				<input name="oldPw" id="oldPw" type="hidden" value="${pw}">
				<div style="border-style: inset; margin: 10px auto;">
					<div class="form-inline" style="margin: 10px;">
						<label for="pw">새 비밀번호:</label>
						<input class="form-control" name="pw" id="pw" type="password">
					</div>
					<div class="form-inline" style="margin: 10px;">
						<label for="checkPw">비밀번호 확인:</label>
						<input class="form-control" name="checkPw" id="checkPw" type="password">
					</div>
				</div>
				<button class="btn btn-default pull-right" id="changeBtn">변경하기</button>
			</form>
		</c:if>
			
		<c:if test="${type==3}">
			<div class="alert alert-danger">아이디 찾기에 실패했습니다. 정보를 다시 입력해주세요.</div>
			<button id="btn" class="btn btn-default pull-right">확인</button>
		</c:if>
		<c:if test="${type==4}">
			<div class="alert alert-danger">비밀번호 찾기에 실패했습니다. 정보를 다시 입력해주세요.</div>
			<button id="btn" class="btn btn-default pull-right">확인</button>
		</c:if>
	</div>
</div>
</body>
</html>