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

<c:if test="${!empty streams}">
		<h2><center>List Streams</center></h2>
	<table align="center" border="1">
		<tr>
			<th>STREAM ID</th>
			<th>STREAM NAME</th>
			<th>STREAM DETAILS</th>
			
			<th>COMMENTS</th>
		</tr>

		<c:forEach items="${streams}" var="stream">
			<tr>
				<td><c:out value="${stream.streamid}"/></td>
				<td><c:out value="${stream.streamname}"/></td>
				<td><c:out value="${stream.streamdetails}"/></td>
			
				<td><c:out value="${stream.comments}"/></td>
				</tr>
		</c:forEach>
	</table>
</c:if>
	
	

</body>
</html>