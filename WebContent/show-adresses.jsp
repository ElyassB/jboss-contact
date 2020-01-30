<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adresses</title>
</head>
<body>
<%-- <h2>Adresses de ${contact.civilite } ${contact.prenom } ${contact.nom } </h2> --%>

<%-- 	<c:if test="${empty contacts.adresses }"> --%>
<!-- 	<h3>Pas d'adresse pour ce contact</h3> -->
<%-- 	</c:if> --%>
	
<%-- 	<c:if test="${not empty contacts.adresses }"> --%>
<!-- 	<ul>	 -->
	<c:forEach items="${contacts.adresses }" var="contact" varStatus="index">
		<li>${adr.rue } ${adr.codePostal } ${adr.ville } ${adr.pays } </li>
		<a href="AfficherAdresse?id=${adresse.id}">adresses</a>
	</c:forEach>
<!-- 	</ul> -->
<%-- </c:if> --%>
</body>
</html>