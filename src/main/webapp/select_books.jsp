<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Library</title>
</head>

<body background="images/stone.jpg">
<form action="insert_books" method="GET" name="insert">

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
						<b><a href="index.html">Home page</a></b>
					</p>
				</center>
			</td>
		</tr>
	</table>
	
	<table width="70%" height="75" border="0" align="center">
		<c:if test="${fn:length(downloadedBooksList) gt 0}">
			<tr>
				<th> Bok ID </th>
				<th> Autor </th>
				<th> Title </th>
				<th> Year Edition </th>
				<th> Pages </th>
			</tr>
			<c:forEach items="${downloadedBooksList}" var="book">
				<tr>
					<td>
						<label><input type="Checkbox" name="bookId" value="${book.bookId}" checked>
						<c:out value="${book.bookId}" />
						</label>
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
		</c:if>
		<tr>
			<td colspan="5">
				<c:if test="${fn:length(downloadedBooksList) gt 0}">
   					<p>Uncheck book if don't want to download it to library</p>
   					<p><input type="Submit" name="submit" value="Send"></p>
				</c:if>
				<c:if test="${fn:length(downloadedBooksList) lt 1}">
			   		<p>Document is empty or you haven't chosen the document.</p>
				</c:if>
			<td>
		</tr>
	</table>
	
</form>
</body>
</html>
