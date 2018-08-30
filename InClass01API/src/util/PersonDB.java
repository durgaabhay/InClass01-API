package util;

import java.sql.*;

import data.Person;

public class PersonDB {
	
	public static int insert(Person person) throws SQLException {
		
		ConnectionUtil pool = ConnectionUtil.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		
		String query = "INSERT INTO PERSON (Username,UserId,Password,Age,Weight)" +
			"VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1,person.getUserName());
			ps.setString(2, person.getUserId());
			ps.setString(3,person.getPassword());
			ps.setInt(4, person.getAge());
			ps.setDouble(5, person.getWeight());
			return ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
			return 0;
		}finally {
			ps.close();
			pool.freeConnection(connection);
		}
	}
	
	public static Person selectUser(String userId,String password) {
		ConnectionUtil pool = ConnectionUtil.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person p = null;
		
		
		String query = "SELECT * FROM PERSON" + "WHERE USERID = ? AND PASSWORD = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(3, userId);
			ps.setString(4, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				p = new Person();
				p.setUserName(rs.getString("Username"));
				p.setAge(rs.getInt("age"));
				p.setWeight(rs.getDouble("weight"));
				p.setUserId(userId);
				p.setPassword(password);

			}
		}
			catch(SQLException e) {
				return null;
			}finally {
				pool.freeConnection(connection);
		}
		return p;
		
		
	}
}
