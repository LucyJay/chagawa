package com.chagawa.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chagawa.io.db.DB;
import com.chagawa.member.vo.LoginVO;
import com.chagawa.member.vo.MemberVO;
import com.webjjang.util.PageObject;

public class MemberDAOImpl implements MemberDAO {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	@Override
	public LoginVO login(LoginVO inVO) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		LoginVO vo = null;
		try {
			con = DB.getConnection();
			
			String sql = "select m.id, m.pw, m.nickname, m.tel, m.status, m.gradeNo, g.gradeName "
					+ " from member m, grade g "
					+ " where (id = ? and pw = ?) and (g.gradeNo = m.gradeNo) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inVO.getId());
			pstmt.setString(2, inVO.getPw());
			
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				vo = new LoginVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setNickname(rs.getString("nickname"));
				vo.setTel(rs.getString("tel"));
				vo.setStatus(rs.getString("status"));
				vo.setGradeNo(rs.getLong("gradeNo"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("로그인 DB");
		} finally {
			DB.close(con, pstmt, rs);
		} // end of try~catch~finally
		
		return vo;
	}

	@Override
	public Integer updateConDate(LoginVO vo) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		Integer result = 0;
		try {
			con = DB.getConnection();
			
			String sql = "update member set conDate = sysdate where id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			
			result = pstmt.executeUpdate();
			
			System.out.println("MemberDAOImpl.updateConDate() - 최근접속일 수정");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("최근접속일 수정 DB");
		} finally {
			DB.close(con, pstmt);
		} // end of try~catch~finally
		
		return result;
	}
	
	@Override
	public Integer join(MemberVO vo) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		Integer result = 0;
		try {
			con = DB.getConnection();
			
			String sql = "insert into member(id, pw, nickname, name, profileImage, birth, gender, tel, bank, account) "
					+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getNickname());
			pstmt.setString(4, vo.getName());
			pstmt.setString(5, vo.getProfileImage());
			pstmt.setString(6, vo.getBirth());
			pstmt.setString(7, vo.getGender());
			pstmt.setString(8, vo.getTel());
			pstmt.setString(9, vo.getBank());
			pstmt.setString(10, vo.getAccount());
			
			result = pstmt.executeUpdate();
			
			System.out.println("MemberDAOImpl.join() - 회원가입 처리");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("회원가입 DB");
		} finally {
			DB.close(con, pstmt);
		} // end of try~catch~finally
		
		return result;
	}


