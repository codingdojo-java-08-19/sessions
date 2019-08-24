<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!--  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Book</title>
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
		<fieldset>
			<legend>Create Book</legend>
			
			<form:form
				action="/books"
				method="post"
				modelAttribute="book"
				autocomplete="off"
			>
				<div>
					<form:label path="title">Title</form:label>
					<form:input path="title" required="true" />
					<form:errors path="title" />
				</div>
				<div>
					<form:label path="publisher">Publisher</form:label>
					<form:input path="publisher" required="true" />
					<form:errors path="publisher" />
				</div>
				
				<div>
					<form:label path="pages">Pages</form:label>
					<form:input path="pages" type="number" required="true" min="1" />
					<form:errors path="pages" />
				</div>
				
				<div>
					<form:label path="author">Author</form:label>
					<form:select path="author" required="true">
						<form:option value="-" selected="true" disabled="true" label="Select an Author"/>
						<form:options items="${ authors }" itemValue="id" itemLabel="name" />
					</form:select>
				</div>
				
				<button>Create</button>
			</form:form>
		</fieldset>
	</main>
</body>
</html>