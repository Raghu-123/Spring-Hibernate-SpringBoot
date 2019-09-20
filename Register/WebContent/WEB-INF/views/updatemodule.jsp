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

<script type="text/javascript">
    function validateForm()
    {
    var a=document.forms["Form"]["comments"].value;
    var b=document.forms["Form"]["subjecttitle"].value;
    var c=document.forms["Form"]["duration"].value;
    var d=document.forms["Form"]["description"].value;
    if (a==null || a=="",b==null || b=="",c==null || c=="",d==null || d=="")
      {
      alert("Please Fill All Required Field");
      return false;
      }
    }
    </script>



<form:form action="update.html" method="post" onsubmit="return validateForm()" name="Form" >
		<table align="center">
		
		 <tr>
			        <td><form:label path="subjectid">Subject Id :</form:label></td>
			        <td><form:input path="subjectid" value="${module.subjectid}"  readonly="true"/></td>
			    </tr>
		
		 
		 <tr>
			        <td><form:label path="subjecttitle">subjecttitle :</form:label></td>
			        <td><form:input path="subjecttitle" value="${module.subjecttitle}" /></td>
			    </tr>
		
		
		 <tr>
			        <td><form:label path="duration">duration :</form:label></td>
			        <td><form:input path="duration" value="${module.duration}" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="description">description :</form:label></td>
			        <td><form:input path="description" value="${module.description}"/></td>
			    </tr>
		
		 <tr>
			        <td><form:label path="comments">comments :</form:label></td>
			        <td><form:input path="comments" value="${module.comments}"/></td>
			    </tr>
		
		
	
		<tr><td><input type="submit" value="updatemodule"/></td></tr>
	</table>
	</form:form>
	
	<c:if test="${!empty modules}">
		<h2>List MODULES</h2>
	<table align="left" border="1">
		<tr>
			<th>SUBJECT ID</th>
			<th>SUBJECT TITILE</th>
			<th>DURATION</th>
			<th>DESCRIPTION</th>
			<th>COMMENTS</th>
		</tr>

		<c:forEach items="${modules}" var="module">
			<tr>
				<td><c:out value="${module.subjectid}"/></td>
				<td><c:out value="${module.subjecttitle}"/></td>
				<td><c:out value="${module.duration}"/></td>
				<td><c:out value="${module.description}"/></td>
				<td><c:out value="${module.comments}"/></td>
				<td align="center"><a href="edit.html?subjectid=${module.subjectid}">Edit</a> | <a href="delete.html?subjectid=${module.subjectid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	
	
</body>

</html>