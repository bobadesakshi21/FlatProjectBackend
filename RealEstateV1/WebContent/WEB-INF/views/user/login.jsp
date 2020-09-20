<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
	  <%--  <h3 style="color: red">${requestScope.msg}</h3> --%>
	   <table style="background-color: Bisque" border="1">
			<tr>
				<td>Enter email :</td>
				<td><input type="text" name="email"></td>
			</tr>
			
			<tr>
				<td>Enter password :</td>
				<td><input type="password" name="password"></td>
			<tr>
	          
	       <tr>
	          <td><input type="submit" value="Login"></td>
	       </tr>
	   </table>
   </form>
</body>
</html>