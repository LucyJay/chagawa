package com.chagawa.carpool.service;

import java.util.List;

import com.chagawa.carpool.dao.CarpoolDAO;
import com.chagawa.carpool.vo.CarpoolVO;
import com.chagawa.carpool.vo.PassengerVO;
import com.chagawa.main.ServiceInterface;

public class CarpoolCancelServiceImpl implements ServiceInterface {

	private CarpoolDAO dao;

	@Override
	public void setDao(Object obj) {
		this.dao = (CarpoolDAO) obj;
	}

	@Override
	public Object service(Object obj) throws Exception {
		
		Long no = (Long) obj;
		List<PassengerVO> idList = dao.psgList(no); // 취소 메시지 발송용 명단
		
		dao.delUnfixed(no); //미확정 동승자 데이터 삭제
		
		PassengerVO pvo = new PassengerVO();
		pvo.setStatus("취소");
		pvo.setCpNo(no);
		dao.updatePsgStatus(pvo); //확정 동승자 상태 취소로 변경
		
		CarpoolVO vo = new CarpoolVO();
		vo.setNo(no);
		vo.setStatus("취소");
		dao.updateCpStatus(vo); //카풀 상태 취소로 변경
		
		return idList;
	}
}
