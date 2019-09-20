<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="POST" action="/aviDelete.html" ModelAttribute="module">


 <c:if test="${!empty participants}">
		<h2><center>List Participants</center></h2>
	<table align="center" border="1">
		<tr>
			<th>Participants ID</th>
			<th>Participants Name</th>
			<th>Participants basl</th>
			<th>Participants Email</th>
			
	
		</tr>

		<c:forEach items="${participants}" var="participant">
			<tr>
				<td><c:out value="${participant.empid}"/></td>
				<td><c:out value="${participant.name}"/></td>
				<td><c:out value="${participant.basl}"/></td>
				<td><c:out value="${participant.email}"/></td>
				
			</tr>
		</c:forEach>
	</table>
</c:if>
		

</form:form>


</body>
</html>