<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home page</title>
		<link rel="stylesheet" href="style.css" />
	</head>
	<body>	
		<form action="login" method="post" id="formLogin">
			<h2>Hello World!</h2>
			Login : <br /> 
			<input type="text" name="login" required /> <br />
			Password : <br /> 
			<input type="password" name="password" required /> <br /> <br />
			<input type="submit" value="Submit" />
			<input type="reset" value="Reset" />
<!-- 			<button type="submit">
				<img alt="Error display image" src="submit.png" width=30 height=30 />
			</button>
			<button type="reset">
				<img alt="Error display image" src="reset.png" width=30 height=30 />
			</button> -->		
		</form>
	</body>
</html>