<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!--  -->
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authors</title>
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
		<h1>Authors</h1>
		
		<section>
			<table>
				<thead>
					<tr>
						<th>Name</th>
						<th>Age</th>
						<th>Books Count</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="author" items="${ authors }">
						<tr>
							<td><a href="/authors/${ author.id }">${ author.name }</a></td>
							<td>${ author.age }</td>
							<td>${ author.books.size() }</td>
							<td>Future Actions</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</main>
</body>
</html>