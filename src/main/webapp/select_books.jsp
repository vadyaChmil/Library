<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
		</p>
	</div>
	<form method="GET" action="upload_books">
	<table>
		<c:if test="${fn:length(uploadBookList) gt 0}">
			<tr>
				<th> Bok ID </th>
				<th> Autor </th>
				<th> Title </th>
				<th> Year Edition </th>
				<th> Pages </th>
			</tr>
			<c:forEach items="${uploadBookList}" var="book">
				<tr>
					<td>
						<label><input type="Checkbox" name="bookId" value="${book.bookId}" checked>
						<c:out value="${book.bookId}" />
						</label>
					</td>
					<td class="left"><c:out value="${book.bookAutor}" /></td>
					<td class="left"><c:out value="${book.bookTitle}" /></td>
					<td><c:out value="${book.yearEdition}" /></td>
					<td><c:out value="${book.pages}" /></td>
				</tr>
			</c:forEach>
		</c:if>
		<tr class="left">
			<td colspan="5">
				<c:if test="${fn:length(uploadBookList) gt 0}">
   					<p>Uncheck book if don't want to upload it to library</p>
   					<p><input type="Submit" name="submit" value="Send"></p>
				</c:if>
				<c:if test="${fn:length(uploadBookList) lt 1}">
			   		<p>Document is empty or you haven't chosen the document.</p>
				</c:if>
			<td>
		</tr>
	</table>
	
</form>
</body>
</html>
