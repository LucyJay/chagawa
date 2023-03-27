package com.chagawa.carpool.service;

import com.chagawa.carpool.dao.CarpoolDAO;
import com.chagawa.carpool.vo.PassengerVO;
import com.chagawa.main.ServiceInterface;

public class CarpoolCancelApplyServiceImpl implements ServiceInterface {

	private CarpoolDAO dao;

	@Override
	public void setDao(Object obj) {
		this.dao = (CarpoolDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		return dao.cancelApply((PassengerVO)obj);
	}
}
