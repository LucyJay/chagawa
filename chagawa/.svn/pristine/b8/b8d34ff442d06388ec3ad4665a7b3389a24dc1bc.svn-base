package com.chagawa.notice.service;

import com.chagawa.main.ServiceInterface;
import com.chagawa.notice.dao.NoticeDAO;
import com.webjjang.util.PageObject;

public class NoticeListServiceImpl implements ServiceInterface {

	private NoticeDAO dao;

	@Override
	public void setDao(Object obj) {
		// TODO Auto-generated method stub
		this.dao = (NoticeDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		PageObject pageObject = (PageObject) obj;
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		return dao.list(pageObject);
	}

}
