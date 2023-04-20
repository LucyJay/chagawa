<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카풀 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 카풀 등록 실행 시 이미 등록한 카풀 확인 후 now=1로 리다이렉트됨. 이때 alert 출력	
		if ("${param.now}") {
			alert("이용 중인 카풀이 있는 경우 등록할 수 없습니다.");
		}
		// 각 카풀정보 클릭시 번호를 받아 상세보기로 이동
		$(".cp").click(function() {
			let no = $(this).find(".no").text();
			location = "view.do?no=" + no;
		});
	});
</script>
<style type="text/css">
.circle {
	background-color: #ECF2FA;
	float: left;
	border-radius: 50%;
	width: 70px;
	height: 70px;
	margin: 30px;
}

.circle h4 {
	text-align: center;
	padding-top: 15px;
}

.page {
	clear: left;
}
</style>
</head>
<body>
	<div class="container">
		<h1>카풀 리스트</h1>
		<div class="searchRegion">
			<form>
				<!-- 출발지역 고르기 -->
				<div class="col-sm-4">
					<label for="startRegion">출발</label> <select name="startRegion"
						required="required" class="form-control">
						<option>서울 강북구</option>
						<option>서울 광진구</option>
						<option>서울 도봉구</option>
						<option>경기 고양시</option>
						<option>경기 양주시</option>
						<option selected="selected">경기 의정부시</option>
					</select>
				</div>
				<!-- 도착지역 고르기 -->
				<div class="col-sm-4">
					<label for="arriveRegion">도착</label> <select name="arriveRegion"
						required="required" class="form-control">
						<option>서울 강북구</option>
						<option>서울 광진구</option>
						<option>서울 도봉구</option>
						<option>경기 고양시</option>
						<option>경기 양주시</option>
						<option selected="selected">경기 의정부시</option>
					</select>
				</div>
				<!-- 지역 검색 버튼 -->
				<button class="btn btn-default" style="margin-top: 25px">검색</button>
			</form>
		</div>

		<!-- 리스트에 따른 결과 출력 -->
		<c:if test="${list != null }">
			<c:forEach items="${list }" var="vo">
				<div class="cp">
					<hr>
					<div class="circle">
						<h4>${vo.psgFixCount }/${vo.seats }</h4>
					</div>
					<div>
						<b><span class="no">${vo.no }</span></b>번 차<br>
						<h4>
							<b>${vo.startAddress } ▶ ${vo.arriveAddress }</b>
						</h4>
						${vo.startTimePre } 출발 예정 | ${vo.arriveTimePre } 도착 예정<br>
						드라이버 <b>${vo.nickname }</b> | ${vo.driveCount }회 운행 | 평균별점 ${vo.starAvg } [${vo.starCount }회 참여]<br>
						동승료 <b>${vo.price }</b> 포인트
					</div>
				</div>
			</c:forEach>
			<!-- 페이지 버튼 -->
			<div class="col-md-9 page" align="center">
				<pageNav:pageNav listURI="list.do" pageObject="${pageObject }" />
			</div>
		</c:if>
		<!-- 검색 결과가 없는 경우 -->
		<c:if test="${list == null && startRegion != null }">
			<div>
				<b>현재 해당 지역에 운행중인 카풀이 없습니다.</b>
			</div>
		</c:if>
		<!-- 드라이버 등급일 경우 카풀 등록 버튼 출력 -->
		<c:if test="${login != null && login.gradeNo == 2 }">
			<div style="margin-top: 10px;">
				<a class="btn btn-default" href="write.do">카풀 등록</a>
			</div>
		</c:if>
	</div>
</body>
</html>