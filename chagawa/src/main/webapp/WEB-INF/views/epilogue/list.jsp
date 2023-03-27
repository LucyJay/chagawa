<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/WEB-INF/views/error/errorJSP.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 리스트</title>

<!-- 라이브러리 등록  : CDN 방식 -->
<!--   <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

<style type="text/css">
.dataRow:hover{
	background: #eee;
	cursor: pointer;
}

h2 {
	color: #4B89DC;
	font-weight: bold;
	text-align: center;
}

th {
	width: 200px;
	text-align: center;
	background: #4B89DC;
	opacity: 0.9;
	color: #EDF3FB;
}

td {
	text-align: center;
}

th, td {
	border-bottom: 1px solid #dcdcdc;
	border-left: 1px solid #dcdcdc;
	padding: 10px;
}

th:first-child, td:first-child {
	border-left: none;
}

#myform fieldset{
    display: inline-block;
    direction: rtl;
    border:0;
}
#myform fieldset legend{
    text-align: right;
}
#myform input[type=radio]{
    display: none;
}
#myform label{
    font-size: 3em;
    color: transparent;
    text-shadow: 0 0 0 #f0f0f0;
}
#myform label:hover{
    text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}
#myform label:hover ~ label{
    text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}
#myform input[type=radio]:checked ~ label{
    text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
}

</style>

<script type="text/javascript">
$(function(){
	// key 세팅
	if("${param.key}") $("#key").val("${param.key}");
	// perPageNum 세팅
	if("${param.perPageNum}") $("#perPageNum").val("${param.perPageNum}");
	
	// 한줄 클릭 이벤트
	$(".dataRow").click(function(){
		let no = $(this).find(".no").text();
		location = "view.do?no=" + no 
				+ "&inc=1&page=${param.page}&perPageNum=${param.perPageNum}"
				+ "&key=${param.key}&word=${param.word}";
	});
	
	// 한페이지에 보여줄 데이터 개수 변경 이벤트
	$("#perPageNum").change(function(){
		$("#changePerPageNumForm").submit();
	});
	
	
});
</script>
</head>
<body>
<div class="container">
<h2>이용 후기</h2>
<br>
<div class="row">
	<div class="col-md-9">
		<form class="form-inline">
			<input name="perPageNum" value="${param.perPageNum }" type="hidden">
	 		<div class="form-group">
			  	<select class="form-control" id="key" name="key">
			  	  <option value="t">제목</option>
			   	  <option value="c">내용</option>
			   	  <option value="w">작성자</option>
			   	  <option value="tc">제목/내용</option>
			   	  <option value="tw">제목/작성자</option>
			   	  <option value="cw">내용/작성자</option>
			   	  <option value="tcw">전체</option>
			 	</select>
			</div> 
		<div class="form-group">
	   	  <input type="text" class="form-control" placeholder="Search" 
	   	  name="word" value="${param.word }">
		</div>
	      <button class="btn btn-default" type="submit">
	        <i class="glyphicon glyphicon-search"></i>
	      </button>
		</form>
	</div>
	<div class="col-md-3 text-right">
		<form class="form-inline" id="changePerPageNumForm">
			<div class="form-group">
				<label>후기글 개수</label>
				<select name="perPageNum" id="perPageNum" class="form-control">
					<option>10</option>
					<option>15</option>
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
			<th class="col-md-1">번호</th>
			<th class="col-md-6">제목</th>
			<th class="col-md-2">작성자</th>
			<th class="col-md-2">작성일</th>
			<th class="col-md-1">조회수</th>
		</tr>
	</thead>
	<tbody>
		<!-- 데이터 있는 만큼 반복문 처리 -->
		<c:forEach items="${list }" var="vo">
			<tr class="dataRow">
				<td class="no">${vo.no }</td>
				<td>${vo.title }</td>
				<td>${vo.writer }</td>
				<td>${vo.writeDate }</td>
				<td>${vo.hit }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="row">
	<div class="col-md-5" style="padding: 20px;">
		<form class="mb-3" name="myform" id="myform" method="post">
		<fieldset>
			<a href="/carpool/mylist.do?id=${login.id}" class="text-bold">후기작성/별점등록</a>
			<input type="radio" name="reviewStar" value="5" id="rate1"><label
				for="rate1">★</label>
			<input type="radio" name="reviewStar" value="4" id="rate2"><label
				for="rate2">★</label>
			<input type="radio" name="reviewStar" value="3" id="rate3"><label
				for="rate3">★</label>
			<input type="radio" name="reviewStar" value="2" id="rate4"><label
				for="rate4">★</label>
			<input type="radio" name="reviewStar" value="1" id="rate5"><label
				for="rate5">★</label>
		</fieldset>
	</form>
	</div>
	<div class="col-md-7 text-right" >
		<br><pageNav:pageNav listURI="list.do" pageObject="${pageObject }" />
	</div>
</div>
</div>
</body>
</html>