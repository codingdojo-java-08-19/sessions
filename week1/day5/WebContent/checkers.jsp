<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkers</title>
<link rel="stylesheet" href="styles.css" />
</head>
<body>
	<%!
		// methods here
		public boolean isEven(int a, int b) {
			return (a + b) % 2 == 0;
		}
	%>
	
	<%
	int width = Integer.parseInt(request.getParameter("width"));
	int height = Integer.parseInt(request.getParameter("height"));
		// variables here
	%>


	<h1> CheckerBoard: <%= width %>w X <%= height %>h </h1>
	
	<div class='board'>
		<% for(int i = 0; i < height; i++) { %>
			<div class='row'>
				<% for (int j =0; j < width; j++) { %>
				<!--                       (expression) ? (if true) : (if false)     -->
					<div class='square <%= isEven(i, j) ? "even" : "odd" %>'>
					</div>
				<% } %>
			</div>
			
		<% } %>
	</div>
</body>
</html>