<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<h4><center>ADD THE MODULE</center></h4>
<form:form action="save.html" method="post" onsubmit="return validateForm()" name="Form" >
		<table align="center">
		
		
		
		 
		 <tr>
			        <td><form:label path="subjecttitle">subjecttitle : </form:label></td>
			        <td><form:input path="subjecttitle"  value="${module.subjecttitle}" /></td>
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
		
		
	
		<tr><td><input type="submit" value="addModule"/></td></tr>
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
	

</div>

<div id="footer">
admin@login.com
</div>


</body>
</html>