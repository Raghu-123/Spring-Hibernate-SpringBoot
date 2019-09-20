<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>phase</title>
	</head>
	<body>
	
<a href="gotoback.html">Home</a>
	<center>${msg}</center>
		<center><h2>Add phase Data</h2></center>
		
		
		<form:form method="POST" action="update1.html"  >
	   		<table align="center">
			    <tr>
			        <td><form:label path="phaseid">Pase ID:</form:label></td>
			        <td><form:input path="phaseid" value="${phase.phaseid}" readonly="true" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="phasedescription">Phase Description:</form:label></td>
			        <td><form:input path="phasedescription" value="${phase.phasedescription}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="assessmentDate">Assessment Date:</form:label></td>
			        <td><form:input path="assessmentDate"  value="${phase.assessmentDate}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="duration">Duration:</form:label></td>
			        <td><form:input path="duration"  value="${phase.duration}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="remarks">Remarks:</form:label></td>
                    <td><form:input path="remarks" value="${phase.remarks}"/></td>
			    </tr>
			    
			    <tr>
			      <td colspan="2"><input type="submit" value="update"/></td>
		      </tr>
			</table> 
		</form:form>
		
		<c:if test="${!empty phases}">
		<center><h2>List Phases</h2></center>
	<table  border="1" align="center">
		<tr>
			<th>Phase Id</th>
			<th>Phase Description</th>
			<th>Assement Date</th>
			<th>Duration</th>
			<th>Remarks</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${phases}" var="phase">
			<tr>
				<td><c:out value="${phase.phaseid}"/></td>
				<td><c:out value="${phase.phasedescription}"/></td>
				<td><c:out value="${phase.assessmentDate}"/></td>
				<td><c:out value="${phase.duration}"/></td>
				<td><c:out value="${phase.remarks}"/></td>
				<td align="center"><a href="edit1.html?phaseid=${phase.phaseid}">Edit</a> | <a href="delete1.html?phaseid=${phase.phaseid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
  
	</body>
</html>