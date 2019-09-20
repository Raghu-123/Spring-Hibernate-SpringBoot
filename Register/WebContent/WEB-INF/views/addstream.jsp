<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding stream</title>
<center><h1>ADD THE STREAM</h1></center>
</head>
<body>
<a href="gotoback.html">Home</a>
<form:form action="save3.html" method="post"  >
		<table align="center">
		
		 <tr>
			        <td><form:label path="streamid">stream Id:</form:label></td>
			        <td><form:input path="streamid" value="${stream.streamid}"  /></td>
			    </tr>
		
		 
		 <tr>
			        <td><form:label path="streamname">stream Name :</form:label></td>
			        <td><form:input path="streamname" value="${stream.streamname}" /></td>
			    </tr>
		
		
		 <tr>
			        <td><form:label path="streamdetails">stream Details :</form:label></td>
			        <td><form:input path="streamdetails" value="${stream.streamdetails}" /></td>
			    </tr>
			  
		
		 <tr>
			        <td><form:label path="comments">comments :</form:label></td>
			        <td><form:input path="comments" value="${stream.comments}"/></td>
			    </tr>
		
		
	
		<tr><td><input type="submit" value="addStream"/></td></tr>
	</table>
	</form:form>
	
	<c:if test="${!empty streams}">
		<h2>List Streams</h2>
	<table align="left" border="1">
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
				<td align="center"><a href="edit3.html?streamid=${stream.streamid}">Edit</a> | <a href="delete3.html?streamid=${stream.streamid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	
	
</body>
</html>