package com.chagawa.error.controller;

import javax.servlet.http.HttpServletRequest;

public class ErrorController {

	
	// 실행 메서드 -> 리턴 String 데이터를 jsp 또는 url 정보가 된다.
	public String execute(HttpServletRequest request) throws Exception{
		System.out.println("ErrorController.execute().request : " + request);
		// 어떤 요청
		String uri = request.getRequestURI();
		String jsp = null;
		// 처리 
		switch (uri) {
		case "/error/500.do":
			jsp = "error/500";
			break;
			
		case "/error/404.do":
			jsp = "error/404";
			break;
			
		case "/error/loginError.do":
			jsp = "error/loginError";
			break;
			
		case "/error/authError.do":
			jsp = "error/authError";
			break;
			
		default:
			jsp ="redirect:/error/404.do";
			request.getSession().setAttribute("uri", uri);	
		}
		return jsp;
	}
	
}
