package com.chagawa.notice.service;

import com.chagawa.main.ServiceInterface;
import com.chagawa.notice.dao.NoticeDAO;

public class NoticeViewServiceImpl implements ServiceInterface {

	private NoticeDAO dao;

	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (NoticeDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.view((Long) obj);
	}

}
