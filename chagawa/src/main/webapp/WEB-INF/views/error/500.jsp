<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버 실행 오류</title>
</head>
<body>
<div class="container">
<h1>서버 실행 오류</h1>
	<div class="alert alert-danger">${exception.message }</div>
	<p>다시 한번 시도해 보세요.<br/>계속 오류가 발생되면 전산담당자에게 연락주세요.</p>
</div>
</body>
</html>