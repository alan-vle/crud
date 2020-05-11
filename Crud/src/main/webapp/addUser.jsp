<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add user</title>
		<link rel="stylesheet" href="../style.css" />
	</head>
<body>
	<form action="addUs" id="styleAddUser" method="post" >
		<!-- Add user form -->
		Id : <br /> <input type="number" name="id" /> <br /> 
		First name <br /> <input type="text" name="firstName" required /> <br />
		Last name <br /> <input type="text" name="lastName" required /> <br />
		Login <br /> <input type="text" name="login" required /> <br />
		Password <br /> <input type="text" name="password" required /> <br />
		<input type="submit" value="Submit" />
	</form>
	<a href="viewUserList.jsp"> <img alt="Error display image"
		src="../checkoutDB.png" width=70 height=70>
	</a>
</body>
</html>