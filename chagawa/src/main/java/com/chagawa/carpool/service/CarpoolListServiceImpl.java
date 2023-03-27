package com.chagawa.carpool.service;

import com.chagawa.carpool.dao.CarpoolDAO;
import com.chagawa.carpool.vo.CarpoolVO;
import com.chagawa.main.ServiceInterface;
import com.webjjang.util.PageObject;

public class CarpoolListServiceImpl implements ServiceInterface {

	private CarpoolDAO dao;

	@Override
	public void setDao(Object obj) {
		this.dao = (CarpoolDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		Object[] objs = (Object[]) obj;
		CarpoolVO vo = (CarpoolVO) objs[0];
		System.out.println(vo);
		PageObject pageObject = (PageObject) objs[1];
		System.out.println(dao);
		pageObject.setTotalRow(dao.getTotalRow("list", vo.getStartRegion(), vo.getArriveRegion()));
		return dao.list(vo, pageObject);
	}

}
