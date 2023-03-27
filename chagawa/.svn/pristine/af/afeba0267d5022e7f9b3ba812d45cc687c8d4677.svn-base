package com.chagawa.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chagawa.message.vo.MessageVO;
import com.chagawa.io.db.DB;

public class MessageDAOImpl implements MessageDAO {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	@Override
	public List<MessageVO> list(String id,String par1,long no) throws Exception {
		// TODO Auto-generated method stub
				System.out.println("MessageDAOImpl.messagelog().no : " +  no);
				// 리턴 데이터 선언
				MessageVO vo1 = null;
				List<MessageVO> list = null;
				
				try {
					// 1. 확인 2. 연결
					con = DB.getConnection();
					// 3. sql
					String sql = "select * from (select m.no, mb.profileimage , m.content, m.sender, m.senddate,"
							+ " m.accepter, m.roomno "
							+ " from message m, member mb where (sender = ? and accepter = ? and roomno= ? and m.sender = mb.id ) "
							+ " or (sender = ? and accepter = ? and roomno=? and m.sender = mb.id )"
							+ " order by senddate asc) ";
					System.out.println("MEssageDAOImpl.view().sql : " + sql);
					// 4. 실행객체 & 데이터 세팅
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, par1);
					pstmt.setLong(3, no);
					pstmt.setString(4, par1);
					pstmt.setString(5, id);
					pstmt.setLong(6, no);
					// 5. 실행 -> rs
					rs = pstmt.executeQuery();
					// 6. 데이터 저장 - list
					System.out.println(rs);
					// rs가 null 이 아니면 처리하자
					if(rs != null ) {
						while(rs.next()) {
							
						// rs에 다음 데이터가 있으면 처리
							if(list == null) list = new ArrayList<>();
						vo1 = new MessageVO();
						// rs에 데이터를 꺼내서 vo에 담는다.
						vo1.setNo(rs.getLong("no"));
						vo1.setRoomno(rs.getLong("roomno"));
						vo1.setProfileImage(rs.getString("profileImage"));
						vo1.setContent(rs.getString("content"));
						vo1.setSender(rs.getString("sender"));
						vo1.setSendDate(rs.getString("sendDate"));
						vo1.setAccepter(rs.getString("accepter"));
						list.add(vo1);
						}	
						System.out.println(list);
					} // end of if
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace(); // 개발자를 위한 코드
					throw new Exception("공지사항 글보기 DB 처리 중 오류 발생");
				} finally {
					// 7. 닫기
					DB.close(con, pstmt, rs);
				} // end of try ~ catch ~ finally
				
				
				return list;
	}
	public Object write(String id, String wpar1, long wno, MessageVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageDAOImpl.write().vo : " + vo);
		int result = 0;
		try {
			// 1. 확인 2. 연결
			con = DB.getConnection();
			// 3. sql
			String sql = "insert into message(no, content, sender, accepter, roomno) "
					+ " values(message_seq.nextval, ?, ?, ?, ?)";
			System.out.println("MessageDAOImpl.write().sql : " + sql);
			// 4. 실행객체 & 데이터 세팅
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setString(2, id);
			pstmt.setString(3, wpar1);
			pstmt.setLong(4, wno);
			// 5. 실행 -> rs
			result = pstmt.executeUpdate();
			// 6. 데이터 저장 - list
			// rs가 null 이 아니면 처리하자
			System.out.println("MessageDAOImpl.write() - 글등록 완료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // 개발자를 위한 코드
			throw new Exception("공지사항 글등록 DB 처리 중 오류 발생");
		} finally {
			// 7. 닫기
			DB.close(con, pstmt);
		} // end of try ~ catch ~ finally
		
		
		return result;
	}
	@Override
	public Object alert(String id) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			// 1. 확인 2. 연결
			con = DB.getConnection();
			// 3. sql
			String sql = "update message set acceptdate = sysdate "
					+ " where accepter = ? and acceptdate is null ";
			System.out.println("MessageDAOImpl.write().sql : " + sql);
			// 4. 실행객체 & 데이터 세팅
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			// 5. 실행 -> rs
			result = pstmt.executeUpdate();
			// 6. 데이터 저장 - list
			// rs가 null 이 아니면 처리하자
			System.out.println("MessageDAOImpl.write() - 글등록 완료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // 개발자를 위한 코드
			throw new Exception("공지사항 글등록 DB 처리 중 오류 발생");
		} finally {
			// 7. 닫기
			DB.close(con, pstmt);
		} // end of try ~ catch ~ finally
		
		
		return result;
	}

	@Override
	public Object utc(long no, String id, int x) throws Exception {
		// TODO Auto-generated method stub
				int result = 0;
				try {
					// 1. 확인 2. 연결
					con = DB.getConnection();
					// 3. sql
					String sql = "update messageroom set unreadcount"+ x +" = 0 "
							+ " where roomno = ? and par" + x +" = ? ";
					System.out.println("MessageDAOImpl.write().sql : " + sql);
					System.out.println("no =" + no + "id =" + id);
					// 4. 실행객체 & 데이터 세팅
					pstmt = con.prepareStatement(sql);
					pstmt.setLong(1, no);
					pstmt.setString(2, id);
					// 5. 실행 -> rs
					result = pstmt.executeUpdate();
					// 6. 데이터 저장 - list
					// rs가 null 이 아니면 처리하자
					System.out.println("MessageDAOImpl.update() - 글등록 완료");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace(); // 개발자를 위한 코드
					throw new Exception("공지사항 글등록 DB 처리 중 오류 발생");
				} finally {
					// 7. 닫기
					DB.close(con, pstmt);
				} // end of try ~ catch ~ finally
				
				
				return result;
	}
	@Override
	public int findpar(long roomno, String id) throws Exception{
		
		try {
			con = DB.getConnection();
			String sql = "select roomno from messageroom where (roomno = ? and par2 = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, roomno);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				return 2;
			}
			 sql = "select roomno from messageroom where (roomno = ? and par1 = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, roomno);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				return 1;
			}
						} catch (Exception e) {
			e.printStackTrace(); // 개발자를 위한 코드
			throw new Exception("게시판 글삭제 DB 처리 중 오류 발생");
		} finally {
			DB.close(con, pstmt, rs);
			
			
		} return 0;
	
	


	
	
	
		
	

}
	}
//	@Override
//	public int findopposite(long no, String id) throws Exception {
//		System.out.println("들어왔음");
//		try {
//			con = DB.getConnection();
//			String sql = "select roomno from messageroom where (roomno = ? and par2 = ?)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setLong(1, no);
//			pstmt.setString(2, id);
//			rs = pstmt.executeQuery();
//			
//			if(rs != null && rs.next()) {
//				return 1;
//			}
//			sql = "select roomno from messageroom where (roomno = ? and par1 = ?)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setLong(1, no);
//			pstmt.setString(2, id);
//			rs = pstmt.executeQuery();
//			if(rs != null && rs.next()) {
//				return 2;
//			}
//		} catch (Exception e) {
//			e.printStackTrace(); // 개발자를 위한 코드
//			throw new Exception("게시판 글삭제 DB 처리 중 오류 발생");
//		} finally {
//			DB.close(con, pstmt, rs);
//			
//			
//		} return 0;
//	}} // end of MessageDAOImpl class
