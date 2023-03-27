<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3593b4fa1bdf0517be47b4b4399cb5ac"></script>
<script type="text/javascript">
	$(function() {

		var container = document.getElementById('map'); // 지도를 표시할 div 
		var options = {
			center : new kakao.maps.LatLng(37.73931073401507,
					127.04486202736867), // 지도의 중심좌표
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

		// 마커를 생성합니다
		var startMarker = new kakao.maps.Marker({
			map : map,
			position : new kakao.maps.LatLng(37.73931073401507,
					127.04486202736867),
			title : '출발',
			image : markerImage
		});
		startMarker.setDraggable(true);

		// 마커를 생성합니다
		var arriveMarker = new kakao.maps.Marker({
			map : map,
			position : new kakao.maps.LatLng(37.7393, 127.045),
			title : '도착',
			image : markerImage
		});
		arriveMarker.setDraggable(true);

		// 폼 제출 시 마커의 위도, 경도 정보를 같이 제출
		$("#submit").click(function() {
			let startLatlng = startMarker.getPosition();
			let arriveLatlng = arriveMarker.getPosition();
			$("#startLat").val(startLatlng.getLat());
			$("#startLng").val(startLatlng.getLng());
			$("#arriveLat").val(arriveLatlng.getLat());
			$("#arriveLng").val(arriveLatlng.getLng());
			return true;
		});
		//뒤로가기 버튼
		$("#backBtn").click(function() {
			history.back();
		});
	});
</script>
<style type="text/css">
.leftForm {
	float: left;
	width: 45%;
}

#map {
	margin: 15px 0px 15px 0px;
}

.rightForm {
	float: right;
	padding-left: 15px;
	width: 50%;
}

.region {
	float: left;
	width: 150px;
}

.regionForm {
	margin-bottom: 15px;
}

.address {
	width: 50%;
}

.timeForm {
	margin-bottom: 15px;
	width: 81%;
}

.etcForm {
	margin-bottom: 15px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>
			<b>카풀 등록하기</b>
		</h1>
		<form method="post">
			<input type="hidden" name="id" value="${login.id }"> <input
				type="hidden" id="startLat" name="startLat"> <input
				type="hidden" id="startLng" name="startLng"> <input
				type="hidden" id="arriveLat" name="arriveLat"> <input
				type="hidden" id="arriveLng" name="arriveLng">

			<div class="leftForm">
				<!-- 지도가 들어갈 공간 -->
				<div id="map" style="width: 100%; height: 250px;"></div>

				<div>
					<div>
						<label for="startRegion">출발</label>
						<div class="regionForm">
							<select class="form-control region" name="startRegion"
								required="required" style="margin-right: 5px;">
								<option>서울 강북구</option>
								<option>서울 광진구</option>
								<option>서울 도봉구</option>
								<option>경기 고양시</option>
								<option>경기 양주시</option>
								<option selected="selected">경기 의정부시</option>
							</select> <input class="form-control address" name="startAddress"
								required="required">
						</div>
					</div>
					<div>
						<label for="arriveRegion">도착</label>
						<div class="regionForm">
							<select class="form-control region" name="arriveRegion"
								required="required" style="margin-right: 5px;">
								<option>서울 강북구</option>
								<option>서울 광진구</option>
								<option>서울 도봉구</option>
								<option>경기 고양시</option>
								<option>경기 양주시</option>
								<option selected="selected">경기 의정부시</option>
							</select> <input class="form-control address" name="arriveAddress"
								required="required">
						</div>
					</div>
				</div>
				<div class="timeForm">
					<label for="startTimePre">출발예정시각</label> <input
						class="form-control" name="startTimePre" type="datetime-local">
				</div>
				<div class="timeForm">
					<label for="arriveTimePre">도착예정시각</label> <input
						class="form-control" name="arriveTimePre" type="datetime-local">
				</div>
			</div>
			<div class="rightForm">
				<div class="etcForm">
					<label for="price">동승료</label> <input class="form-control"
						name="price" type="number">
				</div>
				<div class="etcForm">
					<label for="seats">최대동승인원</label> <input class="form-control"
						name="seats" type="number">
				</div>
				<div class="etcForm">
					<label for="memo">드라이버 메시지</label>
					<textarea class="form-control" name="memo"
						placeholder="드라이버 메시지를 입력해 주세요(예시: 음악 들으면서 같이 가실 분~)"></textarea>
				</div>

				<button id="submit" class="btn btn-primary pull-right">카풀
					등록하기</button>
				<button class="btn btn-default pull-right"
					style="margin-right: 5px;" type="button" id="backBtn">이전으로</button>
			</div>
		</form>
	</div>
</body>
</html>