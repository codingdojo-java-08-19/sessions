<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  -->
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="/authors">Authors</a></li>
			<li><a href="/authors/new">Create Author</a></li>
			<li><a href="/books">Books</a></li>
			<li><a href="/books/new">Create Book</a></li>
		</ul>
	</nav>
	
	<main>
		<h1>Books</h1>
		<table>
			<thead>
				<tr>
					<th>Title</th>
					<th>Pages</th>
					<th>Author</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${ books }">
					<tr>
						<td><a href="/books/${ book.id }">${ book.title }</a></td>
						<td>${ book.pages  }</td>
						<td><a href="/authors/${ book.author.id }">${ book.author.name }</a></td>
						<td><a href="/books/${ book.id }/edit">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</main>
</body>
</html>