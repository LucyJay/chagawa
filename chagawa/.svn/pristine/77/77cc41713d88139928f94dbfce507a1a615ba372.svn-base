package com.chagawa.notice.controller;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.chagawa.main.ServiceInterface;
import com.chagawa.member.vo.LoginVO;
import com.chagawa.notice.vo.NoticeVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.chagawa.main.Execute;
import com.webjjang.util.PageObject;

public class NoticeController {

	private ServiceInterface noticeListService;
	private ServiceInterface currentNoticeListService;
	private ServiceInterface noticeViewService;
	private ServiceInterface noticeWriteService;
	private ServiceInterface noticeUpdateService;
	private ServiceInterface noticeUpdateImgService;
	private ServiceInterface noticeUpdateGnrService;
	private ServiceInterface noticeDeleteService;

	public void setNoticeListService(ServiceInterface noticeListService) {
		this.noticeListService = noticeListService;
	}

	public void setCurrentNoticeListService(ServiceInterface currentNoticeListService) {
		this.currentNoticeListService = currentNoticeListService;
	}

	public void setNoticeViewService(ServiceInterface noticeViewService) {
		this.noticeViewService = noticeViewService;
	}

	public void setNoticeWriteService(ServiceInterface noticeWriteService) {
		this.noticeWriteService = noticeWriteService;
	}

	public void setNoticeUpdateService(ServiceInterface noticeUpdateService) {
		this.noticeUpdateService = noticeUpdateService;
	}

	public void setNoticeUpdateImgService(ServiceInterface noticeUpdateImgService) {
		this.noticeUpdateImgService = noticeUpdateImgService;
	}

	public void setNoticeUpdateGnrService(ServiceInterface noticeUpdateGnrService) {
		this.noticeUpdateGnrService = noticeUpdateGnrService;
	}

	public void setNoticeDeleteService(ServiceInterface noticeDeleteService) {
		this.noticeDeleteService = noticeDeleteService;
	}

