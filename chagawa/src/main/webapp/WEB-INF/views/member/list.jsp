<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function() {
	// key 세팅
	if("${param.key}") $("#key").val("${param.key}");
	
	// perPageNum 세팅
	if("${param.perPageNum}") $("#perPageNum").val("${param.perPageNum}");
	
	// 게시판 한줄을 클릭 이벤트
	$(".dataRow").click(function() {
		let id = $(this).find(".id").text();
		location = "view.do?id=" + id + "&page=${param.page}&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}";
	});
	
	// 한 페이지에 보여줄 데이터 개수 변경 이벤트
	$("#perPageNum").change(function() {
		$("#changePerPageNumForm").submit();
	});
	
	
	
// 	$("#statusInput").on("keyup", function() {
// 		// 입력한 값
// 		var value = $(this).val();
// 		$(".statusData").filter(function() {
// 			 					// 상태의 값
// 			$(".dataRow").toggle($(this).text().indexOf(value) > -1)
// 		});
// 	});
});
</script>

<style>
.dataRow:hover{
	background: #eee;
	cursor: pointer;
}
th{
	text-align: center;
	background: #4B89DC;
	opacity: 0.9;
	color: #EDF3FB;
}
td{
	text-align: center;
}
h2{
	color: #4B89DC;
	font-weight: bold;
	text-align: center;
}
</style>

</head>
<body>
<div class="container">
	<h2>회원리스트</h2>
	<br>
	<div class="row">
		<div class="col-md-9">
			<form class="form-inline">
				<input type="hidden" name="perPageNum" value="${param.perPageNum}">
				
				<div class="form-group">
				  	<select class="form-control" id="key" name="key">
						<option value="i">아이디</option>
						<option value="n">닉네임</option>
						<option value="in">아이디/닉네임</option>
					</select>
				</div>
				
				<div class="form-group">
			    	<input type="text" class="form-control" placeholder="Search" 
			    	 name="word" value="${param.word}">
				</div>
				
		    	<button class="btn btn-default" type="submit">
		      		<i class="glyphicon glyphicon-search"></i>
		    	</button>
			</form>
		</div>
		<div class="col-md-3 text-right">
			<form class="form-inline" id="changePerPageNumForm">
				<div class="form-group">
					<label for="perPageNum">게시글 수: </label>
				  	<select class="form-control" id="perPageNum" name="perPageNum">
						<option>5</option>
						<option selected>10</option>
						<option>20</option>
					</select>
				</div>
			</form>
		</div>
	</div>
	
	<br>
	<table class="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>성별</th>
				<th>생년월일</th>
				<th>가입일</th>
				<th>
					상태
<!-- 					<input class="form-control" id="statusInput"> -->
				</th>
				<th>가입유형</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr class="dataRow">
					<td class="id">${vo.id}</td>
					<td>${vo.nickname}</td>
					<td>${vo.gender}</td>
					<td>${vo.birth}</td>
					<td>${vo.regDate}</td>
					<td>${vo.status}</td>
					<td>${vo.gradeName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="row text-center">
		<pageNav:pageNav listURI="list.do" pageObject="${pageObject}"></pageNav:pageNav>
	</div>
</div>
</body>
</html>