package com.chagawa.member.service;

import com.chagawa.main.ServiceInterface;
import com.chagawa.member.dao.MemberDAO;

public class MemberCheckServiceImpl implements ServiceInterface {

	private MemberDAO dao;
	
	@Override
	public void setDao(Object obj) {
		this.dao = (MemberDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		
		Object[] objs = (Object[]) obj;
		String data = (String) objs[0];
		String colName = (String) objs[1];
		
		return dao.check(data, colName);
	}
	
}
