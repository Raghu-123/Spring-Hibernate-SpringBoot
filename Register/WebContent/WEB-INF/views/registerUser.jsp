<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><title>Register User</title></head>
<body>${msg}


<h2>Registration for New User</h2>
<script type="text/javascript">
    function validateForm()
    {
    var a=document.forms["Form"]["username"].value;
    var b=document.forms["Form"]["emailid"].value;
    var c=document.forms["Form"]["contactno"].value;
    var d=document.forms["Form"]["password"].value;
    if (a==null || a=="",b==null || b=="",c==null || c=="",d==null || d=="")
      {
      alert("Please Fill All Required Field");
      return false;
      }
    }
    </script>

<form:form modelAttribute="userProfile" action="doRegistration.html" method="post"  onsubmit="return validateForm()" name="Form">

	<table align="center">
	<tr><td><form:label path="username">Name:</form:label></td>
	<td><form:input path="username" size="10"/><br></td>
	<td><form:errors path="username"/></td></tr>
		<tr>
			<td><form:label path="emailid" >EmailId:</form:label></td>
			<td><form:input path="emailid" size="10"/></td>
			<td> <font color="red">
				<form:errors path="emailid"/></font></td>
		</tr>
	

	
	
	

	
	<tr><td><form:label path="contactno">MobileNo:</form:label></td>
	<td><form:input path="contactno" size="10"/></td>
	<td><form:errors path="contactno"/></td></tr>
	
	
	
	
	
	<tr><td><form:label path="password">Password:</form:label></td>
	<td><form:password path="password" size="10"/></td>
	<td><form:errors path="password"/></td></tr>
	
	
	
	<tr><td><input type="submit" value="Register"/></td></tr>
	</table>

	

</form:form>

</body>
</html>