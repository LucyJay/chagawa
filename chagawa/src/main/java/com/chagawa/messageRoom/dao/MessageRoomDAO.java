package com.chagawa.messageRoom.dao;

import java.util.List;

import com.chagawa.messageRoom.vo.MessageRoomVO;


public interface MessageRoomDAO {


	List<MessageRoomVO> list(String id) throws Exception;


	public int write(String id, String par1) throws Exception;

	public int leave(long roomno ,String id, int par) throws Exception;

	public long findroomno(String par1, String id) throws Exception;

	public int findpar(long roomno, String id) throws Exception;

	public int increase(long roomno, String id, int x) throws Exception;

	public int findopposite(long roomno, String id) throws Exception;

	
}
