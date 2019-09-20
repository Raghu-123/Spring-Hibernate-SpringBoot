<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

<body>

<h4><center>This is module list</center></h4>
<form:form method="POST" action="/aviDelete.html" ModelAttribute="module">
<c:if test="${!empty modules}">
	<table align="center" border="1">
		<tr>
			<th>Subject ID</th>
			<th>Subject Title</th>
			<th>Description</th>
			<th>Comments</th>
			<th>Duriation</th>
			
		</tr>

		<c:forEach items="${modules}" var="module">
			<tr>
				<td><c:out value="${module.subjectid}"/></td>
				<td><c:out value="${module.subjecttitle}"/></td>
				<td><c:out value="${module.description}"/></td>
				<td><c:out value="${module.comments}"/></td>
				<td><c:out value="${module.duration}"/></td>
			<Ul><td><form:checkboxes items="${module.subjectid}"  value="${module.subjectid}" element="li"/></td></Ul>
			</tr>
		</c:forEach>
	</table>
			</c:if>
		</form:form>



</body>
</html>