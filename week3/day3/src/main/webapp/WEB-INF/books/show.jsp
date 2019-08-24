<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
            
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!--  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!--  -->
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="/authors">Authors</a></li>
			<li><a href="/authors/new">Create Author</a></li>
			<li><a href="/books">Books</a></li>
			<li><a href="/books/new">Create Book</a></li>
			<c:if test="${ userId != null }">
				<form
					action="/sessions/logout"
					method="post"
				>
					<input type="hidden" name="_method" value="delete"/>
					<button>Logout</button>
				</form>
			</c:if>
		</ul>
	</nav>
	
	<div class='notifications'>
		<c:if test="${ success != null }">
			<p>
				${ success }
			</p>
		</c:if>
		<c:if test="${ error != null }">
			<p>
				${ error }
			</p>
		</c:if>
		
	</div>
	<main>
		<h1>${ book.title  }</h1>
		
		<section>
			<p>Pages: ${ book.pages }</p>
			<p>Publisher: ${ book.publisher }</p>
			<p>Author: <a href="/authors/${ book.author.id }">${ book.author.name }</a></p>
			
			
			<div>
			
				<h3>Reviews</h3>
				
				<c:forEach var="review" items="${ book.reviews }">
					<div>
					<hr>
						<p>${review.content }</p>
						<p class='reviewer'>
							-${ review.user.username } <small><fmt:formatDate dateStyle="short" value="${ review.createdAt }" /></small>
						</p>
						<h4> Liked ${ review.likedReviews.size() } times!</h4>
						
						
						<c:if test="${ userId != null }">
							<c:choose>
								<c:when test="${ !review.hasUserLiked(userId) }">
												<form:form
										action="/liked_reviews"
										method="post"
										modelAttribute="liked_review"
									>
										<form:hidden path="user" value="${ userId }" />
										<form:hidden path="review" value="${ review.id }" />
										<button>Like!</button>
									</form:form>
						
								</c:when>
							
							</c:choose>
						</c:if>
					</div>
				</c:forEach>
			</div>
		</section>
		<section>
		
			<c:choose>
				<c:when test="${ userId == null }">
					<p>Login to review</p>
				</c:when>
				<c:when test="${ !book.hasUserReviewed(userId) }" >
					<fieldset>
						<legend>Add Review</legend>
					
						<form:form 
							action="/books/${book.id }/reviews"
							method="post"
							modelAttribute="review"
							automcomplete="off"
						>
							<form:hidden path="book" value="${ book.id }"/>
							<form:hidden path="user" value="${ userId }"/>
							
							<div>
								<form:label path="content">Content</form:label>
								<form:textarea path="content" required="true" min="10" row="10" columns="50" />
								<form:errors path="content" />
							</div>
							<button>Create Review</button>
						</form:form>
					</fieldset>		
				</c:when>
				<c:otherwise>
					<p>You have already reviewed this book</p>
				</c:otherwise>
				
			</c:choose>
		

		</section>
	</main>
</body>
</html>