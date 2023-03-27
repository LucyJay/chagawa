<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항</title>

<!-- 라이브러리 등록 - CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/regEx.js"></script>

<script type="text/javascript">
	$(function() {
		$("#writeForm").submit(
				function() {
					// 제목, 내용 유효성 검사
					if (!checkData(reg_title, $("#title"), reg_title_error_msg,
							1))
						return false;
					if (!checkData(reg_content, $("#content"),
							reg_content_error_msg, 1))
						return false;
				});

		$("#btn").click(function() {
			if ($("#startDate").val() > $("#endDate").val()) {
				alert("시작일은 종료일 이후일 수 없습니다.");
				return false;
			}
		});

		// 취소 이벤트 처리
		$("#cancelBtn").click(function() {
			history.back();
		});
	});
</script>

<style type="text/css">
h2 {
	color: #4B89DC;
	font-weight: bold;
	text-align: center;
}
</style>
</head>

<body>
	<div class="container">
		<h2 style="text-align: center;">공지 사항</h2>
		<br>
		<form action="write.do" method="post" id="writeForm" enctype="multipart/form-data">
			<input type="hidden" id="perPageNum" name="perPageNum" value="${param.perPageNum }">
			<div class="form-group">
				<label for="title">제목</label> <input name="title" id="title" class="form-control" placeholder="4~100자 이내">
			</div>
			<br>
			<div class="form-group" style="word-break: break-all">
				<label for="content">내용</label>
				<textarea style='resize: none;' name="content" id="content" class="form-control" rows="10" placeholder="4~670자 이내"></textarea>
			</div>
			<br>
			<div class="form-group">
				<label for="imgFile">이미지 파일</label> <input name="imgFile" id="imgFile" class="form-control" type="file" accept="image/*">
			</div>
			<br>
			<div class="form-group">
				<label for="gnrFile">일반 파일</label> <input name="gnrFile" id="gnrFile" class="form-control" type="file">
			</div>
			<br>
			<div style="display: inline-block; width: 48%;" class="form-group">
				<label for="startDate">시작일</label> <input name="startDate" id="startDate" class="form-control" type="date" required="required">
			</div>
			<div style="display: inline-block; float: right; width: 48%;" class="form-group">
				<label for="endDate">종료일</label> <input name="endDate" id="endDate" class="form-control" type="date" required="required">
			</div>
			<br>
			<div class=" text-right" style="margin-top: 20px;">
				<button class="btn btn-default" type="reset">초기화</button>
				<button class="btn btn-default" type="button" id="cancelBtn">취소</button>
				<button id=btn class="btn btn-default">등록</button>
			</div>
		</form>
	</div>
</body>
</html>