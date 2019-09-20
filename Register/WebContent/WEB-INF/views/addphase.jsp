<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	var a =document.forms["Form"]["phasedescription"].value;
	var b =document.forms["Form"]["assessmentDate"].value;
	var c =document.forms["Form"]["duration"].value;
	var d =document.forms["Form"]["remarks"].value;
	  if (a==null || a=="",b==null || b=="",c==null || c=="",d==null || d=="")
      {
		alert("please enter all feilds");
	}
	
	}
</script>
	<center>${msg}</center>
		<center><h2>Add phase Data</h2></center>
		<form:form method="POST" action="dophaseform.html"  onsubmit="return validateForm()" name="Form" >
	   		<table align="center">
			    <tr>
			        <td><form:label path="phaseid">Pase ID:</form:label></td>
			        <td><form:input path="phaseid" value="${phase.phaseid}" readonly="true"/></td>
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
			      <td colspan="2"><input type="submit" value="Submit"/></td>
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
  
</div>

<div id="footer">
admin@login.com
</div>

  
	</body>
</html>