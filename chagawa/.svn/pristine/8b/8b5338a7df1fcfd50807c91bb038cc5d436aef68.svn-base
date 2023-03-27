package com.chagawa.messageRoom.service;

import com.chagawa.messageRoom.dao.MessageRoomDAO;
import com.chagawa.main.ServiceInterface;

public class MessageRoomLeaveServiceImpl implements ServiceInterface{
	private MessageRoomDAO dao;

	@Override
	public void setDao(Object obj) {
		this.dao = (MessageRoomDAO)obj;
	}
	
	public Object service(Object obj) throws Exception {
	
		Object[] objs = (Object[]) obj;
		long roomno = (long) objs[0];
		System.out.println(objs[0]);
		String id = (String) objs[1];
		System.out.println(objs[1]);
		int x = (int) dao.findpar(roomno, id);
		return dao.leave(roomno, id , x);
	}




}
