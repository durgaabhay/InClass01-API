<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
     <h2>Registration</h2>
      
     <div class="ex">
		<form action="AddPersonHandler" method="post">
			<table style="with: 50%">
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="fullname" /></td>
				</tr>
				<tr>
					<td>Preferred User Id</td>
					<td><input type="text" name="userId" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" /></td>
				</tr>
				<tr>
					<td>Weight</td>
					<td><input type="text" name="weight" /></td>
				</tr>
				
			</table>
			<input type="submit" value="register" />
		</form>
	</div>
      
</body>
</html>