<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내역</title>

<!-- 라이브러리 등록 - CDN 방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function() {
		// 포인트 충전 팝업 중앙 정렬해서 띄우기
		$("#chargePopupBtn").click(
				function() {
					var width = 900;
					var height = 500;
					var winl = (screen.availWidth - width) / 2;
					var wint = (screen.availHeight - height) / 2;
					window.open("charge.sub", "", "width=" + width
							+ ", height=" + height + ", left=" + winl
							+ ", top=" + wint);
				});

		// 포인트 인출 팝업 중앙 정렬해서 띄우기
		$("#withdrawPopupBtn").click(
				function() {
					var width = 900;
					var height = 500;
					var winl = (screen.availWidth - width) / 2;
					var wint = (screen.availHeight - height) / 2;
					window.open("withdraw.sub", "", "width=" + width
							+ ", height=" + height + ", left=" + winl
							+ ", top=" + wint);
				});
	});
</script>

<style type="text/css">
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

#chargePopupBtn {
	color: white;
	flex: 1;
	margin-bottom: 20px;
	margin-right: 20px;
	height: 60px;
	background-color: #FFA323;
	font-size: 19px;
	font-weight: 600;
}

#withdrawPopupBtn {
	color: white;
	flex: 1;
	margin-bottom: 20px;
	height: 60px;
	background-color: #379956;
	font-size: 19px;
	font-weight: 600;
}
</style>
</head>

<body>
	<div class="container">
		<c:choose>
			<c:when test="${ login != null && login.gradeNo == 9 }">
				<h2 style="text-align: center;">수수료 수입 내역</h2>
				<br>
				<div class="well text-center">
					<h3>총수입&nbsp;&nbsp;-&nbsp;&nbsp;<fmt:formatNumber value="${point}" pattern="#,###"/>원</h3>
				</div>
			</c:when>
			<c:otherwise>
				<h2 style="text-align: center;">포인트 내역</h2>
				<br>
				
			</c:otherwise>
		</c:choose>
		<br>
			<c:if test="${ login != null && login.gradeNo != 9 }">
		<div style="display: flex;">
				<button id="chargePopupBtn" type="button" class="btn">포인트 충전</button>
				<button id="withdrawPopupBtn" type="button" class="btn">포인트 인출</button>
			</div>
			<div class="well text-center">
					<h3 >보유 포인트&nbsp;&nbsp;-&nbsp;&nbsp;<fmt:formatNumber value="${point}" pattern="#,###"/>p</h3>
				</div>
			</c:if>
			
		<table class="table">

			<thead>
				<tr>
					<th>번호</th>
					<th>일자</th>
					<th>유형</th>
					<c:choose>
						<c:when test="${ login != null && login.gradeNo == 9 }">
							<th>금액(원)</th>
						</c:when>
						<c:otherwise>
							<th>포인트</th>
						</c:otherwise>
					</c:choose>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="vo">
					<tr class="dataRow">
						<td class="no">${vo.no }</td>
						<td>${vo.runDate }</td>
						<td>${vo.memo }</td>
						<td><fmt:formatNumber value="${vo.price}" pattern="#,###"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row text-center">
			<pageNav:pageNavPoint listURI="list.do?id=${login.id }" pageObject="${pageObject }" />
		</div>
	</div>
</body>
</html>
