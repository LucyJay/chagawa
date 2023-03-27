<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<script type="text/javascript" src="/js/regEx.js"></script>

<script type="text/javascript">
$(function() {
	$("#useBtn").click(function() {
		$("#id", parent.opener.document).val($("#id").val());
		window.close();
	});
	
	$("#checkBtn").click(function() {
		if (!checkData(reg_id, $("#newId"), reg_id_error_msg, 1)) return false;
		location = "checkId.sub?id="+$("#newId").val();
	});
});
</script>

<style type="text/css">
#u, #un{
	width: 50%;
	margin: 30px auto;
	text-align: center;
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
			<div class="alert alert-info" id="u">
				사용가능한 아이디 입니다.
			</div>
			<div class="form-inline" style="text-align: center">
				<label for="id">아이디:</label>
				<input class="form-control" name="id" id="id" readonly="readonly" value="${param.id}">
				<button class="btn btn-info btn-sm" id="useBtn">사용하기</button>
			</div>
		</div>
	</c:if>
	
	<c:if test="${type==1}">
		<div>
			<div class="alert alert-danger" id="un">이미 사용중인 아이디입니다.<br>다른 아이디를 입력해주세요.</div>
			<div class="form-inline" style="text-align: center">
				<label for="newId">아이디:</label>
				<input class="form-control" name="newId" id="newId" value="${param.id}">
				<button class="btn btn-success btn-sm" id="checkBtn">중복확인</button>
			</div>
		</div>
	</c:if>
</div>
</body>
</html>