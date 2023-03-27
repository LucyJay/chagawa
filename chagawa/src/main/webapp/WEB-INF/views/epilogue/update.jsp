<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 글 수정</title>

<!-- 라이브러리 등록  : CDN 방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/js/regEx.js"></script>

<script type="text/javascript">
$(function(){
	$("#updateForm").submit(function(){
		// 제목, 내용
		if(!checkData(reg_title, $("#title"), reg_title_error_msg, 1)) return false;
		if(!checkData(reg_content, $("#content"), reg_content_error_msg, 1)) return false;
		
	});
	
	// 취소 이벤트
	$("#cancelBtn").click(function(){
		history.back();
	})
});
</script>

</head>
<body>
<div class="container">
	<h1>후기 글 수정</h1>
	<form action="update.do" method="post" id="updateForm">
		<input type="hidden" name="page" value="${param.page }">
		<input type="hidden" name="perPageNum" value="${param.perPageNum }">
		<input type="hidden" name="key" value="${param.key }">
		<input type="hidden" name="word" value="${param.word }">
		<div class="form-group">
			<label for="no">번호</label>
			<input name="no" id="no" class="form-control" readonly value="${vo.no }">
		</div>
		<div class="form-group">
			<label for="cpNo">카풀번호</label>
			<input name="cpNo" id="cpNo" class="form-control" readonly value="${vo.cpNo }">
		</div>
		<div class="form-group">
			<label for="writer">작성자</label>
			<input name="writer" id="writer" class="form-control"  readonly value="${vo.writer }">
		</div>
		<div class="form-group">
			<label for="title">제목</label>
			<input name="title" id="title" class="form-control" value="${vo.title }">
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea name="content" id="content" class="form-control">${vo.content }</textarea>
		</div>
		<button onclick="view.do?page=${param.page }&perPageNum=${param.perPageNum }">수정</button>
		<button type="reset">새로입력</button>
		<button type="button" id="cancelBtn">취소</button>
	</form>
</div>
</body>
</html>