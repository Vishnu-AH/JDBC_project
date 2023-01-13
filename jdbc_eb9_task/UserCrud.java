package jdbc_eb9_task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCrud {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdbtask","root","root");
		return connection;
	}
	public void signUp(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, user.getUserid());
		preparedStatement.setString(2, user.getUsername());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getAddress());
		preparedStatement.setString(6, user.getFacebook());
		preparedStatement.setString(7, user.getInsta());
		preparedStatement.setString(8, user.getSnap());
		preparedStatement.setString(9, user.getWhatsapp());
		preparedStatement.setString(10, user.getTwitter());
		preparedStatement.execute();
		connection.close();
		System.out.println("Insertion successfull");
	}
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		String query = "select * from user where email = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while(resultSet.next()) {
			password = resultSet.getString("password");
		}
		if(password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	public void updateUser(int id,String name) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update user set username = ? where userid = ?");
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		preparedStatement.execute();
		connection.close();
		System.out.println("Updation successfull...!!");
	}
	public void deleteUser(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from user where userid = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		connection.close();
		System.out.println("Deletion successfull...!!");
	}
	public void fetchUser() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println("User id : "+resultSet.getInt("userid"));
			System.out.println("User name : "+resultSet.getString("username"));
			System.out.println("Email id : "+resultSet.getString("email"));
			System.out.println("Address : "+resultSet.getString("address"));
			System.out.println("=================================");
		}
		connection.close();
	}
	public int facebook(String email , String fbPassword) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update user set facebook = ? where email = ?");
		preparedStatement.setString(1, fbPassword);
		preparedStatement.setString(2, email);
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public String fetchFacebook(String email ) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select facebook from user where email = ?");
		preparedStatement.setString(1, email);
		ResultSet resultSet =preparedStatement.executeQuery();
		String password = null;
		while(resultSet.next()) {
			password = resultSet.getString("facebook");
		}
		connection.close();
		return password;
	}
	public int instagram(String email , String instaPassword) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update user set insta = ? where email = ?");
		preparedStatement.setString(1, instaPassword);
		preparedStatement.setString(2, email);
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public String fetchInsta(String email ) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select insta from user where email = ?");
		preparedStatement.setString(1, email);
		ResultSet resultSet =preparedStatement.executeQuery();
		String password = null;
		while(resultSet.next()) {
			password = resultSet.getString("insta");
		}
		connection.close();
		return password;
	}
	public int snapchat(String email , String snapPassword) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update user set snapchat = ? where email = ?");
		preparedStatement.setString(1, snapPassword);
		preparedStatement.setString(2, email);
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public String fetchSnap(String email ) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select snapchat from user where email = ?");
		preparedStatement.setString(1, email);
		ResultSet resultSet =preparedStatement.executeQuery();
		String password = null;
		while(resultSet.next()) {
			password = resultSet.getString("snapchat");
		}
		connection.close();
		return password;
	}
	public int whatsapp(String email , String whatsappPassword) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update user set whatsapp = ? where email = ?");
		preparedStatement.setString(1, whatsappPassword);
		preparedStatement.setString(2, email);
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public String fetchWhatsapp(String email ) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select whatsapp from user where email = ?");
		preparedStatement.setString(1, email);
		ResultSet resultSet =preparedStatement.executeQuery();
		String password = null;
		while(resultSet.next()) {
			password = resultSet.getString("whatsapp");
		}
		connection.close();
		return password;
	}
	public int twitter(String email , String twitterPassword) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update user set twitter = ? where email = ?");
		preparedStatement.setString(1, twitterPassword);
		preparedStatement.setString(2, email);
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public String fetchTwitter(String email ) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select twitter from user where email = ?");
		preparedStatement.setString(1, email);
		ResultSet resultSet =preparedStatement.executeQuery();
		String password = null;
		while(resultSet.next()) {
			password = resultSet.getString("twitter");
		}
		connection.close();
		return password;
	}
}