package com.chagawa.member.dao;

import java.util.List;

import com.chagawa.member.vo.LoginVO;
import com.chagawa.member.vo.MemberVO;
import com.webjjang.util.PageObject;

public interface MemberDAO {
	
	public LoginVO login(LoginVO inVO) throws Exception;
	public Integer updateConDate(LoginVO vo) throws Exception;
	public Integer join(MemberVO vo) throws Exception;
	public String check(String data, String colName) throws Exception;
	public String findId(MemberVO vo) throws Exception;
	public String findPw(MemberVO vo) throws Exception;
	
	//회원-----------------------------------------------------
	public MemberVO myPageD(String id) throws Exception;
	public MemberVO myPageP(String id) throws Exception;
	public Integer update(MemberVO vo) throws Exception;
	public Integer updateD(MemberVO vo) throws Exception;
	public Integer updateImage(MemberVO vo) throws Exception;
	public Integer changePw(String id, String pw, String newPw) throws Exception;
	public Integer joinDriver(MemberVO vo) throws Exception;
	public Integer leave(MemberVO vo) throws Exception;
	
	//관리자----------------------------------------------------
	public List<MemberVO> list(PageObject pageObject) throws Exception;
	public long getTotalRow(PageObject pageObject) throws Exception;
	public MemberVO viewD(String id) throws Exception;
	public MemberVO viewP(String id) throws Exception;
	public Integer changeStatus(MemberVO vo) throws Exception;
	public Integer changeGrade(MemberVO vo) throws Exception;
	
}
