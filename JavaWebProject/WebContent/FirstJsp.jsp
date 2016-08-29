<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World - JSP tutorial</title>
</head>
<body %= "Hello World!" %>

<form action="${pageContext.request.contextPath}/myservlet" method="post">
    <button type="submit" name="button" value="button1">Button 1</button>
    <button type="submit" name="button" value="button1">Button 2</button>
    <button type="submit" name="button" value="button1">Button 3</button>
</form>
</body>
</html>