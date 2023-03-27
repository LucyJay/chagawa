package com.chagawa.messageRoom.service;

import com.chagawa.messageRoom.dao.MessageRoomDAO;
import com.chagawa.main.ServiceInterface;

public class MessageRoomFRNServiceImpl implements ServiceInterface{
	private MessageRoomDAO dao;

	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (MessageRoomDAO)obj;
	}
	
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageRoomFRNServiceImpl.service()");
		Object[] objs = (Object[]) obj;
		String par1 = (String) objs[0];
		String id = (String) objs[1];
		return dao.findroomno(par1,id);
	}




}
