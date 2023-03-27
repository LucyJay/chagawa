package com.chagawa.carpool.service;

import com.chagawa.carpool.dao.CarpoolDAO;
import com.chagawa.carpool.vo.CarpoolVO;
import com.chagawa.main.ServiceInterface;

public class CarpoolArriveServiceImpl implements ServiceInterface {

	private CarpoolDAO dao;

	@Override
	public void setDao(Object obj) {
		this.dao = (CarpoolDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		CarpoolVO vo = new CarpoolVO();
		vo.setNo((Long) obj);
		vo.setStatus("도착");
		dao.updateCpStatus(vo); // 카풀 상태 도착으로 변경
		
		Long no = vo.getNo();
		Integer unchecked = dao.uncheckedPsg(no); // 도착 확인 안 한 사람 수 확인
		if (unchecked == 0) { //다 확인했으면
			vo.setStatus("종료");
			dao.updateCpStatus(vo); // 카풀 상태 종료로 변경
		}
		return unchecked; // 도착 확인 안 한 사람 수 반환
		
	}
}
