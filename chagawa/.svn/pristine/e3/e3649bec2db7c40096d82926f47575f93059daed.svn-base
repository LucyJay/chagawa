package com.chagawa.member.service;

import com.chagawa.main.ServiceInterface;
import com.chagawa.member.dao.MemberDAO;
import com.chagawa.member.vo.LoginVO;

public class MemberLoginServiceImpl implements ServiceInterface {

	private MemberDAO dao;
	
	@Override
	public void setDao(Object obj) {
		this.dao = (MemberDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		
		LoginVO vo = dao.login((LoginVO)obj);
		if(vo == null) {
			return null;
		} else {
			dao.updateConDate((LoginVO)obj);
			return vo;
		}
	}
	
}
