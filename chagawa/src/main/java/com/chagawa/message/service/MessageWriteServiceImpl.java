package com.chagawa.message.service;

import com.chagawa.message.dao.MessageDAO;
import com.chagawa.message.vo.MessageVO;
import com.chagawa.main.ServiceInterface;

public class MessageWriteServiceImpl implements ServiceInterface{

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
		String wpar1 = (String) objs[1];
		System.out.println(objs[1]);
		long wno = (long) objs[2];
		System.out.println(objs[2]);
		MessageVO vo = (MessageVO) objs[3];
		return dao.write(id, wpar1, wno,vo);
	}


}