	public String execute(HttpServletRequest request) throws Exception {
		System.out.println("NoticeController.execute().request - " + request);
		String uri = request.getRequestURI();
		String method = request.getMethod();
		System.out.println("NoticeController.execute().method - " + method);

		String path = "/upload/notice";
		String realPath = request.getServletContext().getRealPath(path);
		int size = 100 * 1024 * 1024;
		String jsp = null;

		switch (uri) {

		// 리스트
		case "/notice/list.do":
			PageObject pageObject = PageObject.getInstance(request);
			LoginVO login = (LoginVO) request.getSession().getAttribute("login");
			// 비회원과 일반 회원은 현재 공지 사항만 보임
			if (login == null || login.getGradeNo() == 1 || login.getGradeNo() == 2) {
				request.setAttribute("list", Execute.run(currentNoticeListService, pageObject));
				// 관리자는 전체 공지 사항 보임
			} else if (login.getGradeNo() == 9) {
				request.setAttribute("list", Execute.run(noticeListService, pageObject));
			}
			request.setAttribute("pageObject", pageObject);
			jsp = "notice/list";
			break;

		// 보기
		case "/notice/view.do":
			String noStr = request.getParameter("no");
			long no = Long.parseLong(noStr);
			NoticeVO viewVO = (NoticeVO) Execute.run(noticeViewService, no);
			viewVO.setContent(viewVO.getContent().replace("\n", "<br/>"));
			request.setAttribute("vo", viewVO);
			jsp = "notice/view";
			break;

		// 등록
		case "/notice/write.do":
			if (request.getMethod().equals("GET")) {
				jsp = "notice/write";
			} else {
				MultipartRequest multi = new MultipartRequest(request, realPath, size, "utf-8",
						new DefaultFileRenamePolicy());

				NoticeVO writeVO = new NoticeVO();
				writeVO.setTitle(multi.getParameter("title"));
				writeVO.setContent(multi.getParameter("content"));
				writeVO.setStartDate(multi.getParameter("startDate"));
				writeVO.setEndDate(multi.getParameter("endDate"));
				writeVO.setGnrFile(path + "/" + multi.getFilesystemName("gnrFile"));
				writeVO.setImgFile(path + "/" + multi.getFilesystemName("imgFile"));
				Execute.run(noticeWriteService, writeVO);
				jsp = "redirect:list.do?perPageNum=" + multi.getParameter("perPageNum");
			}
			break;

		// 수정
		case "/notice/update.do":
			noStr = request.getParameter("no");
			no = Long.parseLong(noStr);
			if (request.getMethod().equals("GET")) {
				request.setAttribute("vo", Execute.run(noticeViewService, no));
				jsp = "notice/update";
			} else {
				NoticeVO updateVO = new NoticeVO();
				updateVO.setNo(no);
				updateVO.setTitle(request.getParameter("title"));
				updateVO.setContent(request.getParameter("content"));
				updateVO.setStartDate(request.getParameter("startDate"));
				updateVO.setEndDate(request.getParameter("endDate"));
				Execute.run(noticeUpdateService, updateVO);
				jsp = "redirect:view.do?no=" + no + "&page=" + request.getParameter("page") + "&perPageNum="
						+ request.getParameter("perPageNum") + "&key=" + request.getParameter("key") + "&word="
						+ URLEncoder.encode(request.getParameter("word"), "utf-8");
			}
			break;

		// 이미지 변경
		case "/notice/updateImg.do":
			// 파일 업로드를 실행
			MultipartRequest multi = new MultipartRequest(request, realPath, size, "utf-8",
					new DefaultFileRenamePolicy());
			// 데이터 수집
			String updateImageNoStr = multi.getParameter("no");
			long updateImageNo = Long.parseLong(updateImageNoStr);
			// 삭제할 이미지 파일
			String deleteFileName = multi.getParameter("deleteFile");
			String realDeleteFile = request.getServletContext().getRealPath(deleteFileName);
			File deleteFile = new File(realDeleteFile);
			if (deleteFile.exists())
				System.out.println("삭제 파일이 존재합니다.");
			NoticeVO updateImageVO = new NoticeVO();
			// id는 session에
			updateImageVO.setNo(updateImageNo);
			updateImageVO.setImgFile(path + "/" + multi.getFilesystemName("imgFile"));
			// 등록 처리
			Execute.run(noticeUpdateImgService, updateImageVO);
			// 기존 파일 삭제 처리
			deleteFile.delete();
			jsp = "redirect:view.do?no=" + updateImageNo;
			break;

		// 일반 파일 변경
		case "/notice/updateGnr.do":
			MultipartRequest multi2 = new MultipartRequest(request, realPath, size, "utf-8",
					new DefaultFileRenamePolicy());
			// 데이터 수집
			String updateGnrNoStr = multi2.getParameter("no");
			long updateGnrNo = Long.parseLong(updateGnrNoStr);
			// 삭제할 일반 파일
			String deleteGnrFileName = multi2.getParameter("deleteGnrFile");
			String realDeleteGnrFile = request.getServletContext().getRealPath(deleteGnrFileName);
			File deleteGnrFile = new File(realDeleteGnrFile);
			if (deleteGnrFile.exists())
				System.out.println("삭제 파일이 존재합니다.");
			NoticeVO updateGnrVO = new NoticeVO();
			// id는 session에
			updateGnrVO.setNo(updateGnrNo);
			updateGnrVO.setGnrFile(path + "/" + multi2.getFilesystemName("gnrFile"));
			// 등록 처리
			Execute.run(noticeUpdateGnrService, updateGnrVO);
			// 기존 파일 삭제 처리
			deleteGnrFile.delete();
			jsp = "redirect:view.do?no=" + updateGnrNo;
			break;

		// 삭제
		case "/notice/delete.do":
			noStr = request.getParameter("no");
			no = Long.parseLong(noStr);
			NoticeVO deleteVO = new NoticeVO();
			deleteVO.setNo(no);
			Execute.run(noticeDeleteService, deleteVO);
			jsp = "redirect:list.do?perPageNum=" + request.getParameter("perPageNum");
			break;

		default:
			jsp = "redirect:/error/404.do";
			request.getSession().setAttribute("uri", uri);
		}
		return jsp;

	}

}
