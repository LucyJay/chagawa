<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 중복확인</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/js/regEx.js"></script>

<script type="text/javascript">
$(function() {
	$("#useBtn").click(function() {
		$("#tel_2", parent.opener.document).val($("#tel2").val());
		$("#tel_3", parent.opener.document).val($("#tel3").val());
		window.close();
	});
	
	$("#checkBtn").click(function() {
		if (!checkData(reg_tel1, $("#tel_2"), reg_tel1_error_msg, 1)) return false;
		if (!checkData(reg_tel2, $("#tel_3"), reg_tel2_error_msg, 1)) return false;
		location = "checkTel.sub?tel_1="+$("#tel_1").val()+"&tel_2="+$("#tel_2").val()+"&tel_3="+$("#tel_3").val();
	});
});
</script>

<style type="text/css">
#u, #un{
	width: 50%;
	margin: 30px auto;
	text-align: center;
}
#tel_2, #tel_3, #tel2, #tel3{
	width: 100px;
}
#tel1{
	width: 70px;
}
#useBtn, #checkBtn{
	margin: 0 0 0 10px;
}
</style>

</head>
<body>
<div class="container">
	<c:if test="${type==2}">
		<div>
			<div class="alert alert-info" id="u">사용가능한 연락처 입니다.</div>
			<div class="form-inline" style="text-align: center">
				<label for="tel1">연락처:</label>
				<input class="form-control" name="tel1" id="tel1" readonly="readonly" value="${tel_1}">
				<input class="form-control" name="tel2" id="tel2" readonly="readonly" value="${tel_2}">
				<input class="form-control" name="tel3" id="tel3" readonly="readonly" value="${tel_3}">
				<button class="btn btn-info btn-sm" id="useBtn">사용하기</button>
			</div>
		</div>
	</c:if>
	
	<c:if test="${type==1}">
		<div>
			<div class="alert alert-danger" id="un">이미 사용중인 연락처입니다.<br>다른 연락처를 입력해주세요.</div>
			<div class="form-inline" style="text-align: center">
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
				<input class="form-control" name="tel_2" id="tel_2" value="${tel_2}">
				<input class="form-control" name="tel_3" id="tel_3" value="${tel_3}">
				<button class="btn btn-success btn-sm" id="checkBtn">중복확인</button>
			</div>
		</div>
	</c:if>
</div>
</body>
</html>