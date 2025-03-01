<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<h2>View Member</h2>

<table border="1">
	<tr>
	<th>Member Name</th>
	<th> Age </th>
	<th>Profile Photo</th>
	
	</tr>
	<tr>
		<td>${member.memberName }<br></td>
		<td>${member.age }<br></td>
		<td>${member.profilePhoto }<br></td>

</tr>

</table>
</body>
</html>