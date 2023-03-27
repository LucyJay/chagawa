<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 이용내역</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 운행 종료에서 리스트로 들어올 때 자동으로 운행/동승이 선택됨
		if ("${param.isDriver}") {
			$("#isDriver").val("${param.isDriver}");
		}
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

.mylist {
	clear: both;
}

.driveInfo {
	float: left;
}

.reviewBtn {
	margin-right: 25%;
}

.psgInfo {
	clear: both;
	margin-top: 10px;
	margin-left: 150px;
	padding-left: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>카풀 이용내역</h1>
		<!-- 운행내역/동승내역 선택 및 조회 버튼 -->
		<div class="form">
			<form>
				<select id="isDriver" class="form-control"
					style="width: 150px; float: left; margin-right: 20px;"
					name="isDriver" required="required">
					<option value="driver">운행</option>
					<option value="psg">동승</option>
				</select> <input type="hidden" name="id" id="id" value=${login.id }>
				<button class="btn btn-default btn-sm">조회</button>
			</form>
		</div>
		<!-- 리스트가 존재할 경우 리스트에 따라 카풀 정보 출력 -->
		<c:if test="${mylist != null }">
			<div class="mylist">
				<c:forEach items="${mylist }" var="vo">
					<div class="eachList">
						<hr>
						<div class="cpInfo">
							<div class="circle">
								<h4>${vo.psgGotCount}/${vo.psgFixCount }/${vo.seats }</h4>
							</div>
							<div class="driveInfo">
								<b>${vo.no }</b>번 차 <span class="label label-default">${vo.status }</span><br>
								<h4>
									[${vo.startRegion }] <b>${vo.startAddress }</b> ▶
									[${vo.arriveRegion }] <b>${vo.arriveAddress }</b>
								</h4>
								${vo.startTime } 출발 ▷ ${vo.arriveTime } 도착<br> 드라이버 <b>${vo.nickname }</b>
								/ 동승료 <b>${vo.price }</b> 포인트 / 동승자 <b>${vo.psgGotCount }</b>명<br>
								<b>차량정보</b> ${vo.carNo }(${vo.carModel })
							</div>
							<!-- 아직 후기를 쓰지 않은 카풀이면 후기 작성 버튼 출력 -->
							<c:if test="${vo.reviewed == 0 }">
								<div style="height: 60px;"></div>
								<div class="reviewBtn">
									<a href="/epilogue/write.do?cpNo=${vo.no }"
										class="btn btn-primary pull-right">후기작성</a>
								</div>
							</c:if>
						</div>
						<!-- 각 동승자 정보 및 상태라벨 출력 -->
						<div class="well psgInfo" style="width: 30%;">
							<c:forEach items="${vo.psgList }" var="pvo">
								<div class="eachPsg">
									${pvo.nickname } <span class="label label-default">${pvo.status }</span><br>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
				<div class="col-md-9">
					<pageNav:pageNav listURI="list.do" pageObject="${pageObject }" />
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>