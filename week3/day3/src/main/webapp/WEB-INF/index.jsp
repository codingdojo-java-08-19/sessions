<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
       
        
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!--  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<main>
		<section>
			<h2>Register</h2>
			
			<p><form:errors path="user.*" /></p>
		
			<fieldset>
				<form:form 
					action="/sessions/register"
					method="post"
					autocomplete="off"
					modelAttribute="user"
				>
				
				<div>
					<form:label path="username">Username</form:label>
					<form:input path="username" required="true" />
				</div>
				<div>
					<form:label path="email">Email</form:label>
					<form:input type="email" path="email" required="true" />
				</div>

				<div>
					<form:label path="password">Password</form:label>
					<form:input type="password" path="password" required="true" />
				</div>
				<div>
					<form:label path="passwordConfirmation">Password Confirmation</form:label>
					<form:input type="password" path="passwordConfirmation" required="true" />
				</div>

					<button>Register</button>
				</form:form>
			</fieldset>
		</section>
	
		<section>
			<h2>Login</h2>
			<p>${error }</p>
			<fieldset>
				<form:form 
					action="/sessions/login"
					method="post"
					autocomplete="off"
				>
					<div>
						<label>Email</label>
						<input type="email" name="email">
					</div>
					
					<div>
						<label>Password</label>
						<input type="password" name="password">
					</div>
					<button>Login</button>
				</form:form>
			</fieldset>
		</section>
	</main>
</body>
</html>