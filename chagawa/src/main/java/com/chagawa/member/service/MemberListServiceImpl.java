package com.chagawa.member.service;

import com.chagawa.main.ServiceInterface;
import com.chagawa.member.dao.MemberDAO;
import com.webjjang.util.PageObject;

public class MemberListServiceImpl implements ServiceInterface {

	private MemberDAO dao;
	
	@Override
	public void setDao(Object obj) {
		this.dao = (MemberDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		
		PageObject pageObject = (PageObject) obj;
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		
		return dao.list(pageObject);
	}
	
}
