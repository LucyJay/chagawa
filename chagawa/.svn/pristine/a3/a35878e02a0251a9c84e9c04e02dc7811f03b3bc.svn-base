package com.chagawa.messageRoom.service;

import com.chagawa.messageRoom.dao.MessageRoomDAO;
import com.chagawa.main.ServiceInterface;

public class MessageRoomIncreaseServiceimpl implements ServiceInterface{

	// dao 선언
	private MessageRoomDAO dao;
	// setter
	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (MessageRoomDAO)obj;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		Object[] objs = (Object[]) obj;
		long roomno = (long) objs[0];
		String par = (String) objs[1];
		int x = dao.findpar(roomno, par);
		return dao.increase(roomno, par, x);
	}


}
