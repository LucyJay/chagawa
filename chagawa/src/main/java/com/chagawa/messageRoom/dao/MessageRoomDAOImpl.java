package com.chagawa.messageRoom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chagawa.messageRoom.vo.MessageRoomVO;
import com.chagawa.io.db.DB;

public class MessageRoomDAOImpl implements MessageRoomDAO {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	@Override
	public List<MessageRoomVO> list(String id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageDAOImpl.list()");
		// 결과를 전달되는 변수
		List<MessageRoomVO> list = null;
		try {
			con = DB.getConnection();
			String sql = "select "
					+"   mr.roomNo, "
					+ "  mr.par1 , "
					+" mr.par2, "
					+ "  m.profileImage , "
					+ "  mr.lmcontent ,"
					+ "  mr.unreadcount1, "
					+ "  mr.unreadcount2, "
					+ "  mr.cdate from messageroom mr, member m "
					+ "  where (mr.par1= ? and mr.roomstatus1 = '있다' and m.id = mr.par1) or "
					+ "  (mr.par2 = ? and mr.roomstatus2 = '있다' and m.id = mr.par2) "
					+ " order by mr.cdate desc";
					
			
			System.out.println("MessageRoomDAOImpl.list().sql : " + sql);
			// 4. 실행객체 & 데이터 세팅
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,id);
			pstmt.setString(2,id);
			// 5. 실행 -> rs
			rs = pstmt.executeQuery();
			// 6. 데이터 저장 - list
			// rs가 null 이 아니면 처리하자
			if(rs != null) {
				// rs에 다음 데이터가 있으면 처리
				while(rs.next()) {
					// list가 null 이면 한번만 생생
					if(list == null) { list = new ArrayList<>();}
					// 데이터를 담을 vo 객체를 생성한다.
					MessageRoomVO MRvo = new MessageRoomVO();
					MRvo.setRoomNo(rs.getLong("roomNo"));
					MRvo.setUnreadcount1(rs.getLong("unreadcount1"));
					MRvo.setUnreadcount2(rs.getLong("unreadcount2"));
					MRvo.setPar1(rs.getString("par1"));
					MRvo.setPar2(rs.getString("par2"));
					MRvo.setProfileImage(rs.getString("profileImage"));
					MRvo.setLmcontent(rs.getString("lmcontent"));
					MRvo.setcDate(rs.getString("cdate"));
					// 데이터가 담긴 vo를 list에 담는다.
					list.add(MRvo);
				}// end of while
			} // end of if
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // 개발자를 위한 코드
			throw new Exception("대화방 리스트 DB 처리 중 오류 발생");
		} finally {
			// 7. 닫기
			DB.close(con, pstmt, rs);
		} // end of try ~ catch ~ finally
		
		return list;
	} // end of list()
	
	@Override
	public int write(String id, String par1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl.write().vo : " + par1);
		int result = 0;
		try {
			// 1. 확인 2. 연결
			con = DB.getConnection();
			// 3. sql
			String sql = "insert into messageroom(roomNo, par1, par2) "
					+ " values(messageroom_seq.nextval, ?, ?)";
			System.out.println("messageRoomDAOImpl.write().sql : " + sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,par1);
			pstmt.setString(2,id);
			// 5. 실행 -> rs
			result = pstmt.executeUpdate();
			// 6. 데이터 저장 - list
			// rs가 null 이 아니면 처리하자
			System.out.println("MessageRoomwriteDAOImpl.write() - 글등록 완료");
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
	public int leave(long roomno ,String id, int x) throws Exception {
		int result = 0;
		
		try {
			con = DB.getConnection();
			
			String sql = "update MessageRoom set roomstatus" + x +" = '없다' "
					
					+ " where par"+ x + " = ? and roomno = ? ";
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setLong(2, roomno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(); // 개발자를 위한 코드
			throw new Exception("게시판 글삭제 DB 처리 중 오류 발생");
		} finally {
			DB.close(con, pstmt);
		
		
		}
		return result;
		}
	@Override
	public int increase(long roomno ,String id, int x) throws Exception {
		int result = 0;
		
		try {
			con = DB.getConnection();
			
			String sql = "update MessageRoom set unreadcount" + x +" = unreadcount" + x + "+ 1 "
					
					+ " where par"+ x + " = ? and roomno = ? ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setLong(2, roomno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(); // 개발자를 위한 코드
			throw new Exception("게시판 글삭제 DB 처리 중 오류 발생");
		} finally {
			DB.close(con, pstmt);
			
			
		}
		System.out.println(result);
		return result;
	}
		
//		public int delete() throws Exception {
//			int result = 0;
//			
//			try {
//				con = DB.getConnection();
//				String sql = "delete from messageroom where roomstatus1='없다' and "
//						+ " roomstatus2='없다' ";
//				pstmt = con.prepareStatement(sql);
//				result = pstmt.executeUpdate();
//			} catch (Exception e) {
//				e.printStackTrace(); // 개발자를 위한 코드
//				throw new Exception("게시판 글삭제 DB 처리 중 오류 발생");
//			} finally {
//				DB.close(con, pstmt);
//			
//			
//			}
//			return result;
//	
//}

		@Override
		public long findroomno(String par, String id) throws Exception{
			
			long result = 0;
			try {
				con = DB.getConnection();
				String sql = "select roomno from messageroom where (par1 = ? and par2 = ?) or (par1 = ? and par2 = ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, par);
				pstmt.setString(2, id);
				pstmt.setString(3, id);
				pstmt.setString(4, par);
				rs = pstmt.executeQuery();
				
				if(rs != null && rs.next()) {
					result = rs.getLong(1);
				}
			} catch (Exception e) {
				e.printStackTrace(); // 개발자를 위한 코드
				throw new Exception("게시판 글삭제 DB 처리 중 오류 발생");
			} finally {
				DB.close(con, pstmt, rs);
			
			
			}
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
		@Override
		public int findopposite(long roomno, String id) throws Exception{
			System.out.println("들어왔음");
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



		
	
	} // end of MessageDAOImpl class
