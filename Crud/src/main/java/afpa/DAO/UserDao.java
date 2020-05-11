package afpa.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import afpa.Beans.User;

public class UserDao {
	
	Connection connec; // var Connection
	User usr = null; // var object User
	
	public UserDao() {
		connec = null;
	}
//	public ResultSet Asc() {
//		try (Connection connec = UserDao.getConnection()){
//			preStat = connec.prepareStatement("SELECT * FROM users ORDER BY id ASC");
//			resSet = preStat.executeQuery();
//		} catch(Exception e){
//			System.out.println("Echec");
//		}
//		return resSet;
//	}
	public static Connection getConnection(){
		Connection connec = null;
		// Chargement du driver
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loading driver ok");			

		} catch (ClassNotFoundException e) {
			System.out.println("Error loading driver");
		}

		// Connexion bdd
		
		try {
			String url="jdbc:mysql://mysql-sedinsedir.alwaysdata.net/sedinsedir_listusers?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
			connec = DriverManager.getConnection(url,
													"197430_sed", 
													"W1x2c3v4b5");
			System.out.println("Connection established");
		} catch (SQLException e) {
			System.out.println("Failed connection");
		}
			return connec;
	}
	public User law(String login, String passw) throws SQLException {
		try ( Connection connec = UserDao.getConnection()) {
			try ( PreparedStatement preStat = connec.prepareStatement(
					"SELECT * FROM admin WHERE login=? AND password=?") ) { 
				preStat.setString(1, login);
				preStat.setString(2, passw);
				try( ResultSet resSet = preStat.executeQuery()){ 			
					resSet.next();
						if ( resSet.getString(5).equals(passw) ){
							usr = new User();
							usr.setIdUser( resSet.getInt(1) );
							usr.setFirstName( resSet.getString(2) );
							usr.setLastName( resSet.getString(3) ); 
							usr.setLogin( resSet.getString(4) );
							usr.setPassword( resSet.getString(5) );
						} else {
							System.out.println("Login or password invalid.");
							return null;
						}
				}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("");
		}
		return usr;		
	}

	public List <User> getAllRecords(){
		
        List <User> listAllUser = new ArrayList <User>();
             
             try (Connection connec = UserDao.getConnection()){
            	 	
            	 	try ( PreparedStatement preStat = connec.prepareStatement("SELECT * FROM listUsersCrud ORDER BY id") ){
            	 		try ( ResultSet resSet = preStat.executeQuery() ) {
            	 	
		                    while(resSet.next()) {
		                    	usr = new User();
		                    	usr.setIdUser( resSet.getInt(1) );
		                    	usr.setFirstName( resSet.getString(2) );
		                    	usr.setLastName( resSet.getString(3) );
		                    	usr.setLogin( resSet.getString(4) );
		                    	usr.setPassword( resSet.getString(5) );
		                        listAllUser.add(usr);
		                    }
            	 		}
            	 	}

             } catch(NumberFormatException e){ 
            	 e.printStackTrace();
             } catch(SQLException e) {
            	 e.printStackTrace();
             }
             
             return listAllUser;
        
	}
	

	public static int insert(User usr) {
		int actInsert = 0;
						
		try ( Connection connec = UserDao.getConnection() ){
			
			try ( PreparedStatement preStat = connec.prepareStatement(
					"INSERT INTO listUsersCrud (Id, firstName, lastName, login, password) VALUES (?,?,?,?,?)") ) {											
								preStat.setInt( 1, usr.getIdUser() );
								preStat.setString( 2, usr.getFirstName() );
								preStat.setString( 3, usr.getLastName() );
								preStat.setString( 4, usr.getLogin() );
								preStat.setString( 5, usr.getPassword() );						
								actInsert = preStat.executeUpdate();					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return actInsert;		
	}
		
	public static User getByIdUser(String id) {
		User usr = null;
		try( Connection connec = UserDao.getConnection()){
			try ( PreparedStatement preStat = connec.prepareStatement("SELECT * FROM listUsersCrud WHERE Id=?") ) {
				preStat.setString(1, id);
				try ( ResultSet resSet = preStat.executeQuery() ) {
					while( resSet.next() ) {
						usr = new User();
						usr.setIdUser( resSet.getInt(1) );
						usr.setFirstName( resSet.getString(2) );
						usr.setLastName( resSet.getString(3) );
						usr.setLogin( resSet.getString(4) );
						usr.setPassword( resSet.getString(5) );
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();;
		}
		return usr;		
	}
	
	public static int delete(User usr) {
		
		 int actDel = 0;
		 
		 try ( Connection connec = UserDao.getConnection() ) {			 
    	 	try ( PreparedStatement preStat = connec.prepareStatement("DELETE FROM listUsersCrud WHERE Id=?") ) {
	    	 	preStat.setInt( 1, usr.getIdUser() );
	    	 	actDel = preStat.executeUpdate();
    	 	}	
		 } catch(SQLException e) {
        	e.printStackTrace();		 
		 }
		return actDel;
		
	}
	public static int update(User usr) {
		int actUp = 0;
		
			try ( Connection connec = UserDao.getConnection() ) {
				try ( PreparedStatement preStat = connec.prepareStatement(
						"UPDATE `listUsersCrud` SET firstName=?,lastName=?,login=?,password=? WHERE Id=?") ) {
					preStat.setString( 1, usr.getFirstName() );
					preStat.setString( 2, usr.getLastName() );		
					preStat.setString( 3, usr.getLogin() );		
					preStat.setString( 4, usr.getPassword());
					preStat.setInt( 5, usr.getIdUser());
					actUp = preStat.executeUpdate();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Test error !");
			}
		return actUp;
	}
}




	

