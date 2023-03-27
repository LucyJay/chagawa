package com.chagawa.member.service;

import com.chagawa.main.ServiceInterface;
import com.chagawa.member.dao.MemberDAO;
import com.chagawa.member.vo.MemberVO;

public class MemberFindIdServiceImpl implements ServiceInterface {

	private MemberDAO dao;
	
	@Override
	public void setDao(Object obj) {
		this.dao = (MemberDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		
		return dao.findId((MemberVO)obj);
	}
	
}
