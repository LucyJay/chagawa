package com.chagawa.starPoint.service;

import com.chagawa.epilogue.dao.EpilogueDAO;
import com.chagawa.main.ServiceInterface;
import com.chagawa.starPoint.vo.StarPointVO;

public class StarPointWriteServiceImpl implements ServiceInterface{
	
	// dao 선언
	private EpilogueDAO dao;
	// setter
	@Override
	public void setDao(Object obj) {
	
		this.dao = (EpilogueDAO)obj;
	}
	
	@Override
	// obj = vo
	public Object service(Object obj) throws Exception {

		System.out.println
		("StarPointWriteServiceImpl.service().vo : " + obj);
		return dao.starPoint((StarPointVO) obj);
	}

} // end of StarPointWriteServiceImpl()
