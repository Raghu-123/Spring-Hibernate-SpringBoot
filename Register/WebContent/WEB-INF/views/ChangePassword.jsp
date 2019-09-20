<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript">
function check() {
	 var a=document.forms["Form"]["password"].value;
	    var b=document.forms["Form"]["newpassword"].value;
	    var c=document.forms["Form"]["retype"].value;
	   
	    if (a==null || a=="",b==null || b=="",c==null || c=="")
	      {
	      alert("Please Fill All Required Field");
	      return false;
	      }
	    else 
	    	{
	    	if(document.getElementById('newpassword').value == document.getElementById('retype').value) {
        //document.getElementById('message').innerHTML = "match";
        return true;
    } 
	      
    else 

        {
        document.getElementById('message').innerHTML = "password and retype password doesnot match";
        return false;
        }
    }
}
</script>

 </head>
<body>${msg}

<center>
<h1><span id='message'></span></h1>
<form method="post" action="u.html" modelAttribute="cbean" onsubmit="return check()" name="Form" >
       
        Password:<input type="password" name="password" id="password" /><br/>
   		New Password:<input type="password" name="newpassword" id="newpassword" /><br/>
		Retype Password:<input type="password" name="retype" id="retype"/><br/>
        <input type="submit" value="Change" />
        </form>
</center>
</body>
</html>