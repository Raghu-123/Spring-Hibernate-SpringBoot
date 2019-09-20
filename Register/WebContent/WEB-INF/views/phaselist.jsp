<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All phases</title>
</head>
<body>






<form:form method="POST" action="/aviDelete.html">

<c:if test="${!empty phases}">
<h4><center>List of phases</center></h4>
	<table align="center" border="1">
		<tr>
			<th>Phase ID</th>
			<th>Phase Description</th>
			<th>Assement Date</th>
			<th>Duration</th>
			<th>Remarks</th>
			

		</tr>

		<c:forEach items="${phases}" var="phase">
			<tr>
				<td><c:out value="${phase.phaseid}"/></td>
				<td><c:out value="${phase.phasedescription}"/></td>
				<td><c:out value="${phase.assessmentDate}"/></td>
				<td><c:out value="${phase.duration}"/></td>
				<td><c:out value="${phase.remarks}"/></td>
			<Ul><td><form:checkboxes items="${phase.phaseid}"  value="${phase.phaseid}" element="li"/></td></Ul>
			</tr>
		</c:forEach>
	</table>

			</table> 
			</c:if>
		</form:form>

</body>
</html>