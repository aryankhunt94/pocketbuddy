<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>New city</h1>

		<form action="savecity" method="post">
				City Name: <input type="text" name="cityName"> <br><br>
				State Name:
				
				<select  name="stateId">
		<c:forEach items="${allstate }" var="s">
			<option value="${s.stateId }">${s.stateName }</option>
		</c:forEach>
	
	
</select><br><br>

<a href="login"><button type="submit" class="submit-btn">Submit</button></a>
</form>
</body>
</html>