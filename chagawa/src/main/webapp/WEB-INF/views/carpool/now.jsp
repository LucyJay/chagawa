<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용 중인 카풀</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey="></script>
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
	});
</script>
<style type="text/css">
.leftBox {
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

.startBtn {
	float: left;
	margin-right: 5px;
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
}

.photo {
	float: left;
	border-radius: 50%;
	width: 70px;
	height: 70px;
	margin: 5px;
	padding: 0px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>이용 중인 카풀</h1>

		<div class="leftBox">
			<div class="info">
				<!-- 카풀 운행정보 -->
				<div class="title">${vo.no}번차-운행정보
					<button class="btn btn-info btn-lg" style="margin-left: 10px;">${vo.status }</button>
				</div>
				[${vo.startRegion }] <span class="region"><b>${vo.startAddress }</b></span>
				<span class="glyphicon glyphicon-arrow-right"></span>
				[${vo.arriveRegion }] <span class="region"><b>${vo.arriveAddress }</b></span>
				<br> ${vo.startTimePre } 출발예정 - ${vo.arriveTimePre } 도착예정 <br>
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
						<!-- 드라이버 본인이 아닐 경우 메시지 보내기 버튼 -->
						<c:if test="${pstatus ne null}">
							<a class="btn btn-primary pull-right afterBtn"
								style="margin-top: -35px;"
								href="/messageroom/write.do?par1=${vo.id }">메시지 보내기</a>
						</c:if>
					</div>
					<div class="well"
						style="clear: both; margin-top: 15px; width: 60%;">
						<b>드라이버 메시지</b><br> ▶ ${vo.memo }
					</div>
					<b>차랑정보</b> ${vo.carModel } ${vo.carNo }<br> <b>동승료</b>
					${vo.price } 포인트
				</div>
				<hr>
			</div>
			<div class="driving">
				<!-- 좌측 하단: 운행중일 경우 출발시간, 도착일 경우 출발/도착시간 표기 -->
				<c:if test="${vo.status eq '도착' || vo.status eq '운행중'}">
					<div class="time">
						출발시간 : ${vo.startTime }
						<c:if test="${vo.status eq '도착'}">
							<br>도착시간 : ${vo.arriveTime }
						</c:if>
					</div>
				</c:if>
				<!-- 좌측 하단: 드라이버일 경우 나오는 상태별 버튼들 -->
				<c:if test="${pstatus eq null}">
					<!-- 출발대기인 경우 출발/운행취소 버튼 -->
					<c:if test="${vo.status eq '출발대기' }">
						<div class="drivingBtns">
							<form action="start.do?cpNo=${vo.no }" method="post">
								<button class="btn btn-primary startBtn">출발하기</button>
							</form>
							<form action="cancel.do?cpNo=${vo.no }" method="post">
								<button class="btn btn-default">운행취소</button>
							</form>
						</div>
					</c:if>
					<!-- 운행중인 경우 도착 버튼 -->
					<c:if test="${vo.status eq '운행중'}">
						<div class="drivingBtns">
							<form action="arrive.do?cpNo=${vo.no }" method="post">
								<button class="btn btn-primary">도착하기</button>
							</form>
						</div>
					</c:if>
				</c:if>
			</div>
		</div>
		<!-- 상태에 따른 우측 동승자 현황 및 동승자 버튼 -->
		<div class="psg">
			<!-- 출발대기인 경우: 탑승자 수/확정자 수 출력 -->
			<c:if test="${vo.status eq '출발대기'}">
				<div class="psgApp">
					<div class="circle">
						<h4>${vo.psgGotCount}/${vo.psgFixCount }</h4>
					</div>
					<div class="title psgTitle">
						<b>동승자 탑승현황</b>
					</div>
					<div class="psgInfo">
						<!-- 동승확정자 리스트 및 정보 -->
						<c:forEach items="${list }" var="pvo">
							<div class="eachPsg">
								<div class="photo">
									<img class="img-circle" style="width: 70px;"
										src="${pvo.profileImage }">
								</div>
								<div class="eachInfo">
									<b>${pvo.nickname }</b>
									<!-- 아직 탑승하지 않은 경우 - 본인이면 탑승 버튼 출력, 본인이 아니면 탑승대기 라벨 -->
									<c:if test="${pvo.status eq '확정' }">
										<c:if test="${pvo.id eq login.id }">
											<form action="getin.do?cpNo=${vo.no }" method="post">
												<button class="btn btn-primary btn-sm">탑승하기</button>
											</form>
										</c:if>
										<c:if test="${pvo.id ne login.id }">
											<span class="label label-default"> 탑승대기</span>

										</c:if>
									</c:if>
									<!-- 탑승한 경우 탑승완료 라벨 -->
									<c:if test="${pvo.status eq '탑승' }">
										<span class="label label-primary"> 탑승완료</span>
									</c:if>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:if>
			<!-- 출발대기가 아닌 경우(운행중, 도착) 실 탑승자 리스트 -->
			<c:if test="${vo.status ne '출발대기'}">
				<div class="psgApp">
					<div class="circle">
						<h4>${vo.psgGotCount}</h4>
					</div>
					<div class="title psgTitle">
						<b>동승자 목록</b>
					</div>
					<div class="psgInfo">
						<!-- 실 탑승자 리스트의 각 동승자 정보 -->
						<c:forEach items="${gotInList }" var="gvo">
							<div class="eachPsg">
								<div class="photo">
									<img class="img-circle" style="width: 70px;"
										src="${gvo.profileImage }">
								</div>
								<div class="eachInfo">
									<b>${gvo.nickname }</b>
									<!-- 운행상태가 도착인 경우 라벨, 버튼 출력 -->
									<c:if test="${vo.status eq '도착' }">
										<!-- 본인인 경우 도착확인 버튼 - 이후 finish.jsp로 이동됨 -->
										<c:if test="${gvo.id eq login.id }">
											<form action="arrive.do?cpNo=${vo.no }&driver=0"
												method="post">
												<button class="btn btn-primary btn-sm">도착확인</button>
											</form>
										</c:if>
										<!-- 본인이 아닌 경우 도착확인 여부에 따른 라벨 출력 -->
										<c:if test="${gvo.id ne login.id }">
											<c:if test="${gvo.status eq '탑승' }">
												<span class="label label-default"> 도착확인대기</span>
											</c:if>
											<c:if test="${gvo.status eq '도착' }">
												<span class="label label-primary"> 도착확인완료</span>
											</c:if>
										</c:if>
									</c:if>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>