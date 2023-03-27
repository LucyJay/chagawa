package com.chagawa.point.service;

import com.chagawa.main.ServiceInterface;
import com.chagawa.point.dao.PointDAO;
import com.webjjang.util.PageObject;

public class PointListServiceImpl implements ServiceInterface {

	private PointDAO dao;

	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (PointDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		Object[] objs = (Object[]) obj;
		
		String id = (String) objs[0];
		PageObject pageObject = (PageObject) objs[1];
		
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		
		return dao.list(id, pageObject);
	}

}
