<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3593b4fa1bdf0517be47b4b4399cb5ac"></script>
<script type="text/javascript">
	$(function() {

		var container = document.getElementById('map'); // 지도를 표시할 div 
		
		//시작, 도착지점의 좌표
		var startLatlng = new kakao.maps.LatLng(${vo.startLat}, ${vo.startLng});
		var arriveLatlng = new kakao.maps.LatLng(${vo.arriveLat}, ${vo.arriveLng});
	    

		var options = {
			center : startLatlng, // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(container, options);

		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

		// 마커 이미지의 이미지 크기 입니다
		var imageSize = new kakao.maps.Size(24, 35);
		// 마커 이미지를 생성합니다    
		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

		//마커 생성
		var startMarker = new kakao.maps.Marker({
			map : map,
			position : startLatlng,
			title : '출발',
			image : markerImage
		});
		var arriveMarker = new kakao.maps.Marker({
			map : map,
			position : arriveLatlng,
			title : '도착',
			image : markerImage
		});
		
		// 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
		var bounds = new kakao.maps.LatLngBounds();    
		bounds.extend(startLatlng);
		bounds.extend(arriveLatlng);
		map.setBounds(bounds);
		
// 		동승인원 다 찼을 시 태우기 불가
		$(".fixBtn").click(function() {
			if (parseInt("${vo.psgFixCount}") >= parseInt("${vo.seats}")) {
				alert("최대 동승인원 이상 태울 수 없습니다.");
				return false;
			}
		});
	});
</script>

<style type="text/css">
.info {
	width: 50%;
	height: 600px;
	margin: 5px;
	float: left;
}

#map {
	margin: 15px 0px 15px 0px;
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

.photo {
	float: left;
	border-radius: 50%;
	width: 70px;
	height: 70px;
	margin: 5px;
	padding: 0px;
}

.psgButton {
	float: right;
	margin-top: -50px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>
			<b>동승자를 모집하고 있어요</b>
		</h1>
		<div class="info">
			<!-- 		운행정보 -->
			<div class="title">${vo.no}번차-운행정보</div>
			[${vo.startRegion }] <span class="region"><b>${vo.startAddress }</b></span>
			<span class="glyphicon glyphicon-arrow-right"></span>
			[${vo.arriveRegion }] <span class="region"><b>${vo.arriveAddress }</b></span>
			<br> ${vo.startTimePre } 출발 - ${vo.arriveTimePre } 도착 <br>

			<!-- 지도 -->
			<div id="map" style="width: 100%; height: 250px;"></div>

			<!-- 드라이버 정보 -->
			<div class="driver">
				<div class="driverInfo">
					<div class="photo">
						<img class="img-circle" style="width: 70px;"
							src="${vo.profileImage }">
					</div>
					<div class="driverInfoDetail">
						드라이버 <b>${vo.nickname }</b><br> ${vo.driveCount }회 운행 | 평균별점
						${vo.starAvg } (${vo.starCount }회 참여)
					</div>
				</div>
				<div class="well" style="clear: both; margin-top: 15px; width: 60%;">
					<b>드라이버 메시지</b><br> ▶ ${vo.memo }
				</div>
				<b>차랑정보</b> ${vo.carModel } ${vo.carNo }<br> <b>동승료</b>
				${vo.price } 포인트
			</div>
		</div>
		<div class="psg">
			<div class="psgApp">
				<!-- 원 안에 동승신청자 수 -->
				<div class="circle">
					<h4>${vo.psgAppCount }</h4>
				</div>
				<div class="title psgTitle">
					<b> 동승신청자</b>
				</div>
				<div class="psgInfo">
					<!-- 동승신청자 리스트에서 받아온 정보 : 사진, 각 정보 등 -->
					<c:forEach items="${psgAppList }" var="pavo">
						<div class="eachPsg">
							<div class="photo">
								<img class="img-circle" style="width: 70px;"
									src="${pavo.profileImage }">
							</div>
							<div class="eachInfo">
								<b>${pavo.nickname }</b><br> 동승횟수 ${pavo.psgCount }회 | 평균별점
								${pavo.starAvg } (${pavo.starCount }명 참여) <br> ▶ ${pavo.msg }
							</div>
							<!-- 운전자인 경우 각 동승신청자 옆에 태우기 버튼 출력 -->
							<c:if test="${login != null && login.id == vo.id }">
								<div class="psgButton">
									<form action="fix.do?psgId=${pavo.id }&cpNo=${vo.no}"
										method="post">
										<button class="btn btn-primary fixBtn">태우기</button>
									</form>
								</div>
							</c:if>
						</div>
					</c:forEach>
				</div>
			</div>
			<hr>
			<div class="psgFix">
				<!-- 원 안에 동승확정자 수 -->
				<div class="circle">
					<h4>${vo.psgFixCount }/${vo.seats }</h4>
				</div>
				<div class="title psgTitle">
					<b> 동승확정자</b>
				</div>
				<div class="psgInfo">
					<!-- 동승확정자 리스트에서 받아온 정보 -->
					<c:forEach items="${psgFixList }" var="pfvo">
						<div class="eachPsg">
							<div class="photo">
								<img class="img-circle" style="width: 70px;"
									src="${pfvo.profileImage }">
							</div>
							<div class="eachInfo">
								<b>${pfvo.nickname }</b><br> 동승횟수 ${pfvo.psgCount }회 | 평균별점
								${pfvo.starAvg } (${pfvo.starCount }명 참여) <br> ▶ ${pfvo.msg }
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<br>
<!-- 운전자 전용 버튼: 마감, 운행취소 -->
			<form action="stopapply.do?&cpNo=${vo.no}" method="post">
				<button class="btn btn-primary pull-right">마감하기</button>
			</form>
			<form action="cancel.do?&cpNo=${vo.no}" method="post">
				<button class="btn btn-default pull-right"
					style="margin-right: 5px;">운행취소</button>
			</form>


		</div>
	</div>
</body>
</html>