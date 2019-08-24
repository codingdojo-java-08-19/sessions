<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  -->
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>An Author</title>
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
	<h1>Profile for ${ author.name }</h1>
	
	
	<section>
		<h3>Bio</h3>
		
		<p>Name: ${ author.name }</p>
		<p>Age: ${ author.age }</p>
		
		<section>
			<h4>Books</h4>
			
			<c:choose>
				<c:when test="${ author.books.size() > 0 }">
					<table>
						<thead>
							<tr>
								<th>Title</th>
								
								<th>Pages</th>
								
								<th>Publisher</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${ author.books }">
								<tr>
									<td><a href="/books/${ book.id }">${ book.title }</a></td>
									<td>${ book.pages }</td>
									<td>${ book.publisher }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<p>No books added for this author yet!</p>
				</c:otherwise>
			</c:choose>
		</section>
	</section>
</main>
</body>
</html>