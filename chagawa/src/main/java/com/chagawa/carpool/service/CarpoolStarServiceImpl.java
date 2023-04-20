package com.chagawa.carpool.service;

import com.chagawa.carpool.dao.CarpoolDAO;
import com.chagawa.carpool.vo.CarpoolVO;
import com.chagawa.main.ServiceInterface;
import com.chagawa.starPoint.vo.StarPointVO;

public class CarpoolStarServiceImpl implements ServiceInterface {

	private CarpoolDAO dao;

	@Override
	public void setDao(Object obj) {
		this.dao = (CarpoolDAO) obj;
	}

		@Override
		public Object service(Object obj) throws Exception {
			StarPointVO svo = (StarPointVO) obj;
			CarpoolVO vo = new CarpoolVO();
			vo.setNo(svo.getCpNo());
			vo.setId(svo.getStarter());
			vo.setMemo("star");
			vo.setReviewed(1);
			return dao.review(vo);
		}
}
