package com.chagawa.epilogue.service;

import com.chagawa.epilogue.dao.EpilogueDAO;
import com.chagawa.epilogue.vo.EpilogueVO;
import com.chagawa.main.ServiceInterface;

public class EpilogueUpdateServiceImpl implements ServiceInterface{

	// dao 선언
	private EpilogueDAO dao;
	
	// setter
	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (EpilogueDAO)obj;
	}
	
	@Override
	// obj = vo
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println
		("EpilogueUpdateServiceImpl.service().vo : " + obj);
		return dao.update((EpilogueVO) obj);
	}
	
} // end of EpilogueUpdateServiceImpl class
