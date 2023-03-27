<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보보기</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function() {
	$("#statusBtn").click(function() {
		$("#statusDiv").slideDown();
	});
	
	$("#cancelStatusBtn").click(function() {
		$("#statusDiv").slideUp();
	});
	
	$("#gradeBtn").click(function() {
		$("#gradeDiv").slideDown();
	});
	
	$("#cancelGradeBtn").click(function() {
		$("#gradeDiv").slideUp();
	});
});
</script>

<style type="text/css">
	#statusDiv{
		display: none;
	}
	#gradeDiv{
		display: none;
	}
	th{
		width: 200px;
		text-align: center;
 		background: #4B89DC;
 		opacity: 0.9;
		color: #EDF3FB;
	}
	#grade{
		width: 200px;
	}
	#statusBtn, #gradeBtn{
		margin: 0 15px;
	}
</style>

</head>
<body>
<div class="container">
	<h2 style="color: #4B89DC; text-align: center; font-weight: bold;">[${vo.nickname}] 님의 정보</h2><br>
	<div>
		<table class="table">
			<tbody>
				<tr>
					<th style="vertical-align: middle;">프로필사진</th>
					<td style="padding: 8px 40px;">
						<img class="img img-circle" style="width: 15%" src="${vo.profileImage}">
					</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td style="padding: 8px 40px;">${vo.id}</td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td style="padding: 8px 40px;">${vo.nickname}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td style="padding: 8px 40px;">${vo.name}</td>
				</tr>
				<tr>
					<th>성별</th>
					<td style="padding: 8px 40px;">${vo.gender}</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td style="padding: 8px 40px;">${vo.birth}</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td style="padding: 8px 40px;">${vo.tel}</td>
				</tr>
				<tr>
					<th>포인트</th>
					<td style="padding: 8px 40px;">${vo.myPoint}</td>
				</tr>
				<tr>
					<th>계좌</th>
					<td style="padding: 8px 40px;">${vo.account}(${vo.bank})</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td style="padding: 8px 40px;">${vo.regDate}</td>
				</tr>
				<tr>
					<th>최근접속일</th>
					<td style="padding: 8px 40px;">${vo.conDate}</td>
				</tr>
			</tbody>
		</table>
		<table class="table">
			<tbody>
				<tr>
					<th style="vertical-align: middle;">상태</th>
					<td style="padding: 8px 40px;">${vo.status}
						<c:if test="${vo.gradeNo != 9}">
							<button class="btn btn-warning btn-sm" id="statusBtn">상태변경</button>
						</c:if>
						<div id="statusDiv" class="well well-sm">
							<form action="changeStatus.do" method="post" class="form-inline">
								<input type="hidden" name="id" value="${vo.id}">
								<input type="hidden" name="page" value="${param.page}">
								<input type="hidden" name="perPageNum" value="${param.perPageNum}">
								<label for="status">변경할 상태:</label>
								<select id="status" name="status" class="form-control">
									<option <c:if test="${vo.status eq '정상'}">selected</c:if>>정상</option>
									<option <c:if test="${vo.status eq '이용정지'}">selected</c:if>>이용정지</option>
								</select>
								<button id="changeStatusBtn" class="btn btn-default btn-sm">변경</button>
								<button class="btn btn-default btn-sm" type="button" id="cancelStatusBtn">취소</button>
							</form>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<table class="table">
			<tbody>
				<tr>
					<th style="vertical-align: middle;">등급</th>
					<td style="padding: 8px 40px;">${vo.gradeNo}등급(${vo.gradeName})
						<c:if test="${vo.gradeNo != 9}">
							<button class="btn btn-warning btn-sm" id="gradeBtn">등급변경</button>
						</c:if>
						<div id="gradeDiv" class="well well-sm">
							<form action="changeGrade.do" method="post" class="form-inline">
								<input type="hidden" name="id" value="${vo.id}">
								<input type="hidden" name="page" value="${param.page}">
								<input type="hidden" name="perPageNum" value="${param.perPageNum}">
								<label for="grade">변경할 등급:</label>
								<select id="grade" name="grade" class="form-control">
									<c:if test="${vo.gradeNo == 1}">
										<option selected>1등급(동승자)</option>
									</c:if>
									<c:if test="${vo.gradeNo == 2}">
										<option selected>2등급(운전자)</option>
									</c:if>
									<option>9등급(관리자)</option>
								</select>
								<button class="btn btn-default btn-sm" id="changeGradeBtn">변경</button>
								<button class="btn btn-default btn-sm" type="button" id="cancelGradeBtn">취소</button>
							</form>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<c:if test="${vo.gradeNo == 2}">
		<div>
			<table class="table">
				<tbody>
					<tr>
						<th>차종</th>
						<td style="padding: 8px 40px;">${vo.carModel}</td>
					</tr>
					<tr>
						<th>차량번호</th>
						<td style="padding: 8px 40px;">${vo.carNo}</td>
					</tr>
					<tr>
						<th>면허번호</th>
						<td style="padding: 8px 40px;">${vo.licenseNo}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:if>
	<a class="btn btn-default pull-right" href="list.do?page=${param.page}&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}" style="margin: 0 0 20px 0;">리스트</a>
</div>
</body>
</html>