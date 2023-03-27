<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
});
</script>

<style type="text/css">
div{
	margin: 10px auto;
	text-align: center;
}
#changeBtn{
	width: 300px;
}
#form{
	width: 50%;
	margin: 0 auto;
}
</style>

</head>
<body>
<div class="container">
	<form action="changePw.sub" method="post" id="form" class="form-group">
		<input name="id" id="id" type="hidden" value="${param.id}">
		<div style="border-style: inset;">
			<div class="form-inline">
				<label for="oldPw">기존 비밀번호:</label>
				<input class="form-control" name="oldPw" id="oldPw" type="password">
			</div>
			<div class="form-inline">
				<label for="pw">새 비밀번호:</label>
				<input class="form-control" name="pw" id="pw" type="password">
			</div>
			<div class="form-inline">
				<label for="checkPw">비밀번호 확인:</label>
				<input class="form-control" name="checkPw" id="checkPw" type="password">
			</div>
		</div>
		<button class="btn" id="changeBtn">변경하기</button>
	</form>
</div>
</body>
</html>