package com.chagawa.message.service;

import com.chagawa.message.dao.MessageDAO;
import com.chagawa.main.ServiceInterface;

public class MessageAlertServiceImpl implements ServiceInterface{

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
		String id = (String) obj;
		return dao.alert(id);
	}


}
