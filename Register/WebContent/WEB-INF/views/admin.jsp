<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#header {
    background-color:skyblue;
    color:black;
    text-align:center;
    padding:5px;
}
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:500px;
    width:100px;
    float:left;
    padding:5px;
}
#section {
	background-color:grey;
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
<a href ="dostream1.html" >add stream</a><hr>
<a href="dostreamlist.html">list of streams</a><hr>
</div>
<div id="section">
welcome to admin........${sessionUser}===>${msg}
</div>
<div id="footer">
admin@login.com
</div>
</body>
</html>