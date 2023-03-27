package com.chagawa.epilogue.service;

import com.chagawa.epilogue.dao.EpilogueDAO;
import com.chagawa.main.ServiceInterface;
import com.webjjang.util.PageObject;

public class EpilogueListServiceImpl implements ServiceInterface{


	// dao 선언
	private EpilogueDAO dao;
	
	// setter
	@Override
	public void setDao(Object obj) {
		
		this.dao = (EpilogueDAO)obj;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		
		System.out.println("EpilogueListServiceImpl.service()");
		
		PageObject pageObject = (PageObject) obj;
		
		// JSP를 위한 페이지 계산을 진행해야 한다. -> 전체 데이터를 가져와서 setTotalRow() 호출
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		
		return dao.list(pageObject);

	}

} // end of EpilogueListServiceImpl class
