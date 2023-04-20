package com.chagawa.carpool.service;

import com.chagawa.carpool.dao.CarpoolDAO;
import com.chagawa.carpool.vo.CarpoolVO;
import com.chagawa.main.ServiceInterface;

public class CarpoolViewServiceImpl implements ServiceInterface {

	private CarpoolDAO dao;

	@Override
	public void setDao(Object obj) {
		this.dao = (CarpoolDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		CarpoolVO vo = dao.view((Long) obj);
		// 해당 번호의 카풀이 존재할 경우 동승자 명단도 세팅
		if (vo != null) {
			vo.setPsgList(dao.psgList(vo.getNo()));
		}
		return vo;
	}

}
