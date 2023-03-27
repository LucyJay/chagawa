<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카풀 등록</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.leftBox {
	width: 50%;
	height: 600px;
	margin: 5px;
	float: left;
}

.psg {
	width: 40%;
	height: 600px;
	margin: 5px;
	padding-left: 15px;
	float: left;
	border-left: 2px solid #95B7E7;
	float: left;
}

.title {
	font-size: x-large;
	font-weight: bold;
	margin-bottom: 15px;
}

.driverInfo {
	margin-top: 15px;
	margin-bottom: 15px;
}

.driverInfoDetail {
	padding-top: 15px;
	margin-right: 25px;
	float: left;
}

.psgTitle {
	float: left;
	padding-top: 18px;
}

.psgApp, .psgFix {
	margin: 5px 5px 5px 10px;
}

.region {
	font-size: larger;
}

.afterApply {
	clear: both;
	padding-top: 30px;
	font-size: larger;
}

.afterBtn {
	margin-right: 15%;
	margin-top: -5px;
}

.psgInfo {
	clear: left;
}

.circle {
	float: left;
	background-color: #ECF2FA;
	border-radius: 50%;
	width: 70px;
	height: 70px;
	margin: 5px;
}

.circle h4 {
	text-align: center;
	padding-top: 15px;
}

.eachPsg {
	clear: both;
}

.eachInfo {
	padding-top: 25px;
	float: left;
	margin-right: 20px;
}

.photo {
	float: left;
	border-radius: 50%;
	width: 70px;
	height: 70px;
	margin: 5px;
	padding: 0px;
}

.star {
	margin: 60px;
	clear: both;
}
</style>
</head>
<body>
	<div class="container">
		<form action="star.do" method="post">
			<input type="hidden" name="cpNo" value="${vo.no }">
			<h1>운행이 종료되었어요</h1>
			<div class="leftBox">
				<!-- 운행정보 -->
				<div class="title">${vo.no}번차-운행정보
					<button class="btn btn-info btn-lg" style="margin-left: 10px;">${vo.status }</button>
				</div>
				[${vo.startRegion }] <span class="region"><b>${vo.startAddress }</b></span>
				<span class="glyphicon glyphicon-arrow-right"></span>
				[${vo.arriveRegion }] <span class="region"><b>${vo.arriveAddress }</b></span>
				<br> ${vo.startTimePre } 출발예정 - ${vo.arriveTimePre } 도착예정 <br>
				<div class="driver">
					<!-- 드라이버 정보 -->
					<div class="driverInfo">
						<div class="photo">
							<img class="img-circle" style="width: 70px;"
								src="${vo.profileImage }">
						</div>
						<div class="driverInfoDetail">
							드라이버 <b>${vo.nickname }</b><br> ${vo.driveCount }회 운행 | 평균별점
							${vo.starAvg } (${vo.starCount }회 참여)
						</div>
						<!-- 드라이버가 아니고 별점을 아직 안 매겼다면 별점 폼 -->
						<c:if test="${vo.id ne login.id && star == 0}">
							<div>
								<div style="height: 20px"></div>
								<select class="form-control" style="width: 25%;"
									name="${vo.id }" required="required">
									<option value="5" selected="selected">★★★★★</option>
									<option value="4">★★★★☆</option>
									<option value="3">★★★☆☆</option>
									<option value="2">★★☆☆☆</option>
									<option value="1">★☆☆☆☆</option>
								</select>
							</div>
						</c:if>
					</div>
					<div class="well"
						style="clear: both; margin-top: 15px; width: 60%;">
						<b>드라이버 메시지</b><br> ▶ ${vo.memo }
					</div>
					<b>차랑정보</b> ${vo.carModel } ${vo.carNo }<br> <b>동승료</b>
					${vo.price } 포인트
				</div>
				<div class="time">
					<b>예정운행시간</b> ${vo.startTimePre } 출발 ▷ ${vo.arriveTimePre } 도착 <br>
					<b>실제운행시간</b> ${vo.startTime } 출발 ▷ ${vo.arriveTime } 도착
				</div>
			</div>
			<div class="psg">
				<div class="psgApp">
					<!-- 실제 탑승한 동승자 수 -->
					<div class="circle">
						<h4>${vo.psgGotCount}</h4>
					</div>
					<div class="title psgTitle">
						<b>동승자 목록</b>
					</div>
					<div class="psgInfo">
						<!-- 동승자 리스트에서 가져온 각 동승자 정보 -->
						<c:forEach items="${list }" var="pvo">
							<div class="eachPsg">
								<div class="photo">
									<img class="img-circle" style="width: 70px;"
										src="${pvo.profileImage }">
								</div>
								<div class="eachInfo">
									<b>${pvo.nickname }</b>
									<!-- 도착확인 여부에 따른 라벨 출력 -->
									<c:if test="${pvo.status eq '탑승' }">
										<span class="label label-default"> 도착확인대기</span>
									</c:if>
									<c:if test="${pvo.status eq '도착' }">
										<span class="label label-primary"> 도착확인완료</span>
									</c:if>

								</div>
								<!-- 아직 별점을 매기지 않았다면 별점 폼: 본인은 제외 -->
								<c:if test="${star == 0 }">
									<c:if test="${pvo.id ne login.id }">
										<div>
											<div style="height: 20px"></div>
											<select class="form-control" style="width: 35%;"
												name="${pvo.id }" required="required">
												<option value="5" selected="selected">★★★★★</option>
												<option value="4">★★★★☆</option>
												<option value="3">★★★☆☆</option>
												<option value="2">★★☆☆☆</option>
												<option value="1">★☆☆☆☆</option>
											</select>
										</div>
									</c:if>
								</c:if>
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- 아직 별점을 매기지 않았다면 별점 등록 버튼 -->
				<c:if test="${star == 0 }">
					<div class="star">
						<button class="btn btn-primary">별점 등록</button>
					</div>
				</c:if>
			</div>
		</form>
	</div>
</body>
</html>