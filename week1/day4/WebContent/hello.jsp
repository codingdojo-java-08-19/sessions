<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--  -->   
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Web</title>
<script src="main.js"></script>
<link rel="stylesheet" href="styles.css" />
</head>
<body>
	<h1>Hello Web</h1>
	
<%! 
public int add(int a, int b) {
	return a + b;
}
%>


<%
int i = 908;
int j = 123;
%>

<h3><%= add(i, j) %></h3>

<section>
<h1>Hello <c:out value="${ name }" /> </h1>


<ul>
	<c:forEach var="person" items="${ people }">
		<li><c:out value="${ person }" /> </li>
	</c:forEach>
</ul>
</section>


<section>
	<fieldset>
		<legend>Names</legend>
		
		<form action="/Howdy/Hello" method="POST" autocomplete="off">
		<div>
			<label>Name</label>
			<input type="text" name="name">
		</div>
		<button>Submit</button>
	</form>
	</fieldset>

</section>





</body>
</html>