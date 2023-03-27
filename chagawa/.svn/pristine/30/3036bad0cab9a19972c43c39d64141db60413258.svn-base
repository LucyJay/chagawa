package com.chagawa.notice.dao;

import java.util.List;

import com.chagawa.notice.vo.NoticeVO;
import com.webjjang.util.PageObject;

public interface NoticeDAO {

	public List<NoticeVO> list(PageObject pageObject) throws Exception;
	
	public List<NoticeVO> currentList(PageObject pageObject) throws Exception;

	public long getTotalRow(PageObject pageObject) throws Exception;

	public NoticeVO view(long no) throws Exception;

	public int write(NoticeVO vo) throws Exception;

	public int update(NoticeVO vo) throws Exception;
	
	public int updateImg(NoticeVO vo) throws Exception;
	
	public int updateGnr(NoticeVO vo) throws Exception;

	public int delete(NoticeVO vo) throws Exception;

}
