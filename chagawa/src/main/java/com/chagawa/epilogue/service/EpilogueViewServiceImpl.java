package com.chagawa.epilogue.service;

import com.chagawa.epilogue.dao.EpilogueDAO;
import com.chagawa.main.ServiceInterface;

public class EpilogueViewServiceImpl implements ServiceInterface{

	// dao 선언
	private EpilogueDAO dao;
	
	// setter
	@Override
	public void setDao(Object obj) {
		
		this.dao = (EpilogueDAO)obj;
	}
	
	@Override
	// obj = Object[0] - no, Object[1] - inc
	public Object service(Object obj) throws Exception {
		
		Object[] objs = (Object[])obj;
		long no = (Long)objs[0];
		int inc = (Integer)objs[1];
		System.out.println
		("EpilogueViewServiceImpl.service().no/inc : " + no + "/" + inc);
		// inc = 1이면 조회수 1 증가
		if(inc == 1) dao.increase(no);
		return dao.view(no);
		
	}
	
} // end of EpilogueViewServiceImpl class
