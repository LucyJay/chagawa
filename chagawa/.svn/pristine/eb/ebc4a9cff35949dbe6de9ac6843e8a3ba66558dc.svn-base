package com.chagawa.epilogue.service;

import com.chagawa.epilogue.dao.EpilogueDAO;
import com.chagawa.epilogue.vo.EpilogueVO;
import com.chagawa.main.ServiceInterface;

public class EpilogueWriteServiceImpl implements ServiceInterface{
	
	// dao 선언
		private EpilogueDAO dao;
		// setter
		@Override
		public void setDao(Object obj) {
		
			this.dao = (EpilogueDAO)obj;
		}
		
		@Override
		// obj = vo
		public Object service(Object obj) throws Exception {

			System.out.println
			("EpilogueWriteServiceImpl.service().vo : " + obj);
			return dao.write((EpilogueVO) obj);
		}

} // end of EpilogueWriteServiceImpl class
