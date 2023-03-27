package com.chagawa.member.controller;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.chagawa.main.Execute;
import com.chagawa.main.ServiceInterface;
import com.chagawa.member.vo.LoginVO;
import com.chagawa.member.vo.MemberVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.webjjang.util.PageObject;

public class MemberController {
	
	private ServiceInterface memberLoginService;
	private ServiceInterface memberJoinService;
	private ServiceInterface memberCheckService;
	private ServiceInterface memberMyPageDService;
	private ServiceInterface memberMyPagePService;
	private ServiceInterface memberListService;
	private ServiceInterface memberViewPService;
	private ServiceInterface memberViewDService;
	private ServiceInterface memberChangeStatusService;
	private ServiceInterface memberChangeGradeService;
	private ServiceInterface memberLeaveService;
	private ServiceInterface memberUpdateService;
	private ServiceInterface memberUpdateDService;
	private ServiceInterface memberUpdateImageService;
	private ServiceInterface memberJoinDriverService;
	private ServiceInterface memberChangePwService;
	private ServiceInterface memberFindPwService;
	private ServiceInterface memberFindIdService;
	
	
	public void setMemberLoginService(ServiceInterface memberLoginService) {
		this.memberLoginService = memberLoginService;
	}
	public void setMemberJoinService(ServiceInterface memberJoinService) {
		this.memberJoinService = memberJoinService;
	}
	public void setMemberCheckService(ServiceInterface memberCheckService) {
		this.memberCheckService = memberCheckService;
	}
	public void setMemberMyPageDService(ServiceInterface memberMyPageDService) {
		this.memberMyPageDService = memberMyPageDService;
	}
	public void setMemberMyPagePService(ServiceInterface memberMyPagePService) {
		this.memberMyPagePService = memberMyPagePService;
	}
	public void setMemberListService(ServiceInterface memberListService) {
		this.memberListService = memberListService;
	}
	public void setMemberViewPService(ServiceInterface memberViewPService) {
		this.memberViewPService = memberViewPService;
	}
	public void setMemberViewDService(ServiceInterface memberViewDService) {
		this.memberViewDService = memberViewDService;
	}
	public void setMemberChangeStatusService(ServiceInterface memberChangeStatusService) {
		this.memberChangeStatusService = memberChangeStatusService;
	}
	public void setMemberChangeGradeService(ServiceInterface memberChangeGradeService) {
		this.memberChangeGradeService = memberChangeGradeService;
	}
	public void setMemberLeaveService(ServiceInterface memberLeaveService) {
		this.memberLeaveService = memberLeaveService;
	}
	public void setMemberUpdateService(ServiceInterface memberUpdateService) {
		this.memberUpdateService = memberUpdateService;
	}
	public void setMemberUpdateDService(ServiceInterface memberUpdateDService) {
		this.memberUpdateDService = memberUpdateDService;
	}
	public void setMemberJoinDriverService(ServiceInterface memberJoinDriverService) {
		this.memberJoinDriverService = memberJoinDriverService;
	}
	public void setMemberChangePwService(ServiceInterface memberChangePwService) {
		this.memberChangePwService = memberChangePwService;
	}
	public void setMemberFindPwService(ServiceInterface memberFindPwService) {
		this.memberFindPwService = memberFindPwService;
	}
	public void setMemberFindIdService(ServiceInterface memberFindIdService) {
		this.memberFindIdService = memberFindIdService;
	}
	public void setMemberUpdateImageService(ServiceInterface memberUpdateImageService) {
		this.memberUpdateImageService = memberUpdateImageService;
	}
	
	
	public String execute(HttpServletRequest request) throws Exception {
		System.out.println("MemberController----------------------");
		String uri = request.getRequestURI();
		String method = request.getMethod();
		String jsp = null;
		HttpSession session = request.getSession();
		
		String path = "/upload/member";
		String realPath = request.getServletContext().getRealPath(path);
		System.out.println(realPath);
		int size = 100 * 1024 * 1024;
		
		switch (uri) {
		case "/member/login.do":
			if(method.equals("GET")) {
				jsp = "member/login";
			} else {
				LoginVO loginVO = new LoginVO();
				loginVO.setId(request.getParameter("id"));
				loginVO.setPw(request.getParameter("pw"));
				
				LoginVO statusVO = new LoginVO();
				statusVO = (LoginVO) Execute.run(memberLoginService, loginVO);
				session.setAttribute("login", statusVO);
				if(statusVO == null) {
					request.setAttribute("wrong", 1);
					jsp = "member/login";
				} else if(statusVO.getStatus().equals("탈퇴")) {
					session.removeAttribute("login");
					request.setAttribute("wrong", 2);
					jsp = "member/login";
				} else if(statusVO.getStatus().equals("이용정지")) {
					session.removeAttribute("login");
					request.setAttribute("wrong", 3);
					jsp = "member/login";
				} else {
					jsp = "redirect:/";
				}
			}
			break;
			
			
		case "/member/terms.do":
			jsp = "member/terms";
			break;
			
		case "/member/join.do":
			if(method.equals("GET")) {
				jsp = "member/join";
			} else {
				MultipartRequest multi = new MultipartRequest(request, realPath, size, "utf-8", new DefaultFileRenamePolicy());
				MemberVO joinVO = new MemberVO();
				joinVO.setId(multi.getParameter("id"));
				joinVO.setPw(multi.getParameter("pw"));
				joinVO.setNickname(multi.getParameter("nickname"));
				joinVO.setName(multi.getParameter("name"));
				if(multi.getFilesystemName("profileImage") == null || multi.getFilesystemName("profileImage").trim() == null) {
					joinVO.setProfileImage("/upload/member/chagawa.jpg");
				} else {
					joinVO.setProfileImage(path + "/" + multi.getFilesystemName("profileImage"));
				}
				joinVO.setBirth(multi.getParameter("birth_y")+"."
								+ ( multi.getParameter("birth_m").length()==2 ? multi.getParameter("birth_m") : "0" + multi.getParameter("birth_m") )
								+"."+multi.getParameter("birth_d"));
				joinVO.setGender(multi.getParameter("gender"));
				joinVO.setTel(multi.getParameter("tel_1")+"-"+multi.getParameter("tel_2")+"-"+multi.getParameter("tel_3"));
				joinVO.setBank(multi.getParameter("bank"));
				joinVO.setAccount(multi.getParameter("account"));
				
				Execute.run(memberJoinService, joinVO);
				jsp = "redirect:/";
			}
			break;
			
		case "/member/checkId.sub":
			String id = request.getParameter("id");
			if(Execute.run(memberCheckService, new Object[] {id, "id"}) != null) {
				request.setAttribute("type", 1);
				jsp = "member/checkId";
			} else {
				request.setAttribute("type", 2);
				jsp = "member/checkId";
			}
			break;
			
		case "/member/checkNickname.sub":
			// 중복확인할 값
			String nickname = request.getParameter("nickname");
			// 확인된 중복된 값
			String checkNickname = (String) Execute.run(memberCheckService, new Object[] {nickname, "nickname"});
			
			// 중복되고 로그인 상태라면(수정할 때의 경우)
			if(checkNickname != null && (LoginVO)(session.getAttribute("login")) != null) {
				MemberVO checkNicknameVO = (MemberVO) Execute.run(memberViewPService, ((LoginVO)(session.getAttribute("login"))).getId());
				// 중복된 값이 로그인된 아이디의 값과 일치한다면
				if(checkNickname.equals(checkNicknameVO.getNickname())) {
					request.setAttribute("type", 2);
					jsp = "member/checkNickname";
				} else {
					request.setAttribute("type", 1);
					jsp = "member/checkNickname";
				}
				
			// 중복되고 로그인 안 한 상태라면 (회원가입의 경우)
			} else if(checkNickname != null && (LoginVO)(session.getAttribute("login")) == null) {
				request.setAttribute("type", 1);
				jsp = "member/checkNickname";
				
			// 중복 안 된 상태
			} else {
				request.setAttribute("type", 2);
				jsp = "member/checkNickname";
			}
			break;
			
		case "/member/checkTel.sub":
			// 중복확인할 값
			String tel = request.getParameter("tel_1")+"-"+request.getParameter("tel_2")+"-"+request.getParameter("tel_3");
			request.setAttribute("tel_1", request.getParameter("tel_1"));
			request.setAttribute("tel_2", request.getParameter("tel_2"));
			request.setAttribute("tel_3", request.getParameter("tel_3"));
			// 확인된 중복된 값
			String checkTel = (String) Execute.run(memberCheckService, new Object[] {tel, "tel"});
//			System.out.println(checkTel);
			// 현재 세션의 아이디
//			sessId = (String) session.getAttribute("id");
			// 중복되고 로그인 상태라면(수정할 때의 경우)
//			System.out.println((LoginVO)(session.getAttribute("login")));
			if(checkTel != null && (LoginVO)(session.getAttribute("login")) != null) {
				MemberVO checkTelVO = (MemberVO) Execute.run(memberViewPService, ((LoginVO)(session.getAttribute("login"))).getId());
				// 중복된 값이 로그인된 아이디의 값과 일치한다면
				if(checkTel.equals(checkTelVO.getTel())) {
					request.setAttribute("type", 2);
					jsp = "member/checkTel";
				} else {
					request.setAttribute("type", 1);
					jsp = "member/checkTel";
				}
			// 중복되고 로그인 안 한 상태라면 (회원가입의 경우)
			} else if(checkTel != null && (LoginVO)(session.getAttribute("login")) == null) {
				request.setAttribute("type", 1);
				jsp = "member/checkTel";
			// 중복 안 된 상태
			} else {
				request.setAttribute("type", 2);
				jsp = "member/checkTel";
			}
			break;
			
		case "/member/checkCar.sub":
			// 중복확인할 값
			String carNo = request.getParameter("carNo");
			// 확인된 중복된 값
			String checkCar = (String) Execute.run(memberCheckService, new Object[] {carNo, "carNo"});
			// 중복되고 등급이 2일때(수정할 때의 경우)
			if(checkCar != null && ((LoginVO)(session.getAttribute("login"))).getGradeNo() == 2) {
				MemberVO checkCarVO = (MemberVO) Execute.run(memberViewDService, ((LoginVO)(session.getAttribute("login"))).getId());
				// 중복된 값이 로그인된 아이디의 값과 일치한다면
				if(checkCar.equals(checkCarVO.getCarNo())) {
					request.setAttribute("type", 2);
					jsp = "member/checkCar";
				} else {
					request.setAttribute("type", 1);
					jsp = "member/checkCar";
				}
			// 중복되고 등급이 1일때 (회원가입의 경우)
			} else if(checkCar != null && ((LoginVO)(session.getAttribute("login"))).getGradeNo() == 1) {
				request.setAttribute("type", 1);
				jsp = "member/checkCar";
			// 중복 안 된 상태
			} else {
				request.setAttribute("type", 2);
				jsp = "member/checkCar";
			}
			break;
			
		case "/member/checkLicense.sub":
			String licenseNo = request.getParameter("licenseNo_1")+"-"+request.getParameter("licenseNo_2")+"-"+request.getParameter("licenseNo_3")+"-"+request.getParameter("licenseNo_4");
			request.setAttribute("licenseNo_1", request.getParameter("licenseNo_1"));
			request.setAttribute("licenseNo_2", request.getParameter("licenseNo_2"));
			request.setAttribute("licenseNo_3", request.getParameter("licenseNo_3"));
			request.setAttribute("licenseNo_4", request.getParameter("licenseNo_4"));
			System.out.println(licenseNo);
			if(Execute.run(memberCheckService, new Object[] {licenseNo, "licenseNo"}) != null) {
				request.setAttribute("type", 1);
				jsp = "member/checkLicense";
			} else {
				request.setAttribute("type", 2);
				jsp = "member/checkLicense";
			}
			break;
			
		case "/member/findId.sub":
			if(method.equals("GET")) {
				jsp = "member/findId";
			} else {
				MemberVO findIdVO = new MemberVO();
				findIdVO.setName(request.getParameter("name"));
				findIdVO.setTel(request.getParameter("tel_1")+"-"+request.getParameter("tel_2")+"-"+request.getParameter("tel_3"));
				String findId = (String) Execute.run(memberFindIdService, findIdVO);
				if(findId != null) {
					request.setAttribute("id", findId);
					request.setAttribute("type", 1);
				} else {
					request.setAttribute("type", 3);
				}
				jsp = "member/find";
			}
			break;
			
		case "/member/findPw.sub":
			if(method.equals("GET")) {
				jsp = "member/findPw";
			} else {
				MemberVO findPwVO = new MemberVO();
				findPwVO.setId(request.getParameter("id"));
				findPwVO.setName(request.getParameter("name"));
				findPwVO.setTel(request.getParameter("tel_1")+"-"+request.getParameter("tel_2")+"-"+request.getParameter("tel_3"));
				String findPw = (String) Execute.run(memberFindPwService, findPwVO);
				if(findPw != null) {
					request.setAttribute("pw", findPw);
					request.setAttribute("type", 2);
				} else {
					request.setAttribute("type", 4);
				}
				jsp = "member/find";
			}
			break;
			
		case "/member/find.sub":
			if(method.equals("GET")) {
				request.getParameter("id");
				request.getParameter("pw");
				request.getParameter("type");
				jsp = "member/find";
				
			} else {
				String changePwId = request.getParameter("id");
				String oldPw = request.getParameter("oldPw");
				String pw = request.getParameter("pw");
				System.out.println("changePwId: "+changePwId);
				System.out.println("oldPw: "+oldPw);
				System.out.println("pw: " + pw);
				Integer result = (Integer) Execute.run(memberChangePwService, new Object[] {changePwId, oldPw, pw});
				if(result == 1) {
					jsp = "redirect:notice.sub?id=" + changePwId + "&type=4";
				} else {
					jsp = "redirect:notice.sub?id=" + changePwId + "&type=2";
				}
				
			}
			break;
			
			
		// 회원--------------------------------------------------------------------------------	
			
		case "/member/logout.do":
			session = request.getSession();
			session.removeAttribute("login");
			jsp = "redirect:/?logout=1";
			break;
		
		case "/member/myPage.do":
			String myPageId = ((LoginVO) session.getAttribute("login")).getId();
			myPageService(myPageId, session, memberMyPagePService, memberMyPageDService, request);
//			LoginVO myVO = (LoginVO) session.getAttribute("login");
//			if(myVO.getGradeNo() == 2) {
//				MemberVO myPageVO = (MemberVO) Execute.run(memberMyPageDService, myPageId);
//				request.setAttribute("vo", myPageVO);
//			} else {
//				MemberVO myPageVO = (MemberVO) Execute.run(memberMyPagePService, myPageId);
//				request.setAttribute("vo", myPageVO);
//			}
			jsp = "member/myPage";
			break;
			
		case "/member/update.do":
			String updateId = request.getParameter("id");
			if(method.equals("GET")) {
				myPageService(updateId, session, memberViewPService, memberViewDService, request);
//				MemberVO updateVO = (MemberVO) Execute.run(memberViewPService, updateId);
//				if(updateVO.getGradeNo() == 1 || updateVO.getGradeNo() == 9) {
//					request.setAttribute("vo", updateVO);
//				} else if(updateVO.getGradeNo() == 2) {
//					MemberVO update2VO = (MemberVO) Execute.run(memberViewDService, updateId);
//					request.setAttribute("vo", update2VO);
//				}
				jsp = "member/update";
			} else {
				MemberVO updateVO = new MemberVO();
				updateVO.setId(updateId);
				updateVO.setNickname(request.getParameter("nickname"));
				updateVO.setTel(request.getParameter("tel_1")+"-"+request.getParameter("tel_2")+"-"+request.getParameter("tel_3"));
				updateVO.setBank(request.getParameter("bank"));
				updateVO.setAccount(request.getParameter("account"));
				Execute.run(memberUpdateService, updateVO);
				
				LoginVO update2VO = (LoginVO) session.getAttribute("login");
				if(update2VO.getGradeNo() == 2) {
					updateVO.setCarModel(request.getParameter("carModel"));
					updateVO.setCarNo(request.getParameter("carNo"));
					Execute.run(memberUpdateDService, updateVO);
				}
				jsp = "redirect:myPage.do?id=" + updateId;
			}
			break;
			
		case "/member/updateImage.do":
			MultipartRequest multi = new MultipartRequest(request, realPath, size, "utf-8", new DefaultFileRenamePolicy());
			
			String updateImageId = multi.getParameter("id");
			String deleteFileName = multi.getParameter("deleteFile");
			String realDeleteFile = request.getServletContext().getRealPath(deleteFileName);
			File deleteFile = new File(realDeleteFile);
			MemberVO updateImageVO = new MemberVO();
			
			updateImageVO.setId(updateImageId);
			
			if(multi.getFilesystemName("profileImage") == null) {
				updateImageVO.setProfileImage(path + "/" + multi.getParameter("profileImage"));
			} else {
				updateImageVO.setProfileImage(path + "/" + multi.getFilesystemName("profileImage"));
			}
			
			Execute.run(memberUpdateImageService, updateImageVO);
			
			if(!deleteFile.getName().endsWith("chagawa.jpg")) {
				deleteFile.delete();
			}
			
			jsp = "redirect:myPage.do?id=" + updateImageId;
			break;
			
		case "/member/changePw.sub":
			String changePwId = request.getParameter("id");
			if(method.equals("GET")) {
				jsp = "member/changePw";
			} else {
				changePwId = request.getParameter("id");
				String oldPw = request.getParameter("oldPw");
				String pw = request.getParameter("pw");
				Integer result = (Integer) Execute.run(memberChangePwService, new Object[] {changePwId, oldPw, pw});
				if(result == 1) {
					jsp = "redirect:notice.sub?id=" + changePwId + "&type=1";
				} else {
					jsp = "redirect:notice.sub?id=" + changePwId + "&type=2";
				}
			}
			break;
			
		case "/member/joinDriver.do":
			if(method.equals("GET")) {
				Calendar current = Calendar.getInstance();
				int currentYear  = current.get(Calendar.YEAR);
				int currentMonth = current.get(Calendar.MONTH) + 1;
				int currentDay   = current.get(Calendar.DAY_OF_MONTH);
				
				String birthId =request.getParameter("id");
				MemberVO vo = (MemberVO) Execute.run(memberMyPagePService, birthId);
				int year = Integer.parseInt(vo.getBirth().substring(0, 4));
				int month = Integer.parseInt(vo.getBirth().substring(5, 7));
				int day = Integer.parseInt(vo.getBirth().substring(8));
				
				System.out.println(currentYear);
				System.out.println(currentMonth);
				System.out.println(currentDay);
				System.out.println(year);
				System.out.println(month);
				System.out.println(day);
				
				int age = currentYear - year;
				if (month * 100 + day > currentMonth * 100 + currentDay) age--;
				
				if(age >= 18) {
					jsp = "member/joinDriver";
					
				} else {
//					request.setAttribute("age", 1);
					request.setAttribute("id", ((LoginVO) session.getAttribute("login")).getId());
					jsp = "redirect:myPage.do?age=1";
					
				}
				
			} else {
	        	MemberVO joinDriverVO = new MemberVO();
	        	joinDriverVO.setId(request.getParameter("id"));
	        	joinDriverVO.setCarModel(request.getParameter("carModel"));
	        	joinDriverVO.setCarNo(request.getParameter("carNo"));
	        	joinDriverVO.setLicenseNo(request.getParameter("licenseNo_1")+"-"+request.getParameter("licenseNo_2")+"-"+request.getParameter("licenseNo_3")+"-"+request.getParameter("licenseNo_4"));
	        	Integer result = (Integer) Execute.run(memberJoinDriverService, joinDriverVO);
	        	
	        	if(result == 1) {
	        		joinDriverVO.setGradeNo(2);
	        		Execute.run(memberChangeGradeService, joinDriverVO);
//					request.setAttribute("type", 1);
	        	}
	        	
	        	((LoginVO)(session.getAttribute("login"))).setGradeNo(2);
//				jsp = "redirect:notice.sub?id=" + joinDriverVO.getId() + "&type=3";
				
			}
			break;
			
		case "/member/notice.sub":
			jsp = "member/notice";
			break;
			
		case "/member/leave.do":
			MemberVO deleteVO = new MemberVO();
			deleteVO.setId(request.getParameter("id"));
			deleteVO.setPw(request.getParameter("pw"));
			Integer result = (Integer) Execute.run(memberLeaveService, deleteVO);
			
			if(result == 1) {
	//			deleteFileName = request.getParameter("deleteFile");
	//			realDeleteFile = request.getServletContext().getRealPath(deleteFileName);
	//			deleteFile = new File(realDeleteFile);
	//			deleteFile.delete();
				session = request.getSession();
				session.removeAttribute("login");
				jsp = "redirect:/?leave=1";
				
			} else {
				jsp = "redirect:myPage.do?id=" + deleteVO.getId() + "&wrong=1";
			}
			
			break;
		
		//관리자----------------------------------------------------------------------------------
			
		case "/member/list.do":
			// 페이지 정보와 검색 정보를 받는 처리문(메서드)을 호출해서 해결한다.
			PageObject pageObject = PageObject.getInstance(request);
			
			request.setAttribute("list", Execute.run(memberListService, pageObject));
			request.setAttribute("pageObject", pageObject);
			jsp = "member/list";
			break;
			
		case "/member/view.do":
			String viewId = request.getParameter("id");
			viewService(viewId, session, request);
//			MemberVO viewPVO = (MemberVO) Execute.run(memberViewPService, viewId);
//			if(viewPVO.getGradeNo() == 1 || viewPVO.getGradeNo() == 9) {
//				request.setAttribute("vo", viewPVO);
//			} else if(viewPVO.getGradeNo() == 2) {
//				MemberVO viewDVO = (MemberVO) Execute.run(memberViewDService, viewId);
//				request.setAttribute("vo", viewDVO);
//			}
			jsp = "member/view";
			break;
			
		case "/member/changeStatus.do":
			String changeStatusId = request.getParameter("id");
			if(method.equals("GET")) {
				viewService(changeStatusId, session, request);
//				MemberVO viewVO = (MemberVO) Execute.run(memberViewPService, changeId);
//				if(viewVO.getGradeNo() == 1 || viewVO.getGradeNo() == 9) {
//					request.setAttribute("vo", viewVO);
//				} else if(viewVO.getGradeNo() == 2) {
//					MemberVO view2VO = (MemberVO) Execute.run(memberViewDService, changeId);
//					request.setAttribute("vo", view2VO);
//				}
				jsp = "member/changeStatus";
			} else {
				MemberVO changeVO = new MemberVO();
				changeVO.setId(changeStatusId);
				changeVO.setStatus(request.getParameter("status"));
				Execute.run(memberChangeStatusService, changeVO);
				jsp = "redirect:view.do?id=" + changeStatusId + "&page=" + request.getParameter("page") + "&perPageNum=" + request.getParameter("perPageNum");
			}
			break;
			
		case "/member/changeGrade.do":
			String changeGradeId = request.getParameter("id");
			if(method.equals("GET")) {
				viewService(changeGradeId, session, request);
//				MemberVO viewVO = (MemberVO) Execute.run(memberViewPService, changeId);
//				if(viewVO.getGradeNo() == 1 || viewVO.getGradeNo() == 9) {
//					request.setAttribute("vo", viewVO);
//				} else if(viewVO.getGradeNo() == 2) {
//					MemberVO view2VO = (MemberVO) Execute.run(memberViewDService, changeId);
//					request.setAttribute("vo", view2VO);
//				}
				jsp = "member/changeGrade";
			} else {
				MemberVO changeVO = new MemberVO();
				changeVO.setId(changeGradeId);
				long gradeNo = Long.parseLong(request.getParameter("grade").substring(0, 1));
				changeVO.setGradeNo(gradeNo);
				Execute.run(memberChangeGradeService, changeVO);
				jsp = "redirect:view.do?id=" + changeGradeId + "&page=" + request.getParameter("page") + "&perPageNum=" + request.getParameter("perPageNum");
			}
			break;

		default:
			throw new Exception("잘못된 페이지를 요청하셨습니다.");
		}
		
  		return jsp;
	}
	
	
	
	// view 서비스에 사용되는 메서드
	private void myPageService(String id, HttpSession session, ServiceInterface PService, ServiceInterface DService, HttpServletRequest request) throws Exception {
		LoginVO vo = (LoginVO) session.getAttribute("login");
		if(vo.getGradeNo() == 2) {
			MemberVO vo2 = (MemberVO) Execute.run(DService, id);
			request.setAttribute("vo", vo2);
		} else {
			MemberVO vo2 = (MemberVO) Execute.run(PService, id);
			request.setAttribute("vo", vo2);
		}
	}
	
	private void viewService(String id, HttpSession session, HttpServletRequest request) throws Exception {
		MemberVO vo = (MemberVO) Execute.run(memberViewPService, id);
		if(vo.getGradeNo() == 1 || vo.getGradeNo() == 9) {
			request.setAttribute("vo", vo);
		} else if(vo.getGradeNo() == 2) {
			MemberVO vo2 = (MemberVO) Execute.run(memberViewDService, id);
			request.setAttribute("vo", vo2);
		}
	}
	
}
