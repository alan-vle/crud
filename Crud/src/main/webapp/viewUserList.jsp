<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<link href="../style.css" rel="stylesheet" type="text/css" />		
		<title>View user list</title>
	</head>
	<body>
		<div id="listUser">
			<h4>Hello ${ login }, here's the list of users :</h4>
				<table>
					<tr>
						<th class="idUser">Id</th>
						<th>First name</th>
						<th>Last name</th>
						<th>Login</th>
						<th>Password</th>
					 	<th>
					 		<c:if test="${ sessionScope.admin=='true' }">
								<a href="../admin/addUs"> 
									<img alt="Error display image" src="../addUser.png" width=60 height=60 />
								</a>
							</c:if>	
					    </th>
						<th>						
								<a href="../logout"> 
									<img alt="Error display image" src="../arrow.png" width=60 height=60 />
								</a>						
						</th>
					</tr>
					<c:forEach items="${ userList }" var="us">
						<tr>
							<td class="idUser">${ us.getIdUser() }</td>
							<td>${ us.getFirstName() }</td>
							<td>${ us.getLastName() }</td>
							<td>${ us.getLogin() }</td>
							<td>${ us.getPassword() }</td>
							<td>
								<c:if test="${ sessionScope.admin=='true' }">
									<a href="../admin/updateUser?id=${ us.getIdUser() }">
										<img alt="Error display image" src="../edit.png" width=60 height=60 />
									</a>
								</c:if>	
							</td>
							<td>
								<c:if test="${ sessionScope.admin=='true' }">
									<a href="../admin/delUser?id=${ us.getIdUser() }">
										<img alt="Error display image" src="../delete.png" width=60 height=60 />
									</a>
								</c:if>
							</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>