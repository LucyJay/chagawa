package com.chagawa.message.service;

import com.chagawa.message.dao.MessageDAO;
import com.chagawa.main.ServiceInterface;

public class MessageLogServiceImpl implements ServiceInterface{

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
		System.out.println(objs[0]+", "+objs[1]+", "+objs[2]);
		String id = (String) objs[0];
		System.out.println(objs[0]);
		String par1 = (String) objs[1];
		System.out.println(objs[1]);
		long no = (long) objs[2];
		System.out.println(objs[2]);
		return dao.list(id, par1, no);
	}


}