//	@Override
//	public boolean check(String data, String colName) throws Exception {
//		System.out.println("MemberDAOImpl-----------------------");
//		try {
//			con = DB.getConnection();
//			
//			String sql = "select " + colName + " from member where " + colName + " = ?";
//			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, data);
//			
//			rs = pstmt.executeQuery();
//			
//			return rs.next();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception("중복체크 DB");
//		} finally {
//			DB.close(con, pstmt, rs);
//		} // end of try~catch~finally
//		
//	}
	
	@Override
	public String check(String data, String colName) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		String result = null;
		try {
			con = DB.getConnection();
			
			String sql = null;
			if(colName == "carNo" || colName == "licenseNo") {
				sql = "select " + colName + " from driver where " + colName + " = ?";
			} else {
				sql = "select " + colName + " from member where " + colName + " = ?";
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, data);
			
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				result = rs.getString(colName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("중복체크 DB");
		} finally {
			DB.close(con, pstmt, rs);
		} // end of try~catch~finally
		
		return result ;
	}
	

	@Override
	public String findId(MemberVO vo) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		String id = null;
		try {
			con = DB.getConnection();
			
			String sql = "select id from member where name = ? and tel = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				id = rs.getString("id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("아이디 찾기 DB");
		} finally {
			DB.close(con, pstmt, rs);
		} // end of try~catch~finally
		
		return id;
		
	}
	
	
	@Override
	public String findPw(MemberVO vo) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		String pw = null;
		try {
			con = DB.getConnection();
			
			String sql = "select pw from member where id = ? and name = ? and tel = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getTel());
			
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				pw = rs.getString("pw");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("비밀번호 찾기 DB");
		} finally {
			DB.close(con, pstmt, rs);
		} // end of try~catch~finally
		
		return pw;
		
	}
	
	

	//일반회원---------------------------------------------------------
	@Override
	public MemberVO myPageD(String id) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		MemberVO vo = null;
		try {
			con = DB.getConnection();
			
			String sql = "select m.id, m.nickname, m.name, m.profileImage, m.gender, m.birth, m.tel, "
					+ " d.carModel, d.carNo, d.licenseNo, m.myPoint, m.account, m.bank, "
					+ " to_char(m.regDate, 'yy.mm.dd') regDate, m.gradeNo, g.gradeName from member m, grade g, driver d "
					+ " where (g.gradeNo = m.gradeNo and d.id = m.id) and (m.id = ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setNickname(rs.getString("nickname"));
				vo.setName(rs.getString("name"));
				vo.setProfileImage(rs.getString("profileImage"));
				vo.setGender(rs.getString("gender"));
				vo.setBirth(rs.getString("birth"));
				vo.setTel(rs.getString("tel"));
				
				vo.setCarModel(rs.getString("carModel"));
				vo.setCarNo(rs.getString("carNo"));
				vo.setLicenseNo(rs.getString("licenseNo"));
				vo.setMyPoint(rs.getLong("myPoint"));
				vo.setAccount(rs.getString("account"));
				vo.setBank(rs.getString("bank"));
				
				vo.setRegDate(rs.getString("regDate"));
				vo.setGradeNo(rs.getLong("gradeNo"));
				vo.setGradeName(rs.getString("gradeName"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("내정보보기 DB");
		} finally {
			DB.close(con, pstmt, rs);
		} // end of try~catch~finally
		
		return vo;
		
	}
	
	
	@Override
	public MemberVO myPageP(String id) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		MemberVO vo = null;
		try {
			con = DB.getConnection();
			
			String sql = "select m.id, m.nickname, m.name, m.profileImage, m.gender, m.birth, m.tel, "
					+ " m.myPoint, m.account, m.bank, "
					+ " to_char(m.regDate, 'yy.mm.dd') regDate, m.gradeNo, g.gradeName from member m, grade g "
					+ " where (g.gradeNo = m.gradeNo) and (m.id = ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setNickname(rs.getString("nickname"));
				vo.setName(rs.getString("name"));
				vo.setProfileImage(rs.getString("profileImage"));
				vo.setGender(rs.getString("gender"));
				vo.setBirth(rs.getString("birth"));
				vo.setTel(rs.getString("tel"));
				
				vo.setMyPoint(rs.getLong("myPoint"));
				vo.setAccount(rs.getString("account"));
				vo.setBank(rs.getString("bank"));
				
				vo.setRegDate(rs.getString("regDate"));
				vo.setGradeNo(rs.getLong("gradeNo"));
				vo.setGradeName(rs.getString("gradeName"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("내정보보기 DB");
		} finally {
			DB.close(con, pstmt, rs);
		} // end of try~catch~finally
		
		return vo;
		
	}


	@Override
	public Integer updateImage(MemberVO vo) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		Integer result = 0;
		try {
			con = DB.getConnection();
			
			String sql = "update member set profileImage = ? "
					+ " where id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getProfileImage());
			pstmt.setString(2, vo.getId());
			
			result = pstmt.executeUpdate();
			
			System.out.println("MemberDAOImpl.update() - 이미지 수정");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("이미지 수정 DB");
		} finally {
			DB.close(con, pstmt);
		} // end of try~catch~finally
		
		return result;
	}
	
	
	@Override
	public Integer update(MemberVO vo) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		Integer result = 0;
		try {
			con = DB.getConnection();
			
			String sql = "update member set nickname=?, tel=?, bank=?, account=? "
					+ " where id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getNickname());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getBank());
			pstmt.setString(4, vo.getAccount());
			pstmt.setString(5, vo.getId());
			
			result = pstmt.executeUpdate();
			
			System.out.println("MemberDAOImpl.update() - 내정보수정");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("내정보수정 DB");
		} finally {
			DB.close(con, pstmt);
		} // end of try~catch~finally
		
		return result;
	}
	
	
	@Override
	public Integer updateD(MemberVO vo) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		Integer result = 0;
		try {
			con = DB.getConnection();
			
			String sql = "update driver set carModel=?, carNo=? "
					+ " where id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCarModel());
			pstmt.setString(2, vo.getCarNo());
			pstmt.setString(3, vo.getId());
			
			result = pstmt.executeUpdate();
			
			System.out.println("MemberDAOImpl.update() - 차정보수정");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("차정보수정 DB");
		} finally {
			DB.close(con, pstmt);
		} // end of try~catch~finally
		
		return result;
	}
	
	
	@Override
	public Integer changePw(String id, String pw, String newPw) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		Integer result = 0;
		try {
			con = DB.getConnection();
			
			String sql = "update member set pw=? where id = ? and pw = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			
			result = pstmt.executeUpdate();
			
			System.out.println("MemberDAOImpl.update() - 비밀번호변경");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("비밀번호변경 DB");
		} finally {
			DB.close(con, pstmt);
		} // end of try~catch~finally
		
		return result;
	}
	
	
	@Override
	public Integer joinDriver(MemberVO vo) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		Integer result = 0;
		try {
			con = DB.getConnection();
			
			String sql = "insert into driver(id, carModel, carNo, licenseNo) "
					+ " values(?, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getCarModel());
			pstmt.setString(3, vo.getCarNo());
			pstmt.setString(4, vo.getLicenseNo());
			
			result = pstmt.executeUpdate();
			
			System.out.println("MemberDAOImpl.joinDriver() - 운전자 정보 입력 처리");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("운전자 정보 입력 DB");
		} finally {
			DB.close(con, pstmt);
		} // end of try~catch~finally
		
		return result;
	}
	
	
	@Override
	public Integer leave(MemberVO vo) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		Integer result = 0;
		try {
			con = DB.getConnection();
			
			String sql = "update member set status='탈퇴' where id = ? and pw = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			
			result = pstmt.executeUpdate();
			
			System.out.println("MemberDAOImpl.leave() - 탈퇴");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("탈퇴 DB");
		} finally {
			DB.close(con, pstmt);
		} // end of try~catch~finally
		
		return result;
	}

	
	//관리자-----------------------------------------------------------
	@Override
	public List<MemberVO> list(PageObject pageObject) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		List<MemberVO> list = null;
		try {
			con = DB.getConnection();
			
			String sql = "select m.id, m.nickname, m.gender, m.birth, "
					+ " to_char(m.regDate, 'yy.mm.dd') regDate, m.status, g.gradeName from member m, grade g ";
			sql += " where (g.gradeNo = m.gradeNo) " + searchSQL2(pageObject);
			sql += " order by m.gradeNo desc, m.id ";
			
			sql = "select rownum rnum, id, nickname, gender, birth, regDate, status, gradeName "
					+ " from ( " + sql + ")";
			sql = "select id, nickname, gender, birth, regDate, status, gradeName "
					+ " from ( " + sql + ") where rnum between ? and ? ";
			
//			System.out.println("#########" + sql);
			
			pstmt = con.prepareStatement(sql);
			
			int idx = 0;
			idx = searchDataSet(pageObject, idx);
			pstmt.setLong(++idx, pageObject.getStartRow());
			pstmt.setLong(++idx, pageObject.getEndRow());
			
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					if(list == null) list = new ArrayList<>();
					
					MemberVO vo = new MemberVO();
					vo.setId(rs.getString("id"));
					vo.setNickname(rs.getString("nickname"));
					vo.setGender(rs.getString("gender"));
					vo.setBirth(rs.getString("birth"));
					
					vo.setRegDate(rs.getString("regDate"));
					vo.setStatus(rs.getString("status"));
					vo.setGradeName(rs.getString("gradeName"));
					
					list.add(vo);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("회원리스트 DB");
		} finally {
			DB.close(con, pstmt, rs);
		} // end of try~catch~finally
		
		return list;
		
	}
	
	// 검색을 위한 sql 작성
	private String searchSQL(PageObject pageObject) {
		String sql = "";
		String word = pageObject.getWord();
		String key = pageObject.getKey();
		if(word != null && !word.equals("")) {
			sql += " where (1=0 ";
			if(key.indexOf("i") >= 0) sql += " or id like ? ";
			if(key.indexOf("n") >= 0) sql += " or nickname like ? ";
			sql += ") ";
		}
		return sql;
	}
	
	private String searchSQL2(PageObject pageObject) {
		String sql = "";
		String word = pageObject.getWord();
		String key = pageObject.getKey();
		if(word != null && !word.equals("")) {
			sql += " and (1=0 ";
			if(key.indexOf("i") >= 0) sql += " or id like ? ";
			if(key.indexOf("n") >= 0) sql += " or nickname like ? ";
			sql += ") ";
		}
		return sql;
	}
	
	// 검색을 위한 데이터 세팅
	private int searchDataSet(PageObject pageObject, int idx) throws SQLException {
		String word = pageObject.getWord();
		String key = pageObject.getKey();
		if(word != null && !word.equals("")) {
			if(key.indexOf("i") >= 0) pstmt.setString(++idx, "%" + word + "%");
			if(key.indexOf("n") >= 0) pstmt.setString(++idx, "%" + word + "%");
		}
		return idx;
	}
	
	@SuppressWarnings("unused")
	@Override
	public long getTotalRow(PageObject pageObject) throws Exception {
		// 결과가 전달되는 변수
		long totalRow = 0;
		try {

			con = DB.getConnection();

			String sql = "select count(*) from member";
			sql += searchSQL(pageObject);

			pstmt = con.prepareStatement(sql);
			
			int idx = searchDataSet(pageObject, 0);

			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				totalRow = rs.getLong(1);
			} // end of if
			
		} catch (Exception e) {
			e.printStackTrace(); // 개발자를 위한 코드
			
		} finally {
			// 7. 닫기
			DB.close(con, pstmt, rs);
		} // try~catch~finally
		
		return totalRow;
	}
	
	
	@Override
	public MemberVO viewD(String id) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		MemberVO vo = null;
		try {
			con = DB.getConnection();
			
			String sql = "select m.id, m.nickname, m.name, m.profileImage, m.gender, m.birth, m.tel, "
					+ " d.carModel, d.carNo, d.licenseNo, m.myPoint, m.account, m.bank, "
					+ " to_char(m.regDate, 'yy.mm.dd') regDate, to_char(m.conDate, 'yy.mm.dd') conDate, m.status, "
					+ " m.gradeNo, g.gradeName from member m, grade g, driver d "
					+ " where (g.gradeNo = m.gradeNo and d.id = m.id) and (m.id = ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setNickname(rs.getString("nickname"));
				vo.setName(rs.getString("name"));
				vo.setProfileImage(rs.getString("profileImage"));
				vo.setGender(rs.getString("gender"));
				vo.setBirth(rs.getString("birth"));
				vo.setTel(rs.getString("tel"));
				
				vo.setCarModel(rs.getString("carModel"));
				vo.setCarNo(rs.getString("carNo"));
				vo.setLicenseNo(rs.getString("licenseNo"));
				vo.setMyPoint(rs.getLong("myPoint"));
				vo.setAccount(rs.getString("account"));
				vo.setBank(rs.getString("bank"));
				
				vo.setRegDate(rs.getString("regDate"));
				vo.setConDate(rs.getString("conDate"));
				vo.setStatus(rs.getString("status"));
				vo.setGradeNo(rs.getLong("gradeNo"));
				vo.setGradeName(rs.getString("gradeName"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("회원정보보기 DB");
		} finally {
			DB.close(con, pstmt, rs);
		} // end of try~catch~finally
		
		return vo;
		
	}
	
	
	@Override
	public MemberVO viewP(String id) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		MemberVO vo = null;
		try {
			con = DB.getConnection();
			
			String sql = "select m.id, m.nickname, m.name, m.profileImage, m.gender, m.birth, m.tel, "
					+ " m.myPoint, m.account, m.bank, "
					+ " to_char(m.regDate, 'yy.mm.dd') regDate, to_char(m.conDate, 'yy.mm.dd') conDate, "
					+ " m.status, m.gradeNo, g.gradeName from member m, grade g "
					+ " where (g.gradeNo = m.gradeNo ) and (m.id = ?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setNickname(rs.getString("nickname"));
				vo.setName(rs.getString("name"));
				vo.setProfileImage(rs.getString("profileImage"));
				vo.setGender(rs.getString("gender"));
				vo.setBirth(rs.getString("birth"));
				vo.setTel(rs.getString("tel"));
				
				vo.setMyPoint(rs.getLong("myPoint"));
				vo.setAccount(rs.getString("account"));
				vo.setBank(rs.getString("bank"));
				
				vo.setRegDate(rs.getString("regDate"));
				vo.setConDate(rs.getString("conDate"));
				vo.setStatus(rs.getString("status"));
				vo.setGradeNo(rs.getLong("gradeNo"));
				vo.setGradeName(rs.getString("gradeName"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("회원정보보기 DB");
		} finally {
			DB.close(con, pstmt, rs);
		} // end of try~catch~finally
		
		return vo;
		
	}
	
	
	@Override
	public Integer changeStatus(MemberVO vo) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		Integer result = 0;
		try {
			con = DB.getConnection();
			
			String sql = "update member set status = ? where id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getStatus());
			pstmt.setString(2, vo.getId());
			
			result = pstmt.executeUpdate();
			
			System.out.println("MemberDAOImpl.changeStatus() - 상태수정");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("상태수정 DB");
		} finally {
			DB.close(con, pstmt);
		} // end of try~catch~finally
		
		return result;
	}
	
	
	@Override
	public Integer changeGrade(MemberVO vo) throws Exception {
		System.out.println("MemberDAOImpl-----------------------");
		Integer result = 0;
		try {
			con = DB.getConnection();
			
			String sql = "update member set gradeNo = ? where id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, vo.getGradeNo());
			pstmt.setString(2, vo.getId());
			
			result = pstmt.executeUpdate();
			
			System.out.println("MemberDAOImpl.changeGrade() - 등급수정");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("등급수정 DB");
		} finally {
			DB.close(con, pstmt);
		} // end of try~catch~finally
		
		return result;
	}
	
	
}
