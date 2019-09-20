<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="gotoback.html">Home</a>
<form:form modelAttribute="profile" action="getupdatemodule.html" method="post"   >
		<table align="center">
		
		<tr>
			<td><form:label path="subjectid" >subjectid:</form:label></td>
			<td><form:input path="subjectid" size="10"/></td>
			<td> <font color="red">
				<form:errors path="subjectid"/></font></td>
		</tr>
		
		<tr>
			<td><form:label path="subjecttitle" >Subjecttitle:</form:label></td>
			<td><form:input path="subjecttitle" size="10"/></td>
			<td> <font color="red">
				<form:errors path="subjecttitle"/></font></td>
		</tr>
	
		<tr><td><input type="submit" value="updatesubject"/></td></tr>
	</table>
	</form:form>

</body>
</html>