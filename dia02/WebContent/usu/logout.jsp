<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout - Usuario</title>
</head>
<body>
<!-- Scriplet (Script jsp) -->
<%
	try{
			
		session.setAttribute("usuario", null);
		session.invalidate();
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-control", "no-cache");
		response.setDateHeader("Expires",0);
		response.setDateHeader("Max-age",0);
		
	}catch(Exception ex){
		
	
	}
response.sendRedirect("../sistema.jsp");
%>
</body>
</html>