<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>Insert books</title>
</head>
<body>
	<div id="picture">
		<a href="library"><img src="images/OpenBooks.png" width="116" height="79" title="library"></a>
	</div>
	<div id="menu">
		<h3>Welcome to library</h3>
		<p>
			<a href="library">Show library</a>
			<a href="upload.html">Upload books</a>
		</p>
	</div>
	<p>${message}</p>
</body>
</html>
