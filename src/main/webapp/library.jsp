<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>Library</title>
</head>
<body>
	<div id="picture">
		<a href="library"><img src="images/OpenBooks.png" width="116" height="79" title="library"></a>
	</div>
	<div id="menu">
		<h3>Welcome to library</h3>
		<p>
			<a href="index.html">Home page</a>
			<a href="upload.html">Upload books</a>
		</p>
	</div>
	<div id="table">
		<table>
			<tr>
				<th> Bok ID </th>
				<th> Autor </th>
				<th> Title </th>
				<th> Year Edition </th>
				<th> Pages </th>
			</tr>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td><c:out value="${book.bookId}" /></td>
					<td class="left"><c:out value="${book.bookAutor}" /></td>
					<td class="left"><c:out value="${book.bookTitle}" /></td>
					<td><c:out value="${book.yearEdition}" /></td>
					<td><c:out value="${book.pages}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
