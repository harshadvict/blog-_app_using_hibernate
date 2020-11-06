<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Code Wall</title>
    <link type="text/css" rel="stylesheet" href="./css/blog.css">
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<%-- <style type="text/css">
<%@include file="style.css" %>
<%@include file="blog.css" %>
</style> --%>
</head>
<body>
 <nav>
        <img src="${pageContext.request.contextPath}/assets/logo.svg" alt="logo" />
        <ul>
           <li> <a href="${pageContext.request.contextPath}/myblogs">My Blogs</a></li>
           		 <li> <a href="${pageContext.request.contextPath}/allblogs">All Blogs</a></li>
             <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li> <a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
           
        </ul>
    </nav>
    <div class="body-div1">
        <div>Your Blog Posts</div>
   <c:if test="${bloglist == null}">
  <a href="${pageContext.request.contextPath}/new"><button class="button" id="addBlog" ><i class="fas fa-plus-circle"></i>Add New Post</button></a>  
   </c:if>
    </div>
<!-- <div id="popup"> -->
<!-- Popup Div Starts Here -->
<div id="popupContact">
<img id="close" src="./assets/close-button.svg">
<img id="rect" src=./assets/rect.svg>
<h2>Your Post</h2>
 

<!-- Contact Us Form -->
<%-- <form action="${pageContext.request.contextPath}/new" id="form" method="post" name="form"> --%>
 		<c:if test="${bloglist != null}">
            <form action="${pageContext.request.contextPath}/update" method="post">
        </c:if>
        <c:if test="${bloglist == null}">
            <form action="${pageContext.request.contextPath}/new" method="post">
        </c:if>
 		<c:if test="${bloglist != null}">
  		<input type="hidden" name="blogId" value="<c:out value='${bloglist.getBlogId()}' />" />
   		</c:if>  
					<c:if test="${bloglist != null}">
            			Edit Blog
            		</c:if>
						<c:if test="${bloglist == null}">
            			Add New Blog
            		</c:if>
		<input id="title" name="title" value="<c:out value='${bloglist.getBlogTitle()}'/>" placeholder="Title" type="text"/>
		<textarea id="msg" name="message" placeholder="Description"><c:out value='${bloglist.getBlogDescription()}'/></textarea>
		<button id="post" type="submit" >POST</button>
	</form>
</div>
</body>
</html>