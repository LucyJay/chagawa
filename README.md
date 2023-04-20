# 당신을 위한 차가 와요! 「차가와」
[JSP/Servlet Project] 가이드와 함께하는 서울 투어 예약 사이트

## 🚗 프로젝트 소개
드라이버와 동승자를 연결하는 카풀 서비스 사이트입니다.
* 드라이버 회원이 카풀을 등록하면 다른 회원이 동승을 신청한다.
* 드라이버가 승인한 동승자들과 탑승해 카풀을 하고, 종료 후에는 서로 별점을 매긴다.
* 사이트 운영자는 공지사항을 게시할 수 있다.
* 회원들은 카풀 이용 후 후기를 남길 수 있다.
* 회원들은 사이트 운영자 또는 드라이버와 메시지를 주고받을 수 있다.
* 회원은 포인트를 충전하여, 동승 시 드라이버가 책정한 동승료를 드라이버에게 지불한다.
* 사이트 수입은 포인트 충전 수수료로 하며, 회원은 본인이 얻은 포인트를 인출할 수 있다.

## ⌛ 개발 기간
* 2022.02.01. ~ 2022.03.07.

## 👥 담당자별 개발 내용
* 김태웅(팀장) - 후기 게시판 CRUD
* 정하영(PL) - 카풀 서비스 흐름 기획 및 개발, 카풀 CRUD, 메인 CSS
* 조용우(PM) - 회원 간 메시지 기능
* 주해린(DBA) - 로그인, 회원가입, 등급변경 등 회원관리 시스템
* 김소연(서기) - 공지사항 게시판 CRUD, 포인트 관리 시스템

## ⚙ 개발 환경
* Java 8
* JDK 1.8
* IDE: Eclipse IDE
* Database: Oracle DB 11g XE
* WAS: Tomcat 9

***
## 🔔 사용법
1. SQL Developer에서 계정 생성 후 '차가와 스키마 종합.sql' 파일을 그대로 실행하여 필요한 테이블을 생성한다.
2. Tomcat Server의 Modules에서 포트번호는 80, Path는 "/"로 수정한다.
3. com.chagawa.io.db 패키지의 DB, DAO 클래스 각각의 URI, ID, PW를 DB와 일치하도록 수정한다.
4. 서버가 정상적으로 구동되는 것을 확인한 후 브라우저에서 접속한다.
* 아이디 admin, 비밀번호 1111로 로그인 후 회원 리스트에서 다른 샘플 회원들의 아이디와 등급을 확인하실 수 있습니다.(비밀번호는 모두 1111로 설정되어 있습니다.)


***
## 📚 개발 내용

Wiki 탭을 참조해 주세요. Wiki는 제가 개발한 카풀 서비스에 대해서만 작성되어 있습니다.

카풀 서비스 흐름: <https://github.com/LucyJay/chagawa/wiki/1.-카풀-서비스-흐름>

카풀 서비스 운영 코드 및 화면 함께 보기: <https://github.com/LucyJay/chagawa/wiki/5.-카풀-운영>

카풀 등록: <https://github.com/LucyJay/chagawa/wiki/3.-카풀-등록>