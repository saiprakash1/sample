<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Tenant Enrollment</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2 align="center">List of Renters</h2>  
    <table border="1"
        <tr>
            <td>id</td><td>NAME</td><td>joiningdate</td><td>portionhired</td><td>aan</td><td>leavingdate</td><td>advance</td><td>occupation</td><td>phonenumber</td><td>crowd</td><td>vehiclenumber</td><td>vehicles</td><td>homevillage</td><td>payonline</td>
        </tr>
        <c:forEach items="${renters}" var="renter">
            <tr>
            <td>${renter.id}</td>
            <td>${renter.name}</td>
            <td>${renter.joiningDate}</td>
            <td>${renter.portionhired}</td>
			<td>${renter.aan}</td>
			<td>${renter.leavingDate}</td>
			<td>${renter.advance}</td>
            <td>${renter.occupation}</td>
            <td>${renter.phone_number}</td>
            <td>${renter.crowd}</td>
            <td>${renter.vehicle_number}</td>
            <td>${renter.vehicles}</td>
            <td>${renter.home_village}</td>
            <td>${renter.pay_online}</td>
            <td><a href="<c:url value='/edit-${renter.name}-renter' />">Edit</a></td>
            <td><a href="<c:url value='/delete-${renter.name}-renter' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New Renter</a>
</body>
</html>