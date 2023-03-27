package com.chagawa.member.service;

import com.chagawa.main.ServiceInterface;
import com.chagawa.member.dao.MemberDAO;

public class MemberMyPagePServiceImpl implements ServiceInterface {

	private MemberDAO dao;
	
	@Override
	public void setDao(Object obj) {
		this.dao = (MemberDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		
		return dao.myPageP((String)obj);
	}
	
}
