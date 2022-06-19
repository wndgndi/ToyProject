package toyProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String MEMBER_LIST = "select * from MEMBER";
	private final String MEMBER_INSERT = "insert into member values(?, ?, ?)";
	private final String MEMBER_UPDATE = "update member set phone_number = ? where member_id = ? ";
	private final String MEMBER_DELETE = "delete member where member_id=?";

	Member member = new Member();

	public void insertMember(String memberId, String name, String phoneNumber) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_INSERT);
			stmt.setString(1, memberId);
			stmt.setString(2, name);
			stmt.setString(3, phoneNumber);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public void deleteMember(String memberId) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_DELETE);
			stmt.setString(1, memberId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public void updateMember(String phoneNumber, String memberId) {

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_UPDATE);
			stmt.setString(1, phoneNumber);
			stmt.setString(2, memberId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	

	public void getMemberList() {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_LIST);
			rs = stmt.executeQuery();
			int cnt = 0;
			
			while ((rs.next())) {
				cnt++;
				if(cnt == 1) {
					System.out.println("현재 등록된 회원 목록입니다.");
				}
				
				member.setMemberId(rs.getString("MEMBER_ID"));
				member.setName(rs.getString("NAME"));
				member.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				System.out.println("---> " + member.toString());

			}

			if (cnt == 0) {
				System.out.println("등록된 회원이 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);

		}
	}

}
