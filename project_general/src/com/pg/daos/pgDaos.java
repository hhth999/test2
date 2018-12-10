package com.pg.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pg.dbinfo.DataInfo;
import com.pg.dtos.pgDtos;
import com.pg.dtos.pgrepDtos;

public class pgDaos extends DataInfo {

	public List<pgDtos> getAllBoard() {
		List<pgDtos> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hkboard2";
		String password = "hkboard";
		String sql = " SELECT FREENUM,NICKNAME,TITLE,VIEW1,LIKE1,TIME,CODE " + " FROM FREEBOARD ORDER BY TIME DESC ";

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("2단계:DB연결 성공!!");

			psmt = conn.prepareStatement(sql);
			System.out.println("3단계:쿼리준비 성공");

			rs = psmt.executeQuery();
			System.out.println("4단계:쿼리실행 성공");
			// rs.next = rs에 값이 있으면 가져오는것
			// 한 줄(row) 라고 생각하면 됨
			while (rs.next()) {
				pgDtos dto = new pgDtos();
				dto.setFreenum(rs.getInt(1));
				dto.setNickname(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setView1(rs.getInt(4));
				dto.setLike1(rs.getInt(5));
				dto.setTime(rs.getDate(6));
				list.add(dto);
				System.out.println(dto);
			}
			System.out.println("5단계:쿼리결과받기성공");
		} catch (SQLException e) {
			System.out.println("JDBC실행실패(getAllBoard())" + ":" + getClass());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				System.out.println("6단계:DB받기 성공");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("6단계:DB받기 실패");
				e.printStackTrace();

			}
		}
		return list;
	}

	public pgDtos getBoard(int freenum) {
		pgDtos dto = new pgDtos();
		System.out.println("getBoard 호출");
		Connection conn = null; // 연결위한 객체
		PreparedStatement psmt = null; // 쿼리준비위한 객체
		ResultSet rs = null; // 결과받기위한 객체

		String sql = "SELECT FREENUM, NICKNAME, TITLE, CONTENT, VIEW1, TIME, HATE, LIKE1 "
				+ " FROM FREEBOARD WHERE FREENUM=?";

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, freenum);
			rs = psmt.executeQuery(); // select는 rs에 담지 않으면 사라짐.
			while (rs.next()) {
				int i = 1;
				dto.setFreenum(rs.getInt(i++));
				dto.setNickname(rs.getString(i++));
				;
				dto.setTitle(rs.getString(i++));
				dto.setContent(rs.getString(i++));
				dto.setView1(rs.getInt(i++));
				dto.setTime(rs.getDate(i++));
				dto.setHate(rs.getInt(i++));
				dto.setLike1(rs.getInt(i++));
				System.out.println(dto);

			}

		} catch (SQLException e) {
			System.out.println("JDBC실패 :getBoard():" + getClass());
			e.printStackTrace();
		} finally {
			close(rs, psmt, conn);
		}

		return dto;

	}

	public List<pgrepDtos> getReply(int seq) {

		pgrepDtos dto = new pgrepDtos();
		List<pgrepDtos> list = new ArrayList<>();

		Connection conn = null; // 연결위한 객체
		PreparedStatement psmt = null; // 쿼리준비위한 객체
		ResultSet rs = null; // 결과받기위한 객체

		System.out.println("1");
		String sql = "SELECT COMMENTNUM,FREENUM,NICKNAME,TIME,DEPTH,CONTENT,LIKE1,HATE,REFER FROM COMMENT1 WHERE FREENUM=? ORDER BY REFER DESC, STEP ";
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("sql다음2");

			rs = psmt.executeQuery(); // select는 rs에 담지 않으면 사라짐.
			System.out.println("3");

			while (rs.next()) {
				int i = 1;
				dto.setCommentnum(rs.getInt(i++));
				dto.setFreenum(rs.getInt(i++));
				;
				dto.setNickname(rs.getString(i++));
				dto.setTime(rs.getDate(i++));
				dto.setDepth(rs.getInt(i++));
				dto.setContent(rs.getString(i++));
				dto.setLike1(rs.getInt(i++));
				dto.setHate(rs.getInt(i++));
				dto.setRefer(rs.getInt(i++));
				list.add(dto);

				System.out.println(dto);
				System.out.println("4");

			}


		} catch (SQLException e) {
			System.out.println("JDBC실패 :getBoard():" + getClass());
			e.printStackTrace();
		} finally {
			close(rs, psmt, conn);
		}

		return list;

	}

	public boolean insertBoard(pgDtos dto) throws SQLException {
		int count = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		PreparedStatement psmt2 = null;
		ResultSet rs = null;
		System.out.println("insert1");
		
		String sql1 = (" SELECT FREENUM FROM FREEBOARD WHERE ROWNUM = 1 ORDER BY FREENUM DESC");
		String sql = ("INSERT INTO FREEBOARD VALUES(?,?,?,?,0,0,0,SYSDATE,?)");
		
		conn = getConnection();
		psmt2 = conn.prepareStatement(sql1);
		rs = psmt2.executeQuery();
		
		
		int lastNumber = 0;
		while(rs.next()) {
			lastNumber = rs.getInt("freenum");
		}
		++lastNumber;
		
		try {
		conn = getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, lastNumber);
		psmt.setString(2, dto.getNickname());
		psmt.setString(3, dto.getTitle());
		psmt.setString(4, dto.getContent());
		psmt.setInt(5, dto.getCode());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, psmt, conn);
		}
		return count>0?true:false;
	}

} // 여기 안에 작성
