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
<a href="gotoback.html">Home</a>

<h2>Update Participant Data</h2>
		<form:form method="POST" action="update2.html"  >
	   		<table>
			    <tr>
			        <td><form:label path="empid">Participants ID:</form:label></td>
			        <td><form:input path="empid" value="${participant.empid}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Participants Name:</form:label></td>
			        <td><form:input path="name" value="${participant.name}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="basl">Participants Basl:</form:label></td>
			        <td><form:input path="basl" value="${participant.basl}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="email">Participants Email:</form:label></td>
			        <td><form:input path="email" value="${participant.email}"/></td>
			    </tr>
			    
			  <tr>
			      <td colspan="2"><input type="submit" value="updateparticipant"/></td>
		      </tr>
			</table> 
		</form:form>
		
		
 <c:if test="${!empty participants}">
		<h2>List </h2>
	<table align="left" border="1">
		<tr>
			<th>Participants ID</th>
			<th>Participants Name</th>
			<th>Participants basl</th>
			<th>Participants Email</th>
			
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${participants}" var="participant">
			<tr>
				<td><c:out value="${participant.empid}"/></td>
				<td><c:out value="${participant.name}"/></td>
				<td><c:out value="${participant.basl}"/></td>
				<td><c:out value="${participant.email}"/></td>
				
				<td align="center"><a href="edit2.html?empid=${participant.empid}">Edit</a> | <a href="delete2.html?empid=${participant.empid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
		
 
</body>
</html>