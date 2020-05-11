<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Update user</title>
		<link rel="stylesheet" href="../style.css" /> 
	</head>
	<body>
		<form action="updateUser" method="post" id="updateUs">			
		 	Id : <br />
				<input type="number" name="id" value="${ updateUs.getIdUser() }"  /> <br /> 
						
			First name : <br /> 
				<input type="text" name="firstName"	value="${ updateUs.getFirstName() }" required /> <br />
					
			Last name : <br />
				<input type="text" name="lastName" value="${ updateUs.getLastName() }" required /> <br />
					
			Login : <br />			 		
				<input type="text" name="login" value="${ updateUs.getLogin() }" required /> <br />
								
			Password :	<br />				
				<input type="text" name="password" value="${ updateUs.getPassword() }" required /> <br />
				<input type="submit" value="Update" />
		</form>
		<a href="viewUserList.jsp"> <img alt="Error display image"
			src="../checkoutDB.png" width=70 height=70>
		</a>
	</body>
</html>