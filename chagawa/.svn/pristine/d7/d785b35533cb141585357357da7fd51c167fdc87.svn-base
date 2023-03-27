package com.chagawa.message.service;

import com.chagawa.message.dao.MessageDAO;
import com.chagawa.main.ServiceInterface;

public class UTCServiceimpl implements ServiceInterface{

	// dao 선언
	private MessageDAO dao;
	// setter
	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (MessageDAO)obj;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		Object[] objs = (Object[]) obj;
		long no = (long) objs[0];
		String id = (String) objs[1];
		int x = dao.findpar(no, id);
		System.out.println("x =" + x);
		System.out.println("no = " +no);
		System.out.println("id = " +id);
		return dao.utc(no, id, x);
	}


}
