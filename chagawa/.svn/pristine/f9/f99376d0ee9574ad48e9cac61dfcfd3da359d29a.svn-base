package com.chagawa.point.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chagawa.io.db.DB;
import com.chagawa.point.vo.PointVO;
import com.webjjang.util.PageObject;

public class PointDAOImpl implements PointDAO {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 포인트 내역
	@Override
	public List<PointVO> list(String id, PageObject pageObject) throws Exception {
		// TODO Auto-generated method stub

		List<PointVO> list = null;

		try {
			con = DB.getConnection();
			String sql = "select no, to_char(runDate, 'yyyy-mm-dd HH24:MI:SS') runDate, memo, price from point where id = ? ";
			sql += searchSQL(pageObject);
			sql += " order by no desc";
			sql = "select rownum rnum, no, runDate, memo, price from (" + sql + ")";
			sql = "select no, runDate, memo, price from (" + sql + ") where rnum between ? and ? ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			int idx = 1;
			idx = searchDataSet(pageObject, idx);
			pstmt.setString(1, id);
			pstmt.setLong(++idx, pageObject.getStartRow());
			pstmt.setLong(++idx, pageObject.getEndRow());
			
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					if (list == null)
						list = new ArrayList<>();
					PointVO vo = new PointVO();
					vo.setNo(rs.getLong("no"));
					vo.setRunDate(rs.getString("runDate"));
					vo.setMemo(rs.getString("memo"));
					vo.setPrice(rs.getLong("price"));
					list.add(vo);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}

		return list;
	}

	// 검색 sql
	private String searchSQL(PageObject pageObject) {
		String sql = "";
		String word = pageObject.getWord();
		String key = pageObject.getKey();
		if (word != null && !word.equals("")) {
			sql += " and (1=0 ";
			if (key.indexOf("m") >= 0)
				sql += " or memo like ? ";
			sql += ") ";
		}
		return sql;
	} // end of searchSQL

	// 검색 데이터 세팅
	private int searchDataSet(PageObject pageObject, int idx) throws SQLException {
		String word = pageObject.getWord();
		String key = pageObject.getKey();
		if (word != null && !word.equals("")) {
			if (key.indexOf("m") >= 0)
				pstmt.setString(++idx, "%" + word + "%");
		}
		return idx;
	} // end of searchDataSet

	// getTotalRow
	@Override
	public long getTotalRow(PageObject pageObject) throws Exception {
		// TODO Auto-generated method stub
		long totalRow = 0;
		try {
			// 1. 확인, 2. 연결
			con = DB.getConnection();
			// 3. sql
			String sql = "select count(*) from point";
			sql += searchSQL(pageObject);
			// 4. 실행 객체, 데이터 세팅
			pstmt = con.prepareStatement(sql);
			int idx = 0;
			idx = searchDataSet(pageObject, idx);
			// 5. 실행
			rs = pstmt.executeQuery();
			// 6. 데이터 저장
			if (rs != null & rs.next()) {
				totalRow = rs.getLong(1);
			} // end of if
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("전체 데이터 개수 DB 처리 중 오류 발생");
		} finally {
			// 7. 닫기
			DB.close(con, pstmt, rs);
		}
		return totalRow;
	} // end of getTotalRow

	// 포인트 증감
	@Override
	public int update(PointVO vo) throws Exception {
		// TODO Auto-generated method stub

		int result = 0;

		try {

			con = DB.getConnection();

			String sql = "update member set myPoint = myPoint + ?  where id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, vo.getPrice());
			pstmt.setString(2, vo.getId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			DB.close(con, pstmt);

		}
		return result;
	}

	// 포인트 내역 작성
	@Override
	public int write(PointVO vo) throws Exception {
		// TODO Auto-generated method stub

		int result = 0;

		try {

			con = DB.getConnection();

			String sql = "insert into point(no, id, memo, price) values(point_seq.nextval, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getMemo());
			pstmt.setLong(3, vo.getPrice());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt);
		}

		return result;
	}

}
