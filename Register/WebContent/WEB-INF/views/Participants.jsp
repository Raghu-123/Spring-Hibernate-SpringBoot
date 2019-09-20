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
<head>
<style>
#header {
    background-color:white;
    color:black;
    text-align:center;
    padding:5px;
}
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px;
}
#section {
    width:350px;
    float:left;
    padding:10px;
}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
    padding:5px;
}
</style>
</head>
<body>

<div id="header">
<h1>Welcome to admin page ..</h1>
<hr>
<a href="gotoback.html">Home</a>
<h5 align="right"><a href="getchangeform.html">click here to Change here..!!</a></h5>
<h5 align="right"><a href="getlogoutform.html">logout!</a></h5>
</div>

<div id="nav">
<a href="domodule.html">Add module</a><br><hr>
 <a href="modules.html">modules list</a><br><hr>
<a href ="getphaseform.html">Add Phase</a><hr>
<a href="phases.html">Phase list</a><hr>
<a href="doparticipants.html"> Add participants</a><hr>
<a href="participantslist.html">Participants list</a><hr>
</div>

<div id="section">
<script type="text/javascript">
function validateform()
{
	
	
	var a=document.forms["Form"]["name"].value;
	var b=document.forms["Form"]["basl"].value;
	var c=document.forms["Form"]["email"].value;
	
	if(a==null||a=="",b==null||b=="",c==null||c=="")
		{
		alert("enter the field");
		return false;
		}
	
	
}

</script>


<h2>Add Participants Data</h2>
		<form:form method="POST" action="save1.html"  onsubmit=" return validateform()" name="Form" >
	   		<table>
			    
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
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
		
 <c:if test="${!empty participants}">
		<h2>List Participants</h2>
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
		
 

</div>

<div id="footer">
admin@login.com
</div>
</body>
</html>