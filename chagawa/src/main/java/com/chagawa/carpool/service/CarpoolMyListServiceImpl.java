package com.chagawa.carpool.service;

import java.util.List;

import com.chagawa.carpool.dao.CarpoolDAO;
import com.chagawa.carpool.vo.CarpoolVO;
import com.chagawa.main.ServiceInterface;
import com.webjjang.util.PageObject;

public class CarpoolMyListServiceImpl implements ServiceInterface {

	private CarpoolDAO dao;

	@Override
	public void setDao(Object obj) {
		this.dao = (CarpoolDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		Object[] objs = (Object[]) obj;
		String id = (String) objs[0];
		PageObject pageObject = (PageObject) objs[1];
		String isDriver = (String) objs[2];
		pageObject.setTotalRow(dao.getTotalRow(isDriver, id, null));
		List<CarpoolVO> list = dao.myList(id, isDriver, pageObject);
		if (list != null) {
			for (CarpoolVO vo : list) {
				vo.setPsgList(dao.psgPerDriveList(vo.getNo()));
			}
		}
		return list;
	}

}
