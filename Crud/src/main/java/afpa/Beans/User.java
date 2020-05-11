package afpa.Beans;

public class User {
	
	private int idUser;
	private String lastName;
	private String firstName;
	private String login;
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

//	public void setIdUser1(String idUser) {
//		this.idUser = idUser;
//		
//	}
}
