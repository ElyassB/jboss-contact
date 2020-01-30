<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts</title>
</head>
<body>
<h2>Liste des contacts</h2>
<ul>	
	<c:forEach items="${contacts }" var="contact" varStatus="index">
		<li>${index.count } ${contact.civilite } ${contact.prenom } ${contact.nom } 
			<a href="AfficherAdressesContactServlet?id=${contact.id }">adresses</a> 	
		</li>
	</c:forEach>
</ul>
</body>
</html>