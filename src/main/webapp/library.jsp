<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Library</title>
</head>

<body background="images/stone.jpg">
	<table width="80%" height="75" border="0" align="center">
	
		<tr>
			<th rowspan="2" width="116" valign="top"><a href="library"><img
					src="images/OpenBooks.png" width="116" height="79" title="library"></a>
			</th>
			<th>
				<font size="5">Welcome to library</font>
			</th>
		</tr>
		<tr>
			<td>
				<center>
					<p>
						<b><a href="index.html">Home page</a></b> / <b><a href="download.html">Download books</a></b>
					</p>
				</center>
			</td>
		</tr>
	</table>
	
	<table width="70%" height="75" border="0" align="center">
		<tr>
			<th> Bok ID </th>
			<th> Autor </th>
			<th> Title </th>
			<th> Year Edition </th>
			<th> Pages </th>
		</tr>
	<c:forEach items="${booksList}" var="book">
		<tr>
			<td>
				<c:out value="${book.bookId}" />
			</td>
			<td>
				<c:out value="${book.bookAutor}" />
			</td>
			<td>
				<c:out value="${book.bookTitle}" />
			</td>
			<td align="center">
				<c:out value="${book.yearEdition}" />
			</td>
			<td align="center">
				<c:out value="${book.pages}" />
			</td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>