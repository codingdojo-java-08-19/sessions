<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!--  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Author</title>
</head>
<body>
	<main>
		<fieldset>
			<legend>Create Author</legend>
			
			
			<form:form
				action="/authors"
				method="POST"
				modelAttribute="author"
				autocomplete="off"
			>
			
				<div>
					<form:label path="name">Name</form:label>
					<form:input path="name" required="true" />
					<form:errors path="name" />
				</div>
				
				<div>
					<form:label path="age">Age</form:label>
					<form:input path="age" type="number" required="true" />
					<form:errors path="age" />
				</div>
			
				<button>Create</button>
			</form:form>
			
		</fieldset>
	</main>
</body>
</html>